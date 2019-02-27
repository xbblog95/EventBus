package com.xbblog.eventBus.enmu;


public enum EventMode {

    //异步
    ASYNCHRONOUS(1, "asynchronous"),

    //同步
    SYNCHRONIZATION(2, "synchronization");

    private String mode;

    private int code;

    private EventMode(int code, String mode)
    {
        this.code = code;
        this.mode = mode;
    }

    public int getCode() {
        return code;
    }
}
