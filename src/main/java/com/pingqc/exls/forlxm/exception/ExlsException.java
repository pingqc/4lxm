package com.pingqc.exls.forlxm.exception;

/**
 * Created by pingqc on 16/4/12.
 */
public class ExlsException extends RuntimeException {

    private int code;

    public ExlsException() {
        super();
    }

    public ExlsException(int code) {
        super();
        this.code = code;
    }

    public ExlsException(String msg) {
        super(msg);
    }

    public ExlsException(String msg, Throwable e) {
        super(msg, e);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
