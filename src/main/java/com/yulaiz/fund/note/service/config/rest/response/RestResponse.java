package com.yulaiz.fund.note.service.config.rest.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResponse<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public RestResponse() {
    }

    public RestResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
