package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 17:03
 */
public abstract class AbstractThreeArgStrategy<R, P1, P2, P3> implements ThreeArgStrategy<R, P1, P2, P3>, IDGenerator {

    @Override
    public String generate() {
        return this.getClass().getSimpleName();
    }
}