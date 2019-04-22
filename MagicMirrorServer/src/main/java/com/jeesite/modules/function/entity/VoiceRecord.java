package com.jeesite.modules.function.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * voice_record_table
 * @author 
 */
public class VoiceRecord implements Serializable {
    private Integer recordId;

    private Integer voiceType;

    private String voiceText;

    private Integer deviceId;

    private byte[] voiceFileBlob;

    private static final long serialVersionUID = 1L;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(Integer voiceType) {
        this.voiceType = voiceType;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public byte[] getVoiceFileBlob() {
        return voiceFileBlob;
    }

    public void setVoiceFileBlob(byte[] voiceFileBlob) {
        this.voiceFileBlob = voiceFileBlob;
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
        VoiceRecord other = (VoiceRecord) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getVoiceType() == null ? other.getVoiceType() == null : this.getVoiceType().equals(other.getVoiceType()))
            && (this.getVoiceText() == null ? other.getVoiceText() == null : this.getVoiceText().equals(other.getVoiceText()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (Arrays.equals(this.getVoiceFileBlob(), other.getVoiceFileBlob()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getVoiceType() == null) ? 0 : getVoiceType().hashCode());
        result = prime * result + ((getVoiceText() == null) ? 0 : getVoiceText().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + (Arrays.hashCode(getVoiceFileBlob()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", voiceType=").append(voiceType);
        sb.append(", voiceText=").append(voiceText);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", voiceFileBlob=").append(voiceFileBlob);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}