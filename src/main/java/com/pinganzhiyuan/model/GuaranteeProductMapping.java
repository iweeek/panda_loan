package com.pinganzhiyuan.model;

public class GuaranteeProductMapping {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_product_mapping.id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_product_mapping.guarantee_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    private Long guaranteeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column guarantee_product_mapping.product_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    private Long productId;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_product_mapping.id
     * @return  the value of guarantee_product_mapping.id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_product_mapping.id
     * @param id  the value for guarantee_product_mapping.id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_product_mapping.guarantee_id
     * @return  the value of guarantee_product_mapping.guarantee_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public Long getGuaranteeId() {
        return guaranteeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_product_mapping.guarantee_id
     * @param guaranteeId  the value for guarantee_product_mapping.guarantee_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public void setGuaranteeId(Long guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column guarantee_product_mapping.product_id
     * @return  the value of guarantee_product_mapping.product_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column guarantee_product_mapping.product_id
     * @param productId  the value for guarantee_product_mapping.product_id
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}