package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.ClientColumnMapping;
import com.pinganzhiyuan.model.ClientColumnMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ClientColumnMappingMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    long countByExample(ClientColumnMappingExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    int deleteByExample(ClientColumnMappingExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    @Delete({ "delete from client_column_mapping", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    @Insert({ "insert into client_column_mapping (package_name, platform_id, ", "column_key)",
            "values (#{packageName,jdbcType=VARCHAR}, #{platformId,jdbcType=TINYINT}, ",
            "#{columnKey,jdbcType=VARCHAR})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(ClientColumnMapping record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    int insertSelective(ClientColumnMapping record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    List<ClientColumnMapping> selectByExample(ClientColumnMappingExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    @Select({ "select", "id, package_name, platform_id, column_key", "from client_column_mapping",
            "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.ClientColumnMappingMapper.BaseResultMap")
    ClientColumnMapping selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    int updateByExampleSelective(@Param("record") ClientColumnMapping record,
            @Param("example") ClientColumnMappingExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    int updateByExample(@Param("record") ClientColumnMapping record,
            @Param("example") ClientColumnMappingExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    int updateByPrimaryKeySelective(ClientColumnMapping record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table client_column_mapping
     * @mbg.generated  Sat Feb 03 17:16:34 CST 2018
     */
    @Update({ "update client_column_mapping", "set package_name = #{packageName,jdbcType=VARCHAR},",
            "platform_id = #{platformId,jdbcType=TINYINT},", "column_key = #{columnKey,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(ClientColumnMapping record);
}