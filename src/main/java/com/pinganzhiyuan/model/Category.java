package com.pinganzhiyuan.model;

public class Category {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column category.id
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column category.title
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column category.id
     * @return  the value of category.id
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column category.id
     * @param id  the value for category.id
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column category.title
     * @return  the value of category.title
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column category.title
     * @param title  the value for category.title
     * @mbg.generated  Sat Dec 16 16:47:12 CST 2017
     */
    public void setTitle(String title) {
        this.title = title;
    }
}