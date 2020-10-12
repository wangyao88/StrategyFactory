package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 10:01
 */
public interface OneArgStrategy<R, P1> extends IDGenerator {

    R handle(P1 p);
}
