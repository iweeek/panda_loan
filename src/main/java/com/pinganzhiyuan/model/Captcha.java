package com.pinganzhiyuan.model;

import java.util.Date;

public class Captcha {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column captcha.id
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column captcha.captcha
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    private String captcha;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column captcha.is_expired
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    private Boolean isExpired;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column captcha.applied_time
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    private Date appliedTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column captcha.id
     * @return  the value of captcha.id
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column captcha.id
     * @param id  the value for captcha.id
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column captcha.captcha
     * @return  the value of captcha.captcha
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column captcha.captcha
     * @param captcha  the value for captcha.captcha
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column captcha.is_expired
     * @return  the value of captcha.is_expired
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public Boolean getIsExpired() {
        return isExpired;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column captcha.is_expired
     * @param isExpired  the value for captcha.is_expired
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column captcha.applied_time
     * @return  the value of captcha.applied_time
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public Date getAppliedTime() {
        return appliedTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column captcha.applied_time
     * @param appliedTime  the value for captcha.applied_time
     * @mbg.generated  Thu Dec 28 14:39:41 CST 2017
     */
    public void setAppliedTime(Date appliedTime) {
        this.appliedTime = appliedTime;
    }
}