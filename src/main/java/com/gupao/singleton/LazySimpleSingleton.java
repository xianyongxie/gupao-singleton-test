package com.gupao.singleton;

/**
 * 懒汉式单例
 * Created by xuhuan on 2019/3/10.
 * 被外部类调用时候才会被创建实例
 */

//这种方式纯在线程不安全，可能会同时创建多个对象
/*public class LazySimpleSingleton {

    //1，私有构造方法
    private LazySimpleSingleton(){}

    //2,定义私有对象
    private static LazySimpleSingleton lazySimpleSingleton = null;

    //3，创建共有的方法返回实例
    public static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton==null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}*/



/*
 * 解决上面线程不安全的问题
 * 但是这种方式在高并发情况下会产生阻塞
 */
public class LazySimpleSingleton {

    //1，私有构造方法
    private LazySimpleSingleton(){}

    //2,定义私有对象
    private static LazySimpleSingleton lazySimpleSingleton = null;

    //3，创建共有的方法返回实例
    public synchronized static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton==null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
