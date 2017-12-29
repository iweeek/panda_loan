package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.SelectOrder;
import com.pinganzhiyuan.model.SelectOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface SelectOrderMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    long countByExample(SelectOrderExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int deleteByExample(SelectOrderExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Delete({ "delete from select_order", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Insert({ "insert into select_order (name, field, ", "field_order)",
            "values (#{name,jdbcType=VARCHAR}, #{field,jdbcType=VARCHAR}, ", "#{fieldOrder,jdbcType=CHAR})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(SelectOrder record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int insertSelective(SelectOrder record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    List<SelectOrder> selectByExample(SelectOrderExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Select({ "select", "id, name, field, field_order", "from select_order", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.SelectOrderMapper.BaseResultMap")
    SelectOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") SelectOrder record, @Param("example") SelectOrderExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByExample(@Param("record") SelectOrder record, @Param("example") SelectOrderExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    int updateByPrimaryKeySelective(SelectOrder record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table select_order
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    @Update({ "update select_order", "set name = #{name,jdbcType=VARCHAR},", "field = #{field,jdbcType=VARCHAR},",
            "field_order = #{fieldOrder,jdbcType=CHAR}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(SelectOrder record);
}