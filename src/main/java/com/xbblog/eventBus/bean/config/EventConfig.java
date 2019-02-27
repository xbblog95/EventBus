package com.xbblog.eventBus.bean.config;

import com.xbblog.eventBus.OnEvent;
import com.xbblog.eventBus.container.EnvironmentContainer;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventConfig
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:59
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class EventConfig {

    //全局事件触发对象
    private OnEvent onEvent;

    //外部容器
    private EnvironmentContainer environmentContainer;

    public OnEvent getOnEvent() {
        return onEvent;
    }

    public void setOnEvent(OnEvent onEvent) {
        this.onEvent = onEvent;
    }

    public EnvironmentContainer getEnvironmentContainer() {
        return environmentContainer;
    }

    public void setEnvironmentContainer(EnvironmentContainer environmentContainer) {
        this.environmentContainer = environmentContainer;
    }
}