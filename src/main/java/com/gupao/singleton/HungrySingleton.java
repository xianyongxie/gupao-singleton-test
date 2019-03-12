package com.gupao.singleton;

/**
 * 饿汉式单例
 * Created by xuhuan on 2019/3/10.
 * 饿汉式单例是在类加载的时候初始化创建对象，属于线程安全的。
 * 优点：没有使用锁，执行效率高。
 * 缺点：类加载的时候就创建对象，可能浪费内存
 * 适用于单例对象较少的情况
 */
public class HungrySingleton {

    //1，创建私有的对象
    private static final HungrySingleton hungSingleton = new HungrySingleton();

    //2，构造方法私有化
    private HungrySingleton(){}

    //3，提供返回对象的唯一方法
    public static HungrySingleton getInstance(){
        return hungSingleton;
    }
}
