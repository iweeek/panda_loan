package com.pinganzhiyuan.model;

public class GuaranteeTypeMapping {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_type_mapping.id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_type_mapping.guarantee_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    private Long guaranteeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_type_mapping.product_type_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    private Long productTypeId;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_type_mapping.id
     * @return  the value of guarantee_type_mapping.id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_type_mapping.id
     * @param id  the value for guarantee_type_mapping.id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_type_mapping.guarantee_id
     * @return  the value of guarantee_type_mapping.guarantee_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_type_mapping.guarantee_id
     * @param guaranteeId  the value for guarantee_type_mapping.guarantee_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_type_mapping.product_type_id
     * @return  the value of guarantee_type_mapping.product_type_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public Long getProductTypeId() {
        return productTypeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_type_mapping.product_type_id
     * @param productTypeId  the value for guarantee_type_mapping.product_type_id
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }
}