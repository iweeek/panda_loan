package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.H5AppDownloadLog;
import com.pinganzhiyuan.model.H5AppDownloadLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface H5AppDownloadLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	long countByExample(H5AppDownloadLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int deleteByExample(H5AppDownloadLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Delete({ "delete from h5_app_download_log", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Insert({ "insert into h5_app_download_log (user_id, ip, ", "h5_client_version_id, app_client_version_id, ",
			"user_agent)", "values (#{userId,jdbcType=BIGINT}, #{ip,jdbcType=VARCHAR}, ",
			"#{h5ClientVersionId,jdbcType=BIGINT}, #{appClientVersionId,jdbcType=BIGINT}, ",
			"#{userAgent,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(H5AppDownloadLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int insertSelective(H5AppDownloadLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	List<H5AppDownloadLog> selectByExample(H5AppDownloadLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Select({ "select", "id, user_id, ip, h5_client_version_id, app_client_version_id, user_agent",
			"from h5_app_download_log", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.H5AppDownloadLogMapper.BaseResultMap")
	H5AppDownloadLog selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByExampleSelective(@Param("record") H5AppDownloadLog record,
			@Param("example") H5AppDownloadLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByExample(@Param("record") H5AppDownloadLog record, @Param("example") H5AppDownloadLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByPrimaryKeySelective(H5AppDownloadLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_app_download_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Update({ "update h5_app_download_log", "set user_id = #{userId,jdbcType=BIGINT},", "ip = #{ip,jdbcType=VARCHAR},",
			"h5_client_version_id = #{h5ClientVersionId,jdbcType=BIGINT},",
			"app_client_version_id = #{appClientVersionId,jdbcType=BIGINT},",
			"user_agent = #{userAgent,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(H5AppDownloadLog record);
}