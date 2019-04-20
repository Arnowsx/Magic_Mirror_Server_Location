package com.magicmirror.entity;

import java.io.Serializable;

/**
 * device_login_info_table
 * @author 
 */
public class DeviceLoginInfo implements Serializable {
    /**
     * 设备ID
     */
    private String deviceLoginId;

    /**
     * 设备密钥
     */
    private String devicePwdKey;

    private Integer deviceId;

    private static final long serialVersionUID = 1L;

    public String getDeviceLoginId() {
        return deviceLoginId;
    }

    public void setDeviceLoginId(String deviceLoginId) {
        this.deviceLoginId = deviceLoginId;
    }

    public String getDevicePwdKey() {
        return devicePwdKey;
    }

    public void setDevicePwdKey(String devicePwdKey) {
        this.devicePwdKey = devicePwdKey;
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
        DeviceLoginInfo other = (DeviceLoginInfo) that;
        return (this.getDeviceLoginId() == null ? other.getDeviceLoginId() == null : this.getDeviceLoginId().equals(other.getDeviceLoginId()))
            && (this.getDevicePwdKey() == null ? other.getDevicePwdKey() == null : this.getDevicePwdKey().equals(other.getDevicePwdKey()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeviceLoginId() == null) ? 0 : getDeviceLoginId().hashCode());
        result = prime * result + ((getDevicePwdKey() == null) ? 0 : getDevicePwdKey().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceLoginId=").append(deviceLoginId);
        sb.append(", devicePwdKey=").append(devicePwdKey);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}