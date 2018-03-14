package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.TabModuleMapping;
import com.pinganzhiyuan.model.TabModuleMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TabModuleMappingMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	long countByExample(TabModuleMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	int deleteByExample(TabModuleMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	@Delete({ "delete from tab_module_mapping", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	@Insert({ "insert into tab_module_mapping (module_id, name, ", "icon_url, scheme_url, ",
			"channel_id, package_name, ", "version, sequence)",
			"values (#{moduleId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
			"#{iconUrl,jdbcType=VARCHAR}, #{schemeUrl,jdbcType=VARCHAR}, ",
			"#{channelId,jdbcType=BIGINT}, #{packageName,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{sequence,jdbcType=TINYINT})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	int insert(TabModuleMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	int insertSelective(TabModuleMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	List<TabModuleMapping> selectByExample(TabModuleMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	@Select({ "select", "id, module_id, name, icon_url, scheme_url, channel_id, package_name, version, ", "sequence",
			"from tab_module_mapping", "where id = #{id,jdbcType=BIGINT}" })
	@ResultMap("com.pinganzhiyuan.mapper.TabModuleMappingMapper.BaseResultMap")
	TabModuleMapping selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	int updateByExampleSelective(@Param("record") TabModuleMapping record,
			@Param("example") TabModuleMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	int updateByExample(@Param("record") TabModuleMapping record, @Param("example") TabModuleMappingExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	int updateByPrimaryKeySelective(TabModuleMapping record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tab_module_mapping
	 * @mbg.generated  Wed Mar 14 15:35:24 CST 2018
	 */
	@Update({ "update tab_module_mapping", "set module_id = #{moduleId,jdbcType=BIGINT},",
			"name = #{name,jdbcType=VARCHAR},", "icon_url = #{iconUrl,jdbcType=VARCHAR},",
			"scheme_url = #{schemeUrl,jdbcType=VARCHAR},", "channel_id = #{channelId,jdbcType=BIGINT},",
			"package_name = #{packageName,jdbcType=VARCHAR},", "version = #{version,jdbcType=INTEGER},",
			"sequence = #{sequence,jdbcType=TINYINT}", "where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(TabModuleMapping record);
}