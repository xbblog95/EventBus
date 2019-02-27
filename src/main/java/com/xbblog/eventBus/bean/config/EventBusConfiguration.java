package com.xbblog.eventBus.bean.config;

import java.util.List;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventBusConfiguration
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:59
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class EventBusConfiguration {

    //事件总体配置
    private EventConfig eventConfig;

    //事件列表
    private List<Event> events;

    public EventConfig getEventConfig() {
        return eventConfig;
    }

    public void setEventConfig(EventConfig eventConfig) {
        this.eventConfig = eventConfig;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}