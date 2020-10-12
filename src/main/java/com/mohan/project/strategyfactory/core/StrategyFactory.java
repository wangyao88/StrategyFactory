package com.mohan.project.strategyfactory.core;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * @author mohan
 * @since 2020-10-10 17:06
 */
public final class StrategyFactory {

    private static final Map<String, AbstractOneArgStrategy> CLASS_NAME_ONE_ARG_STRATEGY_MAP = Maps.newConcurrentMap();
    private static final Map<String, AbstractOneArgStrategy> ID_ONE_ARG_STRATEGY_MAP = Maps.newConcurrentMap();
    
    
    private static final Map<String, AbstractTwoArgStrategy> CLASS_NAME_TWO_ARG_STRATEGY_MAP = Maps.newConcurrentMap();
    private static final Map<String, AbstractTwoArgStrategy> ID_TWO_ARG_STRATEGY_MAP = Maps.newConcurrentMap();
    
    
    private static final Map<String, AbstractThreeArgStrategy> CLASS_NAME_THREE_ARG_STRATEGY_MAP = Maps.newConcurrentMap();
    private static final Map<String, AbstractThreeArgStrategy> ID_THREE_ARG_STRATEGY_MAP = Maps.newConcurrentMap();

    public static void registerOneArg(AbstractOneArgStrategy strategy) {
        String name = strategy.getClass().getName();
        CLASS_NAME_ONE_ARG_STRATEGY_MAP.put(name, strategy);
        String id = strategy.generate();
        AbstractOneArgStrategy oneArgStrategy = ID_ONE_ARG_STRATEGY_MAP.get(id);
        if(oneArgStrategy != null) {
            throw new DuplicateException(oneArgStrategy.getClass().getName(), strategy.getClass().getName());
        }
        ID_ONE_ARG_STRATEGY_MAP.put(id, strategy);
    }

    public static <T extends AbstractOneArgStrategy> Optional<T> getOneArgStrategyByClass(Class<T> strategyClass) {
        boolean valid = valid(strategyClass);
        if (!valid) {
            return Optional.empty();
        }
        AbstractOneArgStrategy oneArgStrategy = CLASS_NAME_ONE_ARG_STRATEGY_MAP.get(strategyClass.getName());
        if (oneArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) oneArgStrategy);
    }

    public static <T extends AbstractOneArgStrategy> Optional<T> getOneArgStrategyById(String id) {
        boolean valid = valid(id);
        if (!valid) {
            return Optional.empty();
        }
        AbstractOneArgStrategy oneArgStrategy = ID_ONE_ARG_STRATEGY_MAP.get(id);
        if (oneArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) oneArgStrategy);
    }

    public static void registerTwoArg(AbstractTwoArgStrategy strategy) {
        String name = strategy.getClass().getName();
        CLASS_NAME_TWO_ARG_STRATEGY_MAP.put(name, strategy);
        String id = strategy.generate();
        AbstractTwoArgStrategy twoArgStrategy = ID_TWO_ARG_STRATEGY_MAP.get(id);
        if(twoArgStrategy != null) {
            throw new DuplicateException(twoArgStrategy.getClass().getName(), strategy.getClass().getName());
        }
        ID_TWO_ARG_STRATEGY_MAP.put(strategy.generate(), strategy);
    }

    public static <T extends AbstractTwoArgStrategy> Optional<T> getTwoArgStrategyByClass(Class<T> strategyClass) {
        boolean valid = valid(strategyClass);
        if (!valid) {
            return Optional.empty();
        }
        AbstractTwoArgStrategy twoArgStrategy = CLASS_NAME_TWO_ARG_STRATEGY_MAP.get(strategyClass.getName());
        if (twoArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) twoArgStrategy);
    }

    public static <T extends AbstractTwoArgStrategy> Optional<T> getTwoArgStrategyById(String id) {
        boolean valid = valid(id);
        if (!valid) {
            return Optional.empty();
        }
        AbstractTwoArgStrategy twoArgStrategy = ID_TWO_ARG_STRATEGY_MAP.get(id);
        if (twoArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) twoArgStrategy);
    }

    public static void registerThreeArg(AbstractThreeArgStrategy strategy) {
        String name = strategy.getClass().getName();
        CLASS_NAME_THREE_ARG_STRATEGY_MAP.put(name, strategy);
        String id = strategy.generate();
        AbstractThreeArgStrategy threeArgStrategy = ID_THREE_ARG_STRATEGY_MAP.get(id);
        if(threeArgStrategy != null) {
            throw new DuplicateException(threeArgStrategy.getClass().getName(), strategy.getClass().getName());
        }
        ID_THREE_ARG_STRATEGY_MAP.put(strategy.generate(), strategy);
    }

    public static <T extends AbstractThreeArgStrategy> Optional<T> getThreeArgStrategyByClass(Class<T> strategyClass) {
        boolean valid = valid(strategyClass);
        if (!valid) {
            return Optional.empty();
        }
        AbstractThreeArgStrategy threeArgStrategy = CLASS_NAME_THREE_ARG_STRATEGY_MAP.get(strategyClass.getName());
        if (threeArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) threeArgStrategy);
    }

    public static <T extends AbstractThreeArgStrategy> Optional<T> getThreeArgStrategyById(String id) {
        boolean valid = valid(id);
        if (!valid) {
            return Optional.empty();
        }
        AbstractThreeArgStrategy threeArgStrategy = ID_THREE_ARG_STRATEGY_MAP.get(id);
        if (threeArgStrategy == null) {
            return Optional.empty();
        }
        return Optional.of((T) threeArgStrategy);
    }

    private static boolean valid(Object strategy) {
        if (StrategyManager.throwable != null) {
            throw StrategyManager.throwable;
        }
        if (!StrategyManager.INIT.get()) {
            throw new NotInitializationException();
        }
        if (strategy == null) {
            return false;
        }
        return true;
    }
}