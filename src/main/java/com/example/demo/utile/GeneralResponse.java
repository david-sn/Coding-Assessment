package com.example.demo.utile;

/**
 *
 * @author david
 */
public class GeneralResponse<T> {

    private EResponseStatus status;
    private String message;
    private T result;

    public GeneralResponse(EResponseStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public GeneralResponse(EResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GeneralResponse(EResponseStatus status) {
        this.status = status;
    }

    public EResponseStatus getStatus() {
        return status;
    }

    public void setStatus(EResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
