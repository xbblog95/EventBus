package com.xbblog.utils;

import com.xbblog.eventBus.bean.InvokedMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ClassUtils {

    /**
     * 执行方法
     * @param invokedMethod
     * @param param
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void invoke(InvokedMethod invokedMethod, Object... param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object obj = invokedMethod.getObj();
        Method method = findMethod(invokedMethod, param);
        method.invoke(obj, param);
    }



    /**
     * 寻找方法
     * @param invokedMethod
     * @param param
     * @return
     * @throws NoSuchMethodException
     */
    private static Method findMethod(InvokedMethod invokedMethod, Object... param) throws NoSuchMethodException {
        Object obj = invokedMethod.getObj();
        Class clazz = obj.getClass();
        clazz.getMethods();
        Method method = clazz.getMethod(invokedMethod.getMethodName(), findClass(param));
        return method;
    }

    /**
     * 获取每个参数的类
     * @param param
     * @return
     */
    private  static  Class[] findClass(Object... param)
    {
        if(param == null || param.length == 0)
        {
            return new Class[0];
        }
        Class[] classes = new Class[param.length];
        for(int i = 0; i < param.length; i++)
        {
            classes[i] = param[i].getClass();
        }
        return classes;
    }
}
