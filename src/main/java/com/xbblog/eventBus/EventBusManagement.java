package com.xbblog.eventBus;

import com.xbblog.eventBus.bean.config.EventBusConfiguration;
import com.xbblog.utils.ConfigUtils;


public class EventBusManagement {

    private static EventBusConfiguration eventBusConfiguration;


    public static void init(EventBusConfiguration configuration)
    {
        eventBusConfiguration = configuration;
        ConfigUtils.configInit(configuration);
    }

    public static Object getObject(String classMame)
    {
        Object obj;
        try
        {
            obj = eventBusConfiguration.getEventConfig().getEnvironmentContainer().getObject(classMame);
        }
        catch (Exception e)
        {
            //todo e
            return null;
        }
        return obj;
    }

}
