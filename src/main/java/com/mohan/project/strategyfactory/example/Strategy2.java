package com.mohan.project.strategyfactory.example;

import com.mohan.project.strategyfactory.core.TwoArgStrategy;

/**
 * @author mohan
 * @since 2020-10-12 09:37
 */
public class Strategy2 implements TwoArgStrategy<String, String, Integer> {

    @Override
    public String handle(String param1, Integer param2) {
        return "Strategy2 " + param1 + param2;
    }

    @Override
    public String generate() {
        return "Strategy2";
    }
}