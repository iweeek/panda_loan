package com.pinganzhiyuan.model;

import java.util.Date;

public class Product extends ProductKey {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String title;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.is_new
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Boolean isNew;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.first_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String firstTags;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.second_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String secondTags;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.description
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String description;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.is_published
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Boolean isPublished;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.img_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String imgUrl;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String url;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.weight
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer weight;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.light_title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String lightTitle;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.edu
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String edu;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.min_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer minAmount;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.max_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer maxAmount;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.min_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer minTerm;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.max_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer maxTerm;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.low_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Double lowInterest;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.high_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Double highInterest;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.credit_auth
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String creditAuth;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.lender_name
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String lenderName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.lender_desc
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String lenderDesc;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.active_captcha_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String activeCaptchaUrl;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.reg_interface_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private String regInterfaceUrl;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.publish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Date publishTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.unpublish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Date unpublishTime;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.display_type
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Byte displayType;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.charge_mode_id
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Long chargeModeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column product.loan_wait_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    private Integer loanWaitTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.title
     * @return  the value of product.title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.title
     * @param title  the value for product.title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.is_new
     * @return  the value of product.is_new
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.is_new
     * @param isNew  the value for product.is_new
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.first_tags
     * @return  the value of product.first_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getFirstTags() {
        return firstTags;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.first_tags
     * @param firstTags  the value for product.first_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setFirstTags(String firstTags) {
        this.firstTags = firstTags;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.second_tags
     * @return  the value of product.second_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getSecondTags() {
        return secondTags;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.second_tags
     * @param secondTags  the value for product.second_tags
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setSecondTags(String secondTags) {
        this.secondTags = secondTags;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.description
     * @return  the value of product.description
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.description
     * @param description  the value for product.description
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.is_published
     * @return  the value of product.is_published
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Boolean getIsPublished() {
        return isPublished;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.is_published
     * @param isPublished  the value for product.is_published
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.img_url
     * @return  the value of product.img_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.img_url
     * @param imgUrl  the value for product.img_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.url
     * @return  the value of product.url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.url
     * @param url  the value for product.url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.weight
     * @return  the value of product.weight
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.weight
     * @param weight  the value for product.weight
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.light_title
     * @return  the value of product.light_title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getLightTitle() {
        return lightTitle;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.light_title
     * @param lightTitle  the value for product.light_title
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setLightTitle(String lightTitle) {
        this.lightTitle = lightTitle;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.edu
     * @return  the value of product.edu
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getEdu() {
        return edu;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.edu
     * @param edu  the value for product.edu
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setEdu(String edu) {
        this.edu = edu;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.min_amount
     * @return  the value of product.min_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getMinAmount() {
        return minAmount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.min_amount
     * @param minAmount  the value for product.min_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.max_amount
     * @return  the value of product.max_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getMaxAmount() {
        return maxAmount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.max_amount
     * @param maxAmount  the value for product.max_amount
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.min_term
     * @return  the value of product.min_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getMinTerm() {
        return minTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.min_term
     * @param minTerm  the value for product.min_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setMinTerm(Integer minTerm) {
        this.minTerm = minTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.max_term
     * @return  the value of product.max_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getMaxTerm() {
        return maxTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.max_term
     * @param maxTerm  the value for product.max_term
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setMaxTerm(Integer maxTerm) {
        this.maxTerm = maxTerm;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.low_interest
     * @return  the value of product.low_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Double getLowInterest() {
        return lowInterest;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.low_interest
     * @param lowInterest  the value for product.low_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setLowInterest(Double lowInterest) {
        this.lowInterest = lowInterest;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.high_interest
     * @return  the value of product.high_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Double getHighInterest() {
        return highInterest;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.high_interest
     * @param highInterest  the value for product.high_interest
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setHighInterest(Double highInterest) {
        this.highInterest = highInterest;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.credit_auth
     * @return  the value of product.credit_auth
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getCreditAuth() {
        return creditAuth;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.credit_auth
     * @param creditAuth  the value for product.credit_auth
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setCreditAuth(String creditAuth) {
        this.creditAuth = creditAuth;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.lender_name
     * @return  the value of product.lender_name
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getLenderName() {
        return lenderName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.lender_name
     * @param lenderName  the value for product.lender_name
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.lender_desc
     * @return  the value of product.lender_desc
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getLenderDesc() {
        return lenderDesc;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.lender_desc
     * @param lenderDesc  the value for product.lender_desc
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setLenderDesc(String lenderDesc) {
        this.lenderDesc = lenderDesc;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.active_captcha_url
     * @return  the value of product.active_captcha_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getActiveCaptchaUrl() {
        return activeCaptchaUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.active_captcha_url
     * @param activeCaptchaUrl  the value for product.active_captcha_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setActiveCaptchaUrl(String activeCaptchaUrl) {
        this.activeCaptchaUrl = activeCaptchaUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.reg_interface_url
     * @return  the value of product.reg_interface_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public String getRegInterfaceUrl() {
        return regInterfaceUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.reg_interface_url
     * @param regInterfaceUrl  the value for product.reg_interface_url
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setRegInterfaceUrl(String regInterfaceUrl) {
        this.regInterfaceUrl = regInterfaceUrl;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.publish_time
     * @return  the value of product.publish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.publish_time
     * @param publishTime  the value for product.publish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.unpublish_time
     * @return  the value of product.unpublish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Date getUnpublishTime() {
        return unpublishTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.unpublish_time
     * @param unpublishTime  the value for product.unpublish_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setUnpublishTime(Date unpublishTime) {
        this.unpublishTime = unpublishTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.display_type
     * @return  the value of product.display_type
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Byte getDisplayType() {
        return displayType;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.display_type
     * @param displayType  the value for product.display_type
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setDisplayType(Byte displayType) {
        this.displayType = displayType;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.charge_mode_id
     * @return  the value of product.charge_mode_id
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Long getChargeModeId() {
        return chargeModeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.charge_mode_id
     * @param chargeModeId  the value for product.charge_mode_id
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setChargeModeId(Long chargeModeId) {
        this.chargeModeId = chargeModeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column product.loan_wait_time
     * @return  the value of product.loan_wait_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public Integer getLoanWaitTime() {
        return loanWaitTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column product.loan_wait_time
     * @param loanWaitTime  the value for product.loan_wait_time
     * @mbg.generated  Sat Dec 23 09:48:31 CST 2017
     */
    public void setLoanWaitTime(Integer loanWaitTime) {
        this.loanWaitTime = loanWaitTime;
    }
}