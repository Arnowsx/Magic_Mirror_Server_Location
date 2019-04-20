package com.magicmirror.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * wake_up_word_table
 * @author 
 */
public class WakeUpWord implements Serializable {
    /**
     * 唤醒词ID
     */
    private Integer wordId;

    /**
     * 唤醒词文字内容
     */
    private String wordContent;

    private Integer deviceId;

    /**
     * 唤醒词二进制
     */
    private byte[] wordBlob;

    private static final long serialVersionUID = 1L;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public byte[] getWordBlob() {
        return wordBlob;
    }

    public void setWordBlob(byte[] wordBlob) {
        this.wordBlob = wordBlob;
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
        WakeUpWord other = (WakeUpWord) that;
        return (this.getWordId() == null ? other.getWordId() == null : this.getWordId().equals(other.getWordId()))
            && (this.getWordContent() == null ? other.getWordContent() == null : this.getWordContent().equals(other.getWordContent()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (Arrays.equals(this.getWordBlob(), other.getWordBlob()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWordId() == null) ? 0 : getWordId().hashCode());
        result = prime * result + ((getWordContent() == null) ? 0 : getWordContent().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + (Arrays.hashCode(getWordBlob()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wordId=").append(wordId);
        sb.append(", wordContent=").append(wordContent);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", wordBlob=").append(wordBlob);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}