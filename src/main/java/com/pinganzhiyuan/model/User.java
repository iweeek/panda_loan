package com.pinganzhiyuan.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.real_name
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.regist_time
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    private Long registTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.real_name
     *
     * @return the value of user.real_name
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.real_name
     *
     * @param realName the value for user.real_name
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.regist_time
     *
     * @return the value of user.regist_time
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public Long getRegistTime() {
        return registTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.regist_time
     *
     * @param registTime the value for user.regist_time
     *
     * @mbg.generated Mon Dec 04 17:26:16 CST 2017
     */
    public void setRegistTime(Long registTime) {
        this.registTime = registTime;
    }
}