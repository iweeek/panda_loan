package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.LandingChannel;
import com.pinganzhiyuan.model.LandingChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface LandingChannelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	long countByExample(LandingChannelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	int deleteByExample(LandingChannelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	@Delete({ "delete from landing_channel", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	@Insert({ "insert into landing_channel (name, channel_uid)",
			"values (#{name,jdbcType=VARCHAR}, #{channelUid,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(LandingChannel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	int insertSelective(LandingChannel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	List<LandingChannel> selectByExample(LandingChannelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	@Select({ "select", "id, name, channel_uid", "from landing_channel", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.LandingChannelMapper.BaseResultMap")
	LandingChannel selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	int updateByExampleSelective(@Param("record") LandingChannel record,
			@Param("example") LandingChannelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	int updateByExample(@Param("record") LandingChannel record, @Param("example") LandingChannelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	int updateByPrimaryKeySelective(LandingChannel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_channel
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	@Update({ "update landing_channel", "set name = #{name,jdbcType=VARCHAR},",
			"channel_uid = #{channelUid,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(LandingChannel record);
}