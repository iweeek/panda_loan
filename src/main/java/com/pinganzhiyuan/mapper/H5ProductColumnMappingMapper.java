package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.H5ProductColumnMapping;
import com.pinganzhiyuan.model.H5ProductColumnMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface H5ProductColumnMappingMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	long countByExample(H5ProductColumnMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	int deleteByExample(H5ProductColumnMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	@Delete({ "delete from h5_product_column_mapping", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	@Insert({ "insert into h5_product_column_mapping (h5_column_key, product_id, ", "sequence, status)",
			"values (#{h5ColumnKey,jdbcType=VARCHAR}, #{productId,jdbcType=BIGINT}, ",
			"#{sequence,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(H5ProductColumnMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	int insertSelective(H5ProductColumnMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	List<H5ProductColumnMapping> selectByExample(H5ProductColumnMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	@Select({ "select", "id, h5_column_key, product_id, sequence, status", "from h5_product_column_mapping",
			"where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.H5ProductColumnMappingMapper.BaseResultMap")
	H5ProductColumnMapping selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	int updateByExampleSelective(@Param("record") H5ProductColumnMapping record,
			@Param("example") H5ProductColumnMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	int updateByExample(@Param("record") H5ProductColumnMapping record,
			@Param("example") H5ProductColumnMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	int updateByPrimaryKeySelective(H5ProductColumnMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_product_column_mapping
	 * @mbg.generated  Fri Mar 23 10:35:07 CST 2018
	 */
	@Update({ "update h5_product_column_mapping", "set h5_column_key = #{h5ColumnKey,jdbcType=VARCHAR},",
			"product_id = #{productId,jdbcType=BIGINT},", "sequence = #{sequence,jdbcType=INTEGER},",
			"status = #{status,jdbcType=TINYINT}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(H5ProductColumnMapping record);
}