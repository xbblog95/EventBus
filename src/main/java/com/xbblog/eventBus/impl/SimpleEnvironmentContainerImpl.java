package com.xbblog.eventBus.impl;

import com.xbblog.eventBus.bean.config.EventBusConfiguration;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: SimpleEnvironmentContainerImpl
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 20:18
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class SimpleEnvironmentContainerImpl {

    public <T> T getObject(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    public EventBusConfiguration loadConfiguration() {
        return null;
    }
}