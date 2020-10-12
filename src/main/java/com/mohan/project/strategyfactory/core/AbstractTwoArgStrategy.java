package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 17:03
 */
public abstract class AbstractTwoArgStrategy<R, P1, P2> implements TwoArgStrategy<R, P1, P2>, IDGenerator {

    @Override
    public String generate() {
        return this.getClass().getSimpleName();
    }
}