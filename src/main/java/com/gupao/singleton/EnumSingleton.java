package com.gupao.singleton;

/**
 * 枚举式单例 枚举本身就是单例的
 * Created by xuhuan on 2019/3/10.
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
