package com.xbblog.eventBus.impl;

import com.xbblog.eventBus.OnEvent;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: SimpleOnEventImpl
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 20:42
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class SimpleOnEventImpl implements OnEvent {

    public Boolean onError(final String eventName, final Object[] args, Exception e) {
        return false;
    }

    public Boolean onBeforeEvent(Method method, String eventName, Object[] args) {
        return true;
    }

    public void onAfterEvent(Method method, String eventName, Object[] args) {
        return;
    }
}