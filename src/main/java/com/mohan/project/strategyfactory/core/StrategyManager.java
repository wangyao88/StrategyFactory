package com.mohan.project.strategyfactory.core;

import org.reflections.Reflections;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author mohan
 * @since 2020-10-12 09:33
 */
public final class StrategyManager {

    static final AtomicBoolean INIT = new AtomicBoolean(false);
    static RuntimeException throwable;

    public synchronized static void init(String path) {
        try {
            registerOneArg(path);
            registerTwoArg(path);
            registerThreeArg(path);
            INIT.set(true);
        } catch (Exception e) {
            RegisterException registerException = new RegisterException(e);
            throwable = registerException;
            INIT.set(false);
            throw registerException;
        }
    }

    public synchronized static void batchInit(String... paths) {
        if(INIT.get()) {
            return;
        }
        for (String path : paths) {
            init(path);
            if (!INIT.get()) {
                break;
            }
        }
    }

    private static void registerOneArg(String path) throws Exception {
        Reflections reflections = new Reflections(path);
        Set<Class<? extends OneArgStrategy>> strategyClasses = reflections.getSubTypesOf(OneArgStrategy.class);
        for (Class<? extends OneArgStrategy> strategyClass : strategyClasses) {
            OneArgStrategy strategy = strategyClass.newInstance();
            StrategyFactory.registerOneArg(strategy);
        }
    }

    private static void registerTwoArg(String path) throws Exception {
        Reflections reflections = new Reflections(path);
        Set<Class<? extends TwoArgStrategy>> strategyClasses = reflections.getSubTypesOf(TwoArgStrategy.class);
        for (Class<? extends TwoArgStrategy> strategyClass : strategyClasses) {
            TwoArgStrategy strategy = strategyClass.newInstance();
            StrategyFactory.registerTwoArg(strategy);
        }
    }

    private static void registerThreeArg(String path) throws Exception {
        Reflections reflections = new Reflections(path);
        Set<Class<? extends ThreeArgStrategy>> strategyClasses = reflections.getSubTypesOf(ThreeArgStrategy.class);
        for (Class<? extends ThreeArgStrategy> strategyClass : strategyClasses) {
            ThreeArgStrategy strategy = strategyClass.newInstance();
            StrategyFactory.registerThreeArg(strategy);
        }
    }
}