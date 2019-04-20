package com.magicmirror.entity;

import java.io.Serializable;

/**
 * note_table
 * @author 
 */
public class Note implements Serializable {
    /**
     * 日志ID
     */
    private Integer noteId;

    private String saveTime;

    private String text;

    private Integer deviceId;

    private static final long serialVersionUID = 1L;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
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
        Note other = (Note) that;
        return (this.getNoteId() == null ? other.getNoteId() == null : this.getNoteId().equals(other.getNoteId()))
            && (this.getSaveTime() == null ? other.getSaveTime() == null : this.getSaveTime().equals(other.getSaveTime()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteId() == null) ? 0 : getNoteId().hashCode());
        result = prime * result + ((getSaveTime() == null) ? 0 : getSaveTime().hashCode());
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
        sb.append(", noteId=").append(noteId);
        sb.append(", saveTime=").append(saveTime);
        sb.append(", text=").append(text);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}