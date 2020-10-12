package com.mohan.project.strategyfactory.example;

import com.mohan.project.strategyfactory.core.AbstractThreeArgStrategy;

/**
 * @author mohan
 * @since 2020-10-12 09:37
 */
public class Strategy3 extends AbstractThreeArgStrategy<String, String, String, Integer> {

    @Override
    public String handle(String param1, String param2, Integer param3) {
        return "Strategy3 " + param1 + param2 + param3;
    }

    @Override
    public String generate() {
        return "Strategy3";
    }
}