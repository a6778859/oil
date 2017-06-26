package com.oil.upms.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Admin implements Serializable {
    private Integer userid;

    /**
     * 账号
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String userpassword;

    /**
     * 密码错误次数
     *
     * @mbg.generated
     */
    private Integer errorcount;

    /**
     * 加锁时间(加锁时间为1个钟头)
     *
     * @mbg.generated
     */
    private Date locktime;

    /**
     * 1为正常  2为锁住状态
     *
     * @mbg.generated
     */
    private Integer lockstate;

    /**
     * 剩余金额
     *
     * @mbg.generated
     */
    private BigDecimal totalmoney;

    /**
     * 录入时间
     *
     * @mbg.generated
     */
    private Date addtime;

    /**
     * 更改时间
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * 状态 1为正常   2为异常
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     * 用户权限
     *
     * @mbg.generated
     */
    private String roleId;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getErrorcount() {
        return errorcount;
    }

    public void setErrorcount(Integer errorcount) {
        this.errorcount = errorcount;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    public Integer getLockstate() {
        return lockstate;
    }

    public void setLockstate(Integer lockstate) {
        this.lockstate = lockstate;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", userpassword=").append(userpassword);
        sb.append(", errorcount=").append(errorcount);
        sb.append(", locktime=").append(locktime);
        sb.append(", lockstate=").append(lockstate);
        sb.append(", totalmoney=").append(totalmoney);
        sb.append(", addtime=").append(addtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", state=").append(state);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
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
        Admin other = (Admin) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserpassword() == null ? other.getUserpassword() == null : this.getUserpassword().equals(other.getUserpassword()))
            && (this.getErrorcount() == null ? other.getErrorcount() == null : this.getErrorcount().equals(other.getErrorcount()))
            && (this.getLocktime() == null ? other.getLocktime() == null : this.getLocktime().equals(other.getLocktime()))
            && (this.getLockstate() == null ? other.getLockstate() == null : this.getLockstate().equals(other.getLockstate()))
            && (this.getTotalmoney() == null ? other.getTotalmoney() == null : this.getTotalmoney().equals(other.getTotalmoney()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
        result = prime * result + ((getErrorcount() == null) ? 0 : getErrorcount().hashCode());
        result = prime * result + ((getLocktime() == null) ? 0 : getLocktime().hashCode());
        result = prime * result + ((getLockstate() == null) ? 0 : getLockstate().hashCode());
        result = prime * result + ((getTotalmoney() == null) ? 0 : getTotalmoney().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}