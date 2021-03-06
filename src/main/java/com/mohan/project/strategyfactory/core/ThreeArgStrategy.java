package com.mohan.project.strategyfactory.core;

/**
 * @author mohan
 * @since 2020-10-12 10:01
 */
public interface ThreeArgStrategy<R, P1, P2, P3> extends IDGenerator {

    R handle(P1 p1, P2 p2, P3 p3);
}
