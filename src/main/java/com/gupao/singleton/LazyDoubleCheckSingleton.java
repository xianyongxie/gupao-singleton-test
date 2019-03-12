package com.gupao.singleton;

/**
 * 双重检查锁单例
 * Created by xuhuan on 2019/3/10.
 * 双重检查所单例能够减少懒汉式的阻塞，但是还是存在阻塞
 *
 */
public class LazyDoubleCheckSingleton {

    //1，申明volatile对象，主要解决多线程指令重排序和多线程之间对象可见性
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    //2,构造方法私有化
    private LazyDoubleCheckSingleton(){}

    //3，创建对外返回对象的共有方法
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton==null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }

        return lazyDoubleCheckSingleton;
    }
}
