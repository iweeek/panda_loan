package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.MidAd;
import com.pinganzhiyuan.model.MidAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MidAdMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    long countByExample(MidAdExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int deleteByExample(MidAdExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Delete({ "delete from mid_ad", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Insert({ "insert into mid_ad (name, icon_url, ", "url, product_id, description)",
            "values (#{name,jdbcType=VARCHAR}, #{iconUrl,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{productId,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(MidAd record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int insertSelective(MidAd record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    List<MidAd> selectByExample(MidAdExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Select({ "select", "id, name, icon_url, url, product_id, description", "from mid_ad",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.MidAdMapper.BaseResultMap")
    MidAd selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") MidAd record, @Param("example") MidAdExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByExample(@Param("record") MidAd record, @Param("example") MidAdExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByPrimaryKeySelective(MidAd record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table mid_ad
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Update({ "update mid_ad", "set name = #{name,jdbcType=VARCHAR},", "icon_url = #{iconUrl,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},", "product_id = #{productId,jdbcType=BIGINT},",
            "description = #{description,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(MidAd record);
}