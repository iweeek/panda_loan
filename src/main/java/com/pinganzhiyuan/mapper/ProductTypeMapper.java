package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.ProductType;
import com.pinganzhiyuan.model.ProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ProductTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	long countByExample(ProductTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int deleteByExample(ProductTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Delete({ "delete from product_type", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Insert({ "insert into product_type (name, sequency)",
			"values (#{name,jdbcType=VARCHAR}, #{sequency,jdbcType=TINYINT})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(ProductType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int insertSelective(ProductType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	List<ProductType> selectByExample(ProductTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Select({ "select", "id, name, sequency", "from product_type", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.ProductTypeMapper.BaseResultMap")
	ProductType selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	int updateByPrimaryKeySelective(ProductType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table product_type
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	@Update({ "update product_type", "set name = #{name,jdbcType=VARCHAR},", "sequency = #{sequency,jdbcType=TINYINT}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(ProductType record);
}