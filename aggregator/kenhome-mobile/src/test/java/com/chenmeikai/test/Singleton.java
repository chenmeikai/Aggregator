/**
 *
 */
package com.chenmeikai.test;

/**
 * 单例模式(饿汉)
 *
 * @author Administrator
 */
public class Singleton {

    private Singleton() {

    }

    private static final Singleton singleton = new Singleton();

    public static Singleton getSingleton() {

        return singleton;
    }

}
