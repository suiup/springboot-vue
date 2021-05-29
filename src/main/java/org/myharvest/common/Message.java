package org.myharvest.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

/**
 * message wrapper class
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message<T> {

    private String msg = "OK";
    private int code = HttpStatus.OK.value();
    private T data;

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Message(){

    }

    public static Message success(){
        return new Message(HttpStatus.OK.value(), "");
    }

    public static Message success(String msg){
        return new Message(HttpStatus.OK.value(), msg);
    }

    public static Message success(String msg, Object data){
        return new Message(HttpStatus.OK.value(), msg, data);
    }


    public boolean isSuccess() {
        return this.code == HttpStatus.OK.value() || this.code == 0;
    }

    public static Message fail(String msg){
        return new Message(HttpStatus.NO_CONTENT.value(), msg);
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
