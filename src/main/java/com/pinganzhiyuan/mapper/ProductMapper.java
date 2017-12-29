package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.Product;
import com.pinganzhiyuan.model.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import com.pinganzhiyuan.model.ProductKey;

public interface ProductMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    long countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Delete({ "delete from product", "where id = #{id,jdbcType=BIGINT}",
            "and apply_times = #{applyTimes,jdbcType=INTEGER}" })
    int deleteByPrimaryKey(ProductKey key);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Insert({ "insert into product (apply_times, title, ", "is_new, first_tags, second_tags, ",
            "description, is_published, ", "img_url, url, weight, ", "light_title, edu, ", "min_amount, max_amount, ",
            "min_term, max_term, ", "low_interest, high_interest, ", "credit_auth, lender_name, ",
            "lender_desc, active_captcha_url, ", "reg_interface_url, publish_time, ", "unpublish_time, display_type, ",
            "charge_mode_id, loan_wait_time)", "values (#{applyTimes,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
            "#{isNew,jdbcType=BIT}, #{firstTags,jdbcType=VARCHAR}, #{secondTags,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR}, #{isPublished,jdbcType=BIT}, ",
            "#{imgUrl,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{weight,jdbcType=INTEGER}, ",
            "#{lightTitle,jdbcType=VARCHAR}, #{edu,jdbcType=VARCHAR}, ",
            "#{minAmount,jdbcType=INTEGER}, #{maxAmount,jdbcType=INTEGER}, ",
            "#{minTerm,jdbcType=INTEGER}, #{maxTerm,jdbcType=INTEGER}, ",
            "#{lowInterest,jdbcType=DOUBLE}, #{highInterest,jdbcType=DOUBLE}, ",
            "#{creditAuth,jdbcType=VARCHAR}, #{lenderName,jdbcType=VARCHAR}, ",
            "#{lenderDesc,jdbcType=VARCHAR}, #{activeCaptchaUrl,jdbcType=VARCHAR}, ",
            "#{regInterfaceUrl,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
            "#{unpublishTime,jdbcType=TIMESTAMP}, #{displayType,jdbcType=TINYINT}, ",
            "#{chargeModeId,jdbcType=BIGINT}, #{loanWaitTime,jdbcType=INTEGER})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Select({ "select", "id, apply_times, title, is_new, first_tags, second_tags, description, is_published, ",
            "img_url, url, weight, light_title, edu, min_amount, max_amount, min_term, max_term, ",
            "low_interest, high_interest, credit_auth, lender_name, lender_desc, active_captcha_url, ",
            "reg_interface_url, publish_time, unpublish_time, display_type, charge_mode_id, ", "loan_wait_time",
            "from product", "where id = #{id,jdbcType=BIGINT}", "and apply_times = #{applyTimes,jdbcType=INTEGER}" })
    @ResultMap("com.pinganzhiyuan.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(ProductKey key);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Update({ "update product", "set title = #{title,jdbcType=VARCHAR},", "is_new = #{isNew,jdbcType=BIT},",
            "first_tags = #{firstTags,jdbcType=VARCHAR},", "second_tags = #{secondTags,jdbcType=VARCHAR},",
            "description = #{description,jdbcType=VARCHAR},", "is_published = #{isPublished,jdbcType=BIT},",
            "img_url = #{imgUrl,jdbcType=VARCHAR},", "url = #{url,jdbcType=VARCHAR},",
            "weight = #{weight,jdbcType=INTEGER},", "light_title = #{lightTitle,jdbcType=VARCHAR},",
            "edu = #{edu,jdbcType=VARCHAR},", "min_amount = #{minAmount,jdbcType=INTEGER},",
            "max_amount = #{maxAmount,jdbcType=INTEGER},", "min_term = #{minTerm,jdbcType=INTEGER},",
            "max_term = #{maxTerm,jdbcType=INTEGER},", "low_interest = #{lowInterest,jdbcType=DOUBLE},",
            "high_interest = #{highInterest,jdbcType=DOUBLE},", "credit_auth = #{creditAuth,jdbcType=VARCHAR},",
            "lender_name = #{lenderName,jdbcType=VARCHAR},", "lender_desc = #{lenderDesc,jdbcType=VARCHAR},",
            "active_captcha_url = #{activeCaptchaUrl,jdbcType=VARCHAR},",
            "reg_interface_url = #{regInterfaceUrl,jdbcType=VARCHAR},",
            "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
            "unpublish_time = #{unpublishTime,jdbcType=TIMESTAMP},", "display_type = #{displayType,jdbcType=TINYINT},",
            "charge_mode_id = #{chargeModeId,jdbcType=BIGINT},", "loan_wait_time = #{loanWaitTime,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}", "and apply_times = #{applyTimes,jdbcType=INTEGER}" })
    int updateByPrimaryKey(Product record);
}