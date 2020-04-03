package com.example.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用官方mybatis-generator生成mybatis映射
 * mybatis-generator配置文件在/src/main/resources/generatorConfig-SupportDbCenter.xml
 *
 * @author PD
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp
                .parseConfiguration(Main.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        // 清除先前已生成的mapper xmls
        cleanAutoGeneratedXmlDir(config, shellCallback);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("Mybatis generator runned successfully.");
        if (warnings.size() > 0) {
            System.out.println("\r\nWith warnings");
            for (String warning : warnings) {
                System.out.println(warning);
            }
        }

        System.out.println("\r\nRefresh your infrastructure project to see the latest db mode/mapper/mapperxml");
    }

    /**
     * 对于先前已生成的mapper xml, Mybatis3 generator会做append操作。目前没有入口配置为overwrite。
     * 因此，需要此方法在自动生成程序运行之前，清除以前生成的mapper xmls。
     *
     * @param config
     * @param shellCallback
     * @throws ShellException
     * @throws IOException
     */
    private static void cleanAutoGeneratedXmlDir(Configuration config, ShellCallback shellCallback)
            throws ShellException, IOException {
        File directory = shellCallback.getDirectory(
                config.getContexts().get(0).getSqlMapGeneratorConfiguration().getTargetProject(),
                config.getContexts().get(0).getSqlMapGeneratorConfiguration().getTargetPackage());
        //FileUtils.cleanDirectory(directory);
    }
}
