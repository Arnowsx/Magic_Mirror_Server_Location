package com.magicmirror.entity;

import java.io.Serializable;

/**
 * news_table
 * @author 
 */
public class News implements Serializable {
    /**
     * 新闻ID
     */
    private Integer newsId;

    private String time;

    private String text;

    private Integer deviceId;

    private static final long serialVersionUID = 1L;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        News other = (News) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", time=").append(time);
        sb.append(", text=").append(text);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}