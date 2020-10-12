package com.mohan.project.strategyfactory.example;

import com.mohan.project.strategyfactory.core.StrategyFactory;
import com.mohan.project.strategyfactory.core.StrategyManager;

/**
 * @author mohan
 * @since 2020-10-12 13:06
 */
class Main {

    public static void main(String[] args) {
        StrategyManager.init("com.mohan.project.strategyfactory");
        StrategyFactory.getOneArgStrategyByClass(Strategy1.class).ifPresent(strategy1 -> {
            System.out.println(strategy1.handle("qweqwe"));
        });

        StrategyFactory.getTwoArgStrategyByClass(Strategy2.class).ifPresent(strategy2 -> {
            System.out.println(strategy2.handle("qq ", 1));
        });

        StrategyFactory.getThreeArgStrategyByClass(Strategy3.class).ifPresent(strategy3 -> {
            System.out.println(strategy3.handle("qq ", "ddf ", 1));
        });

        StrategyFactory.getOneArgStrategyById("Strategy1").ifPresent(strategy1 -> {
            System.out.println(strategy1.handle("qweqwe"));
        });

        StrategyFactory.getTwoArgStrategyById("Strategy2").ifPresent(strategy2 -> {
            System.out.println(strategy2.handle("qq ", 1));
        });
    }
}