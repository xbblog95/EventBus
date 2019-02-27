package com.xbblog.eventBus;

import com.xbblog.eventBus.bean.InvokedMethod;
import com.xbblog.eventBus.enmu.EventMode;
import com.xbblog.utils.ClassUtils;
import com.xbblog.utils.ThreadPoolUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventBusSession
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:43
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public final class EventBusSession {

    //异步事件池
    private final static Map<String, List<InvokedMethod>> asyncEventPool = new HashMap<String, List<InvokedMethod>>();

    //同步事件池
    private final static Map<String, List<InvokedMethod>> syncEventPool = new HashMap<String, List<InvokedMethod>>();

    //遇到系统事件时执行的方法
    private final static Map<String, OnEvent> onEventMap = new HashMap<String, OnEvent>();

    /**
     * 往事件池中加入事件
     * @param eventName
     */
    public  void addInvokedMethod(final String eventName, final InvokedMethod invokedMethod, EventMode eventMode)
    {
        Map<String, List<InvokedMethod>> eventPool;
        switch (eventMode)
        {
            case ASYNCHRONOUS:
            {
                eventPool = asyncEventPool;
                break;
            }
            default:
            {
                eventPool = syncEventPool;
                break;
            }
        }
        List<InvokedMethod> methods = eventPool.get(eventName);
        if(methods == null)
        {
            List<InvokedMethod> list = new ArrayList<InvokedMethod>();
            list.add(invokedMethod);
            eventPool.put(eventName,list);
        }
        else
        {
            methods.add(invokedMethod);
        }
    }

    public void addOnEventTarget(final String eventName, OnEvent onEvent)
    {
        onEventMap.put(eventName, onEvent);
    }


    public void call(final String eventName, final Object[] args) throws Exception {
        //执行异步事件
        List<InvokedMethod> asynclist = asyncEventPool.get(eventName);
        if(asynclist == null || asynclist.size() == 0)
        {
            //todo 无异步事件，应当打日志
        }
        else
        {
            for(final InvokedMethod invokedMethod : asynclist)
            {
                ThreadPoolUtils.execute("sys_EventBus" + eventName, new Runnable() {
                    public void run() {

                        try
                        {
                            ClassUtils.invoke(invokedMethod, args);
                        }
                        catch (Exception e)
                        {
                            onEventMap.get(eventName).onError(eventName, args, e);
                        }
                    }
                });
            }
        }
        //执行同步事件
        List<InvokedMethod> synclist = syncEventPool.get(eventName);
        if(synclist == null || synclist.size() == 0)
        {
            //todo 无同步事件，应当打日志
        }
        else
        {
            for(InvokedMethod invokedMethod : synclist)
            {
                try
                {
                    ClassUtils.invoke(invokedMethod, args);
                    //执行各个方法
                }
                catch (Exception e)
                {
                    Boolean result = onEventMap.get(eventName).onError(eventName, args, e);
                    //查看OnError返回值，true继续执行，false阻断同步方法执行，向外层抛出异常
                    if(result)
                    {
                        continue;
                    }
                    else
                    {
                        throw e;
                    }
                }
            }
        }


    }

}