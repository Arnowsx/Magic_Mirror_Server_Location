package com.magicmirror.utils;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerReponse<T> implements Serializable {

    private int status;
    private String message;
    private T res;
    private String token;
    private long total;
    private ServerReponse(int status){
        this.status = status;
    }

    private ServerReponse(int status, T res){
        this.status = status;
        this.res = res;
    }

    private ServerReponse(int status, T res, long total){
        this.status = status;
        this.res= res;
        this.total = total;
    }

    private ServerReponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    private ServerReponse(int status, String message, T res){
        this.status = status;
        this.message = message;
        this.res = res;
    }

    private ServerReponse(int status, String message, T res, long total){
        this.status = status;
        this.message = message;
        this.res = res;
        this.total = total;
    }

    @JsonIgnore
    public boolean isSUccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getRes() {
        return res;
    }

    public long getTotal() {
        return total;
    }

    public static <T> ServerReponse<T> createBySuccess(String message){
        return new ServerReponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerReponse<T> createBySuccess(T res){
        return new ServerReponse<T>(ResponseCode.SUCCESS.getCode(), res);
    }

    public static <T> ServerReponse<T> createBySuccess(T res, long total){
        return new ServerReponse<T>(ResponseCode.SUCCESS.getCode(), res, total);
    }

    public static <T> ServerReponse<T> createBySuccess(String message, T res){
        return new ServerReponse<T>(ResponseCode.SUCCESS.getCode(), message, res);
    }

    public static <T> ServerReponse<T> createBySuccess(String message, T res, long total){
        return new ServerReponse<T>(ResponseCode.SUCCESS.getCode(), message, res, total);
    }

    public static <T> ServerReponse<T> createByServerError(String message){
        return new ServerReponse<T>(ResponseCode.SERVERERROR.getCode(), message);
    }

}
