package com.mohan.project.strategyfactory.example;

import com.mohan.project.strategyfactory.core.OneArgStrategy;

/**
 * @author mohan
 * @since 2020-10-12 09:37
 */
public class Strategy1 implements OneArgStrategy<String, String> {

    @Override
    public String handle(String param) {
        return "Strategy1 " + param;
    }

    @Override
    public String generate() {
        return "Strategy1";
    }
}