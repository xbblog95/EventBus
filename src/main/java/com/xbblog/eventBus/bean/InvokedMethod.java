package com.xbblog.eventBus.bean;


/**
 * Copyright (C), 2014-2019, 江苏车置宝信息科技股份有限公司
 * FileName: InvokedClass
 * Author:   fangchao - fangchao@chezhibao.com
 * Date:     2019/2/25 19:47
 * Description: 模块目的、功能描述
 * History: 修改记录
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
public class InvokedMethod {

    private Object obj;

    private String methodName;


    public InvokedMethod(Object obj, String methodName) {
        this.obj = obj;
        this.methodName = methodName;
    }

    public InvokedMethod() {
    }


    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}