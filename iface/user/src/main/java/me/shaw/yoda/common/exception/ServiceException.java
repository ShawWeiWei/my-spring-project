package me.shaw.yoda.common.exception;

/**
 * Created by yes on 7/5/16.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -1426052906926974174L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceException(String code) {

        this.code = code;
    }

    public ServiceException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
