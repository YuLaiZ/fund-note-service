package com.yulaiz.fund.note.service.config.rest.response;

public class RestResponseBuilder<T> {
    public static final String REST_RESPONSE_SUCCESS_CODE = "0";
    public static final String REST_RESPONSE_SUCCESS_MESSAGE = "成功";
    public static final String REST_RESPONSE_FAIL_CODE = "-1";
    public static final String REST_RESPONSE_FAIL_MESSAGE = "失败";

    private RestResponse response;

    private RestResponseBuilder(String code, String message, T data) {
        this.response = new RestResponse(code, message, data);
    }

    public static <T> RestResponseBuilder createSuccessBuilder() {
        return new RestResponseBuilder(REST_RESPONSE_SUCCESS_CODE, REST_RESPONSE_SUCCESS_MESSAGE, null);
    }

    public static <T> RestResponseBuilder createSuccessBuilder(T data) {
        return new RestResponseBuilder(REST_RESPONSE_SUCCESS_CODE, REST_RESPONSE_SUCCESS_MESSAGE, data);
    }

    public static RestResponseBuilder createSuccessBuilder(String code, String message) {
        return new RestResponseBuilder(code, message, null);
    }

    public static <T> RestResponseBuilder createSuccessBuilder(String code, String message, T data) {
        return new RestResponseBuilder(code, message, data);
    }

    public static RestResponseBuilder createFailBuilder() {
        return new RestResponseBuilder(REST_RESPONSE_FAIL_CODE, REST_RESPONSE_FAIL_MESSAGE, null);
    }

    public static RestResponseBuilder createFailBuilder(String message) {
        return new RestResponseBuilder(REST_RESPONSE_FAIL_CODE, message, null);
    }

    public static RestResponseBuilder createFailBuilder(String code, String message) {
        return new RestResponseBuilder(code, message, null);
    }

    public static <T> RestResponseBuilder createFailBuilder(String code, String message, T data) {
        return new RestResponseBuilder(code, message, data);
    }

    public RestResponseBuilder setMessage(String message) {
        this.response.setMessage(message);
        return this;
    }

    public <T> RestResponseBuilder setResult(T data) {
        this.response.setData(data);
        return this;
    }

    public RestResponse builder() {
        return this.response;
    }
}
