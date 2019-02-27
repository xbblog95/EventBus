package com.xbblog.eventBus.bean.config;

import com.xbblog.eventBus.enmu.EventMode;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventCalling
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 20:00
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class EventCalling {

    //类路径
    private String className;

    //方法
    private String method;

    //顺序
    private Integer order;

    //模式 异步/同步
    private EventMode eventMode = EventMode.SYNCHRONIZATION;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public EventMode getEventMode() {
        if(eventMode == null)
        {
            return EventMode.SYNCHRONIZATION;
        }
        return eventMode;
    }

    public void setEventMode(EventMode eventMode) {
        this.eventMode = eventMode;
    }
}