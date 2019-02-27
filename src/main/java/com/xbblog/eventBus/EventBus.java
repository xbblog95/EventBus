package com.xbblog.eventBus;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventBus
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:39
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class EventBus {


    public static void call(final String eventName, final Object... args) throws Exception {
        EventBusSessionFactory.getSession().call(eventName, args);
    }
}