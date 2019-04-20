package com.magicmirror.entity;

import java.io.Serializable;

/**
 * smoke_warn_table
 * @author 
 */
public class SmokeWarn implements Serializable {
    /**
     * 烟雾警报ID
     */
    private Integer eventId;

    private String time;

    private Float data;

    private Integer deviceId;

    private static final long serialVersionUID = 1L;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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
        SmokeWarn other = (SmokeWarn) that;
        return (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventId=").append(eventId);
        sb.append(", time=").append(time);
        sb.append(", data=").append(data);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}