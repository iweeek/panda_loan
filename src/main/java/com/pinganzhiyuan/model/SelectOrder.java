package com.pinganzhiyuan.model;

public class SelectOrder {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column select_order.id
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column select_order.name
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column select_order.field
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    private String field;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column select_order.field_order
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    private String fieldOrder;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column select_order.id
     * @return  the value of select_order.id
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column select_order.id
     * @param id  the value for select_order.id
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column select_order.name
     * @return  the value of select_order.name
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column select_order.name
     * @param name  the value for select_order.name
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column select_order.field
     * @return  the value of select_order.field
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public String getField() {
        return field;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column select_order.field
     * @param field  the value for select_order.field
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column select_order.field_order
     * @return  the value of select_order.field_order
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public String getFieldOrder() {
        return fieldOrder;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column select_order.field_order
     * @param fieldOrder  the value for select_order.field_order
     * @mbg.generated  Sun Jan 28 20:01:48 CST 2018
     */
    public void setFieldOrder(String fieldOrder) {
        this.fieldOrder = fieldOrder;
    }
}