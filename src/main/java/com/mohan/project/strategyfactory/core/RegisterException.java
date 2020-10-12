package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 14:58
 */
public class RegisterException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "策略管理器尚未初始化！请先执行 StrategyManager.init(path); path：要扫描的包路径";

    public RegisterException() {
        super(DEFAULT_MESSAGE);
    }

    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterException(Throwable cause) {
        super(cause);
    }

    public RegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}