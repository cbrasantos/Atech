package br.com.atech.empresaarea.dao;


import org.springframework.http.HttpStatus;

public class TransferDto<T> {

    private HttpStatus httpStatus;
    private String description;
    private T t = null;

    public TransferDto(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public TransferDto(HttpStatus httpStatus, T t) {
        this(httpStatus);
        this.t = t;
    }

    public TransferDto(HttpStatus httpStatus, String description) {
        this(httpStatus);
        this.description = description;
    }

    public TransferDto(HttpStatus httpStatus, String description, T t) {
        this(httpStatus,t);
        this.description = description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "TransferDto{" +
                " \"httpStatus\":" + httpStatus +
                ", \"description\":" + "\"" + description + "\"" +
                ", \"t\"=" + t +
                '}';
    }

}
