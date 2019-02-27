package com.xbblog.eventBus;

import java.lang.reflect.Method;

public interface OnEvent {

    /**
     * 当响应方法执行报错时，触发该事件
     * @param e 异常
     * @return 返回值只对同步方法有效，true，同步方法继续执行，false,阻断同步方法执行，向外层抛出异常
     */
    public Boolean onError(final String eventName, final Object[] args, Exception e);


    /**
     *  当响应方法执行前执行
     * @param eventName
     * @param args
     * @return false阻止执行，中止所有同步响应
     */
    public Boolean onBeforeEvent(Method method, final String eventName, final Object[] args);


    /**
     *  当响应方法执行后执行
     * @param eventName
     * @param args
     * @return false阻止执行，中止所有同步响应
     */
    public void onAfterEvent(Method method, final String eventName, final Object[] args);
}
