package com.xbblog.eventBus.bean.config;

import com.xbblog.eventBus.OnEvent;

import java.util.List;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: Event
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 20:00
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class Event {

    //事件名称
    private String name;

    //响应的方法
    private List<EventCalling> calls;

    //同步的响应方法报错时执行的方法
    private OnEvent onEvent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventCalling> getCalls() {
        return calls;
    }

    public void setCalls(List<EventCalling> calls) {
        this.calls = calls;
    }

    public OnEvent getOnEvent() {
        return onEvent;
    }

    public void setOnEvent(OnEvent onEvent) {
        this.onEvent = onEvent;
    }
}