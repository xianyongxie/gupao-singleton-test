package com.gupao.singleton;

/**
 * 静态内部类创建单例
 * Created by xuhuan on 2019/3/10.
 *  优点：及解决了饿汉式的内存浪费，
 *  也解决了懒汉式的线程安全问题，
 *  也解决了synchronized的性能问题
 */
public class LazyInnerClassSingleton {

    //1，构造方法私有化
    //反射破坏单例，如果使用反射可以多次创建对象，而且创建的对象不同，怎么解决呢？
//    private LazyInnerClassSingleton(){}
    private LazyInnerClassSingleton(){
        if (LazyHandler.lazy != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //2，共用方法返回对象
    //static 是为了使单例的空间共享
    //final 保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHandler.lazy;
    }

    //3，创建私有类，返回对象，
    // 内部类默认不加载，当使用LazyInnerClassSingleton类的时候会先加载内部类
    private static class LazyHandler{
        private static final LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }
}
