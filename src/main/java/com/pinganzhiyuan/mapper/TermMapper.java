package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.Term;
import com.pinganzhiyuan.model.TermExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TermMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    long countByExample(TermExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    int deleteByExample(TermExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    @Delete({ "delete from term", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    @Insert({ "insert into term (duration, sequency)",
            "values (#{duration,jdbcType=VARCHAR}, #{sequency,jdbcType=INTEGER})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Term record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    int insertSelective(Term record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    List<Term> selectByExample(TermExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    @Select({ "select", "id, duration, sequency", "from term", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.TermMapper.BaseResultMap")
    Term selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    int updateByExampleSelective(@Param("record") Term record, @Param("example") TermExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    int updateByExample(@Param("record") Term record, @Param("example") TermExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    int updateByPrimaryKeySelective(Term record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table term
     * @mbg.generated  Tue Jan 23 15:05:52 CST 2018
     */
    @Update({ "update term", "set duration = #{duration,jdbcType=VARCHAR},", "sequency = #{sequency,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(Term record);
}