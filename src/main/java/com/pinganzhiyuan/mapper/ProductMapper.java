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

public interface ProductMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    long countByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    int deleteByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    @Delete({ "delete from product", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    @Insert({ "insert into product (title, subtitle, ", "is_published, img_url, ", "url, weight, light_title, ",
            "loan_floor, loan_ceiling, ", "duration_floor, duration_ceiling, ", "interest_floor, interest_ceiling, ",
            "credit_auth, lender_name, ", "lender_desc, active_captcha_url, ", "reg_interface_url, publish_time, ",
            "unpublish_time, display_type, ", "charge_mode_id, apply_times, ", "loan_wait_time)",
            "values (#{title,jdbcType=VARCHAR}, #{subtitle,jdbcType=VARCHAR}, ",
            "#{isPublished,jdbcType=BIT}, #{imgUrl,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{weight,jdbcType=INTEGER}, #{lightTitle,jdbcType=VARCHAR}, ",
            "#{loanFloor,jdbcType=INTEGER}, #{loanCeiling,jdbcType=INTEGER}, ",
            "#{durationFloor,jdbcType=INTEGER}, #{durationCeiling,jdbcType=INTEGER}, ",
            "#{interestFloor,jdbcType=DOUBLE}, #{interestCeiling,jdbcType=DOUBLE}, ",
            "#{creditAuth,jdbcType=VARCHAR}, #{lenderName,jdbcType=VARCHAR}, ",
            "#{lenderDesc,jdbcType=VARCHAR}, #{activeCaptchaUrl,jdbcType=VARCHAR}, ",
            "#{regInterfaceUrl,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
            "#{unpublishTime,jdbcType=TIMESTAMP}, #{displayType,jdbcType=TINYINT}, ",
            "#{chargeModeId,jdbcType=BIGINT}, #{applyTimes,jdbcType=INTEGER}, ", "#{loanWaitTime,jdbcType=INTEGER})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    @Select({ "select", "id, title, subtitle, is_published, img_url, url, weight, light_title, loan_floor, ",
            "loan_ceiling, duration_floor, duration_ceiling, interest_floor, interest_ceiling, ",
            "credit_auth, lender_name, lender_desc, active_captcha_url, reg_interface_url, ",
            "publish_time, unpublish_time, display_type, charge_mode_id, apply_times, loan_wait_time", "from product",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.ProductMapper.BaseResultMap")
    Product selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table product
     * @mbg.generated  Thu Dec 14 10:57:09 CST 2017
     */
    @Update({ "update product", "set title = #{title,jdbcType=VARCHAR},", "subtitle = #{subtitle,jdbcType=VARCHAR},",
            "is_published = #{isPublished,jdbcType=BIT},", "img_url = #{imgUrl,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},", "weight = #{weight,jdbcType=INTEGER},",
            "light_title = #{lightTitle,jdbcType=VARCHAR},", "loan_floor = #{loanFloor,jdbcType=INTEGER},",
            "loan_ceiling = #{loanCeiling,jdbcType=INTEGER},", "duration_floor = #{durationFloor,jdbcType=INTEGER},",
            "duration_ceiling = #{durationCeiling,jdbcType=INTEGER},",
            "interest_floor = #{interestFloor,jdbcType=DOUBLE},",
            "interest_ceiling = #{interestCeiling,jdbcType=DOUBLE},", "credit_auth = #{creditAuth,jdbcType=VARCHAR},",
            "lender_name = #{lenderName,jdbcType=VARCHAR},", "lender_desc = #{lenderDesc,jdbcType=VARCHAR},",
            "active_captcha_url = #{activeCaptchaUrl,jdbcType=VARCHAR},",
            "reg_interface_url = #{regInterfaceUrl,jdbcType=VARCHAR},",
            "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
            "unpublish_time = #{unpublishTime,jdbcType=TIMESTAMP},", "display_type = #{displayType,jdbcType=TINYINT},",
            "charge_mode_id = #{chargeModeId,jdbcType=BIGINT},", "apply_times = #{applyTimes,jdbcType=INTEGER},",
            "loan_wait_time = #{loanWaitTime,jdbcType=INTEGER}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(Product record);
}