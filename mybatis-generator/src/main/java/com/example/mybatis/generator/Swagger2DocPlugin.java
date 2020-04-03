package com.example.mybatis.generator;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class Swagger2DocPlugin extends PluginAdapter {
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 自定义 swagger2 doc 插件
     *
     * @param field
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String classAnnotation = "@ApiModel(value = \"" + topLevelClass.getType().getShortName() + "\", description = \"" + introspectedTable.getRemarks() + "\")";
        if (!topLevelClass.getAnnotations().contains(classAnnotation)) {
            topLevelClass.addAnnotation(classAnnotation);
        }

        String apiModelAnnotationPackage = properties.getProperty("apiModelAnnotationPackage");
        String apiModelPropertyAnnotationPackage = properties.getProperty("apiModelPropertyAnnotationPackage");
        if (null == apiModelAnnotationPackage) apiModelAnnotationPackage = "io.swagger.annotations.ApiModel";
        if (null == apiModelPropertyAnnotationPackage)
            apiModelPropertyAnnotationPackage = "io.swagger.annotations.ApiModelProperty";

        topLevelClass.addImportedType(apiModelAnnotationPackage);
        topLevelClass.addImportedType(apiModelPropertyAnnotationPackage);

        field.addAnnotation("@ApiModelProperty(name = \"" + introspectedColumn.getJavaProperty() + "\", value = \"" + (introspectedColumn.getRemarks() == null ? introspectedColumn.getJavaProperty() : introspectedColumn.getRemarks()) + "\")");
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }
}