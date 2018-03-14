package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.TDDevice;
import com.pinganzhiyuan.model.TDDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TDDeviceMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	long countByExample(TDDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	int deleteByExample(TDDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	@Delete({ "delete from td_device", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	@Insert({ "insert into td_device (package_name, channel_id, ", "device_id, send_flag, ", "regist_date)",
			"values (#{packageName,jdbcType=VARCHAR}, #{channelId,jdbcType=BIGINT}, ",
			"#{deviceId,jdbcType=VARCHAR}, #{sendFlag,jdbcType=BIT}, ", "#{registDate,jdbcType=DATE})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(TDDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	int insertSelective(TDDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	List<TDDevice> selectByExample(TDDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	@Select({ "select", "id, package_name, channel_id, device_id, send_flag, regist_date", "from td_device",
			"where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.TDDeviceMapper.BaseResultMap")
	TDDevice selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TDDevice record, @Param("example") TDDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	int updateByExample(@Param("record") TDDevice record, @Param("example") TDDeviceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	int updateByPrimaryKeySelective(TDDevice record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_device
	 * @mbg.generated  Wed Mar 14 11:28:14 CST 2018
	 */
	@Update({ "update td_device", "set package_name = #{packageName,jdbcType=VARCHAR},",
			"channel_id = #{channelId,jdbcType=BIGINT},", "device_id = #{deviceId,jdbcType=VARCHAR},",
			"send_flag = #{sendFlag,jdbcType=BIT},", "regist_date = #{registDate,jdbcType=DATE}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(TDDevice record);
}