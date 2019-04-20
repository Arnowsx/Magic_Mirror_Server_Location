package com.magicmirror.entity;

import java.io.Serializable;

/**
 * device_login_log_table
 * @author 
 */
public class DeviceLoginLog implements Serializable {
    /**
     * 登录事件ID
     */
    private Integer eventId;

    private Integer deviceId;

    private String deviceLoginIp;

    private String deviceLoginLastTime;

    private static final long serialVersionUID = 1L;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceLoginIp() {
        return deviceLoginIp;
    }

    public void setDeviceLoginIp(String deviceLoginIp) {
        this.deviceLoginIp = deviceLoginIp;
    }

    public String getDeviceLoginLastTime() {
        return deviceLoginLastTime;
    }

    public void setDeviceLoginLastTime(String deviceLoginLastTime) {
        this.deviceLoginLastTime = deviceLoginLastTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DeviceLoginLog other = (DeviceLoginLog) that;
        return (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getDeviceLoginIp() == null ? other.getDeviceLoginIp() == null : this.getDeviceLoginIp().equals(other.getDeviceLoginIp()))
            && (this.getDeviceLoginLastTime() == null ? other.getDeviceLoginLastTime() == null : this.getDeviceLoginLastTime().equals(other.getDeviceLoginLastTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getDeviceLoginIp() == null) ? 0 : getDeviceLoginIp().hashCode());
        result = prime * result + ((getDeviceLoginLastTime() == null) ? 0 : getDeviceLoginLastTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventId=").append(eventId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceLoginIp=").append(deviceLoginIp);
        sb.append(", deviceLoginLastTime=").append(deviceLoginLastTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}