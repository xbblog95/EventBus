package com.xbblog.eventBus;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: EventBusSessionFactory
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:43
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class EventBusSessionFactory {

    private static EventBusSession session;

    static {
        session = new EventBusSession();
    }

    public static EventBusSession getSession()
    {
        return session;
    }
}