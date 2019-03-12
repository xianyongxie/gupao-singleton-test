package com.gupao.singleton;

/**
 * 线程单例实现 ThreadLocal
 * Created by xuhuan on 2019/3/10.
 * 不能保证对象全局唯一，但是可以保证单线程唯一
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalSingleton =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance(){
        return threadLocalSingleton.get();
    }
}
