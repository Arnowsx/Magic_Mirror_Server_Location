package com.magicmirror.entity;

import java.io.Serializable;

/**
 * device_info_table
 * @author 
 */
public class DeviceInfo implements Serializable {

    public static enum DeviceStatusEnum{
        ONLINE(1, "设备在线"),
        OFFLINE(0, "设备离线");

        private int code;
        private String statusText;

        DeviceStatusEnum(int code, String statusText) {
            this.code = code;
            this.statusText = statusText;
        }

        public int getCode() {
            return code;
        }

        public String getStatusText() {
            return statusText;
        }
    }

    /**
     * 设备ID
     */
    private Integer deviceId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备MAC地址
     */
    private String deviceMac;

    /**
     * 设备类型
     */
    private Integer deviceType;

    private DeviceStatusEnum deviceStatus;

    private static final long serialVersionUID = 1L;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceStatusEnum getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatusEnum deviceStatus) {
        this.deviceStatus = deviceStatus;
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
        DeviceInfo other = (DeviceInfo) that;
        return (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDeviceMac() == null ? other.getDeviceMac() == null : this.getDeviceMac().equals(other.getDeviceMac()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getDeviceStatus() == null ? other.getDeviceType() == null : this.getDeviceStatus().equals(other.getDeviceStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDeviceMac() == null) ? 0 : getDeviceMac().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getDeviceStatus() == null) ? 0 : getDeviceStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceId=").append(deviceId);
        sb.append(", name=").append(name);
        sb.append(", deviceMac=").append(deviceMac);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceStatus=").append(deviceStatus.getStatusText());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}