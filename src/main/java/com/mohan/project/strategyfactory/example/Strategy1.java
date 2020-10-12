package com.mohan.project.strategyfactory.example;

import com.mohan.project.strategyfactory.core.AbstractOneArgStrategy;

/**
 * @author mohan
 * @since 2020-10-12 09:37
 */
public class Strategy1 extends AbstractOneArgStrategy<String, String> {

    @Override
    public String handle(String param) {
        return "Strategy1 " + param;
    }

    @Override
    public String generate() {
        return "Override Strategy1";
    }
}