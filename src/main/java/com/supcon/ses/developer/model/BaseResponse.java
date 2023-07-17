package com.supcon.ses.developer.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/**
 * <p>
 *    通用controller请求响应实体类
 * </p>
 * @author lufengdong
 * @create 2022-09-12 13:54
 */
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> BaseResponse <T> success (T t){
        return new BaseResponse<>(200, "success", t);
    }

    public static BaseResponse<String> success (){
        return new BaseResponse<>(200, "success", "");
    }

    public static BaseResponse<String> fail(String msg){
        return new BaseResponse<>(-1, msg, null);
    }

    public static BaseResponse<String> fail(Integer code, String msg){
        return new BaseResponse<>(code, msg, null);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
