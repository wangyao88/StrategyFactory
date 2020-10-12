package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 14:58
 */
public class NotInitializationException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "策略管理器尚未初始化！请先执行 StrategyManager.init(path); path：要扫描的包路径";

    public NotInitializationException() {
        super(DEFAULT_MESSAGE);
    }

    public NotInitializationException(String message) {
        super(message);
    }

    public NotInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotInitializationException(Throwable cause) {
        super(cause);
    }

    public NotInitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}