package com.xbblog.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: ThreadPoolUtils
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 17:24
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class ThreadPoolUtils {

    private static Map<String, ExecutorService> THREADPOOLS;

    static{
        THREADPOOLS = new HashMap<String, ExecutorService>();
    }

    public static void execute(String poolkey, Runnable runnable)
    {
        if(THREADPOOLS.get(poolkey) == null)
        {
            ExecutorService service = Executors.newCachedThreadPool();
            THREADPOOLS.put(poolkey, service);
        }
        THREADPOOLS.get(poolkey).execute(runnable);
    }

}