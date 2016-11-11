package com.starikov;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Start fetching data from dataBase!");
    }
}
