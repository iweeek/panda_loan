package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.LenderAccessLog;
import com.pinganzhiyuan.model.LenderAccessLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface LenderAccessLogMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    long countByExample(LenderAccessLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int deleteByExample(LenderAccessLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Delete({ "delete from lender_access_log", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Insert({ "insert into lender_access_log (p_id, lender_url, ", "device_id, user_id)",
            "values (#{pId,jdbcType=BIGINT}, #{lenderUrl,jdbcType=VARCHAR}, ",
            "#{deviceId,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(LenderAccessLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int insertSelective(LenderAccessLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    List<LenderAccessLog> selectByExample(LenderAccessLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Select({ "select", "id, p_id, lender_url, device_id, user_id", "from lender_access_log",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.LenderAccessLogMapper.BaseResultMap")
    LenderAccessLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") LenderAccessLog record,
            @Param("example") LenderAccessLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByExample(@Param("record") LenderAccessLog record, @Param("example") LenderAccessLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    int updateByPrimaryKeySelective(LenderAccessLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table lender_access_log
     * @mbg.generated  Thu Dec 28 20:29:39 CST 2017
     */
    @Update({ "update lender_access_log", "set p_id = #{pId,jdbcType=BIGINT},",
            "lender_url = #{lenderUrl,jdbcType=VARCHAR},", "device_id = #{deviceId,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=BIGINT}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(LenderAccessLog record);
}