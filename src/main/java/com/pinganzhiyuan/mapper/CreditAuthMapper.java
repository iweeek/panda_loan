package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.CreditAuth;
import com.pinganzhiyuan.model.CreditAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CreditAuthMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	long countByExample(CreditAuthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int deleteByExample(CreditAuthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Delete({ "delete from credit_auth", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Insert({ "insert into credit_auth (name, weight)",
			"values (#{name,jdbcType=VARCHAR}, #{weight,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(CreditAuth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int insertSelective(CreditAuth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	List<CreditAuth> selectByExample(CreditAuthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Select({ "select", "id, name, weight", "from credit_auth", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.CreditAuthMapper.BaseResultMap")
	CreditAuth selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CreditAuth record, @Param("example") CreditAuthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByExample(@Param("record") CreditAuth record, @Param("example") CreditAuthExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	int updateByPrimaryKeySelective(CreditAuth record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table credit_auth
	 * @mbg.generated  Wed Apr 04 16:23:38 CST 2018
	 */
	@Update({ "update credit_auth", "set name = #{name,jdbcType=VARCHAR},", "weight = #{weight,jdbcType=INTEGER}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(CreditAuth record);
}