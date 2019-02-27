package com.xbblog.eventBus.container;


public interface EnvironmentContainer {


    /**
     * 获取对象
     * @param String 类的className
     * @param <T> 类的一个对象
     * @return 类的一个对象
     */
    public <T> T getObject(String className) throws Exception;
}
