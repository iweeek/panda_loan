package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.ClientModule;
import com.pinganzhiyuan.model.ClientModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ClientModuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    long countByExample(ClientModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    int deleteByExample(ClientModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    @Delete({
        "delete from client_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    @Insert({
        "insert into client_module (name, icon_url)",
        "values (#{name,jdbcType=VARCHAR}, #{iconUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ClientModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    int insertSelective(ClientModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    List<ClientModule> selectByExample(ClientModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    @Select({
        "select",
        "id, name, icon_url",
        "from client_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.pinganzhiyuan.mapper.ClientModuleMapper.BaseResultMap")
    ClientModule selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") ClientModule record, @Param("example") ClientModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExample(@Param("record") ClientModule record, @Param("example") ClientModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    int updateByPrimaryKeySelective(ClientModule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_module
     *
     * @mbg.generated Fri Dec 29 15:21:02 CST 2017
     */
    @Update({
        "update client_module",
        "set name = #{name,jdbcType=VARCHAR},",
          "icon_url = #{iconUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ClientModule record);
}