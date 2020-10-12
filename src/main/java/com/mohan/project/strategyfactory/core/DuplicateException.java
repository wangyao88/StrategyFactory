package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 14:58
 */
public class DuplicateException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "策略ID重复";

    public DuplicateException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String oldStrategy, String newStrategy) {
        super(oldStrategy + "的ID与" + newStrategy + "的ID重复");
    }

    public DuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(Throwable cause) {
        super(cause);
    }

    public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}