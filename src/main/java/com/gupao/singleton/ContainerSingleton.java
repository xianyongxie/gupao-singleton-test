package com.gupao.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例 容器缓存的写法
 * Created by xuhuan on 2019/3/10.
 * 适合创建多个单例
 */
public class ContainerSingleton {
    //1，私有构造方法
    private ContainerSingleton(){}

    //2，创建ConcurrentHashMap
    private static Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    //3，创建单例对象并返回
    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }else {
                return ioc.get(className);
            }
        }
    }
}
