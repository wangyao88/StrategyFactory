package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 17:03
 */
public abstract class AbstractOneArgStrategy<R, P1> implements OneArgStrategy<R, P1>, IDGenerator {

    @Override
    public String generate() {
        return this.getClass().getSimpleName();
    }
}