package com.ahmad.backendhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@NoArgsConstructor
public class GeneralResponseModel<T> {
    private String message;
    private String code;
    private T data;

    public GeneralResponseModel(
            @JsonProperty("message") String message,
            @JsonProperty("code") String code,
            @JsonProperty("data") T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public  GeneralResponseModel<T> successAck(){
        return new GeneralResponseModel<T>("success",
                "200",
                null);
    }
    public GeneralResponseModel<T> error( String message,
                                                    String code
                                                    ){
        return new GeneralResponseModel<T>(message,
                code,
                null);
    }
    public  GeneralResponseModel<T> successWithData(T t){
        return new GeneralResponseModel<T>("success",
                "200",
                t);
    }
}
