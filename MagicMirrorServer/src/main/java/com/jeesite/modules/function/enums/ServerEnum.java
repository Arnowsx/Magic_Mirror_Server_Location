package com.jeesite.modules.function.enums;

/**
 * created by Arnowsx on 2019/4/12
 */
public enum ServerEnum {
    SUCCESS(1, "成功"),
    FAILED(0, "失败"),
    SQLERROR(-1, "数据库错误"),
    INNER_ERROR(-2, "系统异常"),
    EMPTYBYTES(-3, "二进制异常"),
    QUALITY_ERROR(-4,"录音不清晰"),

    //匹配命令返回参数
    IS_OPENCLOCK(1001, "打开闹钟"),
    IS_CLOSECLOK(1002, "关闭闹钟"),
    IS_OPENLOG(1003, "打开日志"),
    IS_WRITELOG(1004, "写入日志"),
    IS_SAVELOG(1005, "保存日志"),
    IS_CLOSELOG(1006, "关闭日志"),
    MATCH_ERROR(1000, "匹配错误"),
    IS_WEATHER(1009,"查看天气"),
    ;


    private int state;

    private String stateInfo;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    ServerEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ServerEnum stateOf(int index) {
        for(ServerEnum state: values()) {
            if(state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
