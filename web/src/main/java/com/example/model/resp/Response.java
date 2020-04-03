package com.example.model.resp;

import com.example.enums.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应类
 *
 * @param <T>
 * @author goshine
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Response", description = "返回对象")
public class Response<T> {

    @ApiModelProperty(value = "状态编码：0为OK")
    private int code;
    @ApiModelProperty(value = "处理结果描述")
    private String msg;
    @ApiModelProperty(value = "返回的对象信息")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 处理成功返回
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> success() {

        return result(ErrorCodeEnum.NONE, "success", null);
    }

    /**
     * 处理成功返回
     *
     * @return
     */
    public static <T> Response<T> success(T obj) {

        return result(ErrorCodeEnum.NONE, "success", obj);
    }

    /**
     * 处理成功返回
     *
     * @return
     */
    public static <T> Response<T> success(T obj, String msg) {

        return result(ErrorCodeEnum.NONE, msg, obj);
    }

    /**
     * 处理成功返回
     *
     * @return
     */
    public static <T> Response<T> success(String msg) {

        return result(ErrorCodeEnum.NONE, msg, null);
    }

    /**
     * 处理异常返回
     *
     * @param msg
     * @return
     */

    public static <T> Response<T> error(String msg) {
        return result(ErrorCodeEnum.FAIL, msg, null);
    }

    public static <T> Response<T> error(ErrorCodeEnum codeEnum, String msg) {
        return result(codeEnum, msg, null);
    }

    public static <T> Response<T> error(ErrorCodeEnum codeEnum, String msg, T obj) {
        return result(codeEnum, msg, obj);
    }

    public static <T> Response<T> result(ErrorCodeEnum codeEnum, String msg, T obj) {
        Response<T> response = new Response<T>();

        response.setMsg(msg);
        response.setCode(codeEnum.getCode());
        response.setData(obj);
        return response;
    }

}