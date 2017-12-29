package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.SMSLog;
import com.pinganzhiyuan.model.SMSLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SMSLogMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    long countByExample(SMSLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int deleteByExample(SMSLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Delete({ "delete from sms_log", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Insert({ "insert into sms_log (capt_id, phone, ", "req_msg, resp_msg, ", "send_time, channel_id)",
            "values (#{captId,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, ",
            "#{reqMsg,jdbcType=VARCHAR}, #{respMsg,jdbcType=VARCHAR}, ",
            "#{sendTime,jdbcType=TIMESTAMP}, #{channelId,jdbcType=TINYINT})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(SMSLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int insertSelective(SMSLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    List<SMSLog> selectByExample(SMSLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Select({ "select", "id, capt_id, phone, req_msg, resp_msg, send_time, channel_id", "from sms_log",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.SMSLogMapper.BaseResultMap")
    SMSLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") SMSLog record, @Param("example") SMSLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExample(@Param("record") SMSLog record, @Param("example") SMSLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByPrimaryKeySelective(SMSLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table sms_log
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Update({ "update sms_log", "set capt_id = #{captId,jdbcType=BIGINT},", "phone = #{phone,jdbcType=VARCHAR},",
            "req_msg = #{reqMsg,jdbcType=VARCHAR},", "resp_msg = #{respMsg,jdbcType=VARCHAR},",
            "send_time = #{sendTime,jdbcType=TIMESTAMP},", "channel_id = #{channelId,jdbcType=TINYINT}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(SMSLog record);


}