package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 10:01
 */
interface IDGenerator {

    /**
     * 生成ID
     * @return ID
     */
    String generate();

    /**
     * 默认ID生成方法
     * @param clazz 策略类 类型
     * @return 默认ID
     */
    default String defaultGenerate(Class<?> clazz) {
        return clazz.getSimpleName();
    }

}
