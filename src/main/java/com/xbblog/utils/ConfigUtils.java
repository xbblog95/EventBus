package com.xbblog.utils;

import com.xbblog.eventBus.EventBusManagement;
import com.xbblog.eventBus.EventBusSessionFactory;
import com.xbblog.eventBus.OnEvent;
import com.xbblog.eventBus.bean.InvokedMethod;
import com.xbblog.eventBus.bean.config.Event;
import com.xbblog.eventBus.bean.config.EventBusConfiguration;
import com.xbblog.eventBus.bean.config.EventCalling;
import com.xbblog.eventBus.container.EnvironmentContainer;
import com.xbblog.eventBus.enmu.EventMode;
import com.xbblog.eventBus.impl.SimpleOnEventImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConfigUtils {

    /**
     * 配置初始化
     * @param configuration
     */
    public static void configInit(EventBusConfiguration configuration)
    {
        if(configuration == null)
        {
            return;
        }
        EnvironmentContainer environmentContainer = configuration.getEventConfig().getEnvironmentContainer();
        if(environmentContainer == null)
        {
            //todo 外部容器未配置
            return;
        }
        OnEvent onEvent = configuration.getEventConfig().getOnEvent();
        if(onEvent == null)
        {
            configuration.getEventConfig().setOnEvent(new SimpleOnEventImpl());
        }
        List<Event> list = configuration.getEvents();
        if(list == null || list.size() == 0)
        {
            return;
        }
        for(Event event : list)
        {
            eventInit(event);
        }
    }

    /**
     * 初始化事件对象
     * @param event
     */
    private static void eventInit(Event event)
    {
        if(event.getName() == null)
        {
            //todo 事件名为null，该事件配置被抛弃
            return;
        }
        EventBusSessionFactory.getSession().addOnEventTarget(event.getName(), onEventInit(event));
        List<EventCalling> calls = event.getCalls();
        if(calls != null && calls.size() != 0)
        {
            //对事件排序
            Collections.sort(calls, new Comparator<EventCalling>()
            {
                public int compare(EventCalling o1, EventCalling o2) {
                    return o1.getOrder() - o2.getOrder();
                }
            });
            //初始化响应事件
            for(EventCalling eventCalling : calls)
            {
                InvokedMethod invokedMethod = callInit(eventCalling);
                if(invokedMethod == null)
                {
                    //todo 未解析该配置 事件名：{eventName}, 响应的方法名：{methodName}, 响应的类路径{className}
                    continue;
                }
                else
                {
                    EventBusSessionFactory.getSession().addInvokedMethod(event.getName(), invokedMethod, eventCalling.getEventMode());
                }
            }
        }
    }

    /**
     * 初始化onEvent配置
     * @param event
     * @return
     */
    private static OnEvent onEventInit(Event event)
    {
        OnEvent onEvent;
        if(event.getOnEvent() == null)
        {
            onEvent = new SimpleOnEventImpl();
        }
        else
        {
            onEvent = event.getOnEvent();
        }
        return onEvent;
    }

    /**
     * 解析响应对象
     * @param calling
     * @return
     */
    private static InvokedMethod callInit(EventCalling calling)
    {
        if(calling == null)
        {
            return null;
        }
        if(calling.getClassName() == null || "".equals(calling.getClassName()))
        {
            //todo 没有配置类路径
            return null;
        }
        if(calling.getMethod() == null || "".equals(calling.getMethod()))
        {
            //todo 没有配置方法名
            return null;
        }
        if(calling.getOrder() == null)
        {
            calling.setOrder(Integer.MAX_VALUE);
        }
        if(calling.getEventMode() == null)
        {
            calling.setEventMode(EventMode.SYNCHRONIZATION);
        }
        String className = calling.getClassName();
        //从上下文容器获取对象
        Object obj = EventBusManagement.getObject(className);
        if(obj == null)
        {
            //todo className为{className}找不到该对象
            return null;
        }
        //方法名
        String methodName = calling.getMethod();
        return  new InvokedMethod(obj, methodName);
    }
}
