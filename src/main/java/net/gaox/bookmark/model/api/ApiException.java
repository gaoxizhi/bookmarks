package net.gaox.bookmark.model.api;

/**
 * <p> API异常 </p>
 *
 * @author gaox·Eric
 * @site gaox.net
 * @date 2019/12/14 13:18
 */
public class ApiException extends RuntimeException {
    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    protected ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}