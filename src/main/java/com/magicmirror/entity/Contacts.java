package com.magicmirror.entity;

import java.io.Serializable;

/**
 * contacts_table
 * @author 
 */
public class Contacts implements Serializable {
    /**
     * 联系人ID
     */
    private Integer contactId;

    private String contactName;

    private String telephone;

    private String weixin;

    private String qq;

    private static final long serialVersionUID = 1L;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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
        Contacts other = (Contacts) that;
        return (this.getContactId() == null ? other.getContactId() == null : this.getContactId().equals(other.getContactId()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContactId() == null) ? 0 : getContactId().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactId=").append(contactId);
        sb.append(", contactName=").append(contactName);
        sb.append(", telephone=").append(telephone);
        sb.append(", weixin=").append(weixin);
        sb.append(", qq=").append(qq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}