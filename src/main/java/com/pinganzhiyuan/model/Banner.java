package com.pinganzhiyuan.model;

public class Banner {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column banner.id
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column banner.credit_ceiling
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    private Integer creditCeiling;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column banner.rate
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    private Integer rate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column banner.slide_news
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    private String slideNews;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column banner.id
     * @return  the value of banner.id
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column banner.id
     * @param id  the value for banner.id
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column banner.credit_ceiling
     * @return  the value of banner.credit_ceiling
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public Integer getCreditCeiling() {
        return creditCeiling;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column banner.credit_ceiling
     * @param creditCeiling  the value for banner.credit_ceiling
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public void setCreditCeiling(Integer creditCeiling) {
        this.creditCeiling = creditCeiling;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column banner.rate
     * @return  the value of banner.rate
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column banner.rate
     * @param rate  the value for banner.rate
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column banner.slide_news
     * @return  the value of banner.slide_news
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public String getSlideNews() {
        return slideNews;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column banner.slide_news
     * @param slideNews  the value for banner.slide_news
     * @mbg.generated  Thu Dec 07 14:42:33 CST 2017
     */
    public void setSlideNews(String slideNews) {
        this.slideNews = slideNews;
    }
}