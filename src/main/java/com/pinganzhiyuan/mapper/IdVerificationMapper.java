package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.IdVerification;
import com.pinganzhiyuan.model.IdVerificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface IdVerificationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	long countByExample(IdVerificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int deleteByExample(IdVerificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Delete({ "delete from identity_verification", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Insert({ "insert into identity_verification (name, identity, ", "code, description, ", "photo, trans_id, ",
			"trade_no, fee)", "values (#{name,jdbcType=VARCHAR}, #{identity,jdbcType=VARCHAR}, ",
			"#{code,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
			"#{photo,jdbcType=VARCHAR}, #{transId,jdbcType=VARCHAR}, ",
			"#{tradeNo,jdbcType=VARCHAR}, #{fee,jdbcType=VARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(IdVerification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int insertSelective(IdVerification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	List<IdVerification> selectByExample(IdVerificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Select({ "select", "id, name, identity, code, description, photo, trans_id, trade_no, fee",
			"from identity_verification", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.IdVerificationMapper.BaseResultMap")
	IdVerification selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByExampleSelective(@Param("record") IdVerification record,
			@Param("example") IdVerificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByExample(@Param("record") IdVerification record, @Param("example") IdVerificationExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByPrimaryKeySelective(IdVerification record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table identity_verification
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Update({ "update identity_verification", "set name = #{name,jdbcType=VARCHAR},",
			"identity = #{identity,jdbcType=VARCHAR},", "code = #{code,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR},", "photo = #{photo,jdbcType=VARCHAR},",
			"trans_id = #{transId,jdbcType=VARCHAR},", "trade_no = #{tradeNo,jdbcType=VARCHAR},",
			"fee = #{fee,jdbcType=VARCHAR}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(IdVerification record);
}