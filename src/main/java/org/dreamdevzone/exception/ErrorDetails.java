package org.dreamdevzone.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String detail;
    public ErrorDetails(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }
}
