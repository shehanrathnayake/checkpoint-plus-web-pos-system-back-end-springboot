package com.shehanrathnayake.exception;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class AppException extends RuntimeException{
    private final int errorCode;

    public AppException(int errorCode) {
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

}
