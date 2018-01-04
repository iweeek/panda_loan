package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.User;
import com.pinganzhiyuan.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    @Delete({ "delete from user", "where id = #{id,jdbcType=BIGINT}" })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    @Insert({ "insert into user (username, password, ", "regist_time)",
            "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ", "#{registTime,jdbcType=BIGINT})" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    @Select({ "select", "id, username, password, regist_time", "from user", "where id = #{id,jdbcType=BIGINT}" })
    @ResultMap("com.pinganzhiyuan.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table user
     * @mbg.generated  Thu Jan 04 14:00:42 CST 2018
     */
    @Update({ "update user", "set username = #{username,jdbcType=VARCHAR},", "password = #{password,jdbcType=VARCHAR},",
            "regist_time = #{registTime,jdbcType=BIGINT}", "where id = #{id,jdbcType=BIGINT}" })
    int updateByPrimaryKey(User record);
}