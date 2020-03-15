package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + " in");
        Object invoke = method.invoke(original, args);
        System.out.println(method.getName() + " out");
        return invoke;
    }

    public Object invoke_MyV1(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        if (method.getName().equals("stringMethodWithoutArgs")) {
            System.out.println("stringMethodWithoutArgs in");
            invoke = method.invoke(original, args);
            System.out.println("stringMethodWithoutArgs out");
        }
        if (method.getName().equals("voidMethodWithIntArg")) {
            System.out.println("voidMethodWithIntArg in");
//            method.invoke(original, args);
            //  inside voidMethodWithIntArg
            // inside voidMethodWithoutArgs
            invoke = method.invoke(original, args);
            System.out.println("voidMethodWithIntArg out");
        }
        return invoke;
    }
}
