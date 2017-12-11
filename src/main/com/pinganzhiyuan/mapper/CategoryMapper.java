package com.pinganzhiyuan.mapper;

import com.pinganzhiyuan.model.Category;
import com.pinganzhiyuan.model.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    long countByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    int deleteByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    @Delete({
        "delete from category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    @Insert({
        "insert into category (title, subtitle, ",
        "img_url, target_url, ",
        "weight, tag, property, ",
        "edu)",
        "values (#{title,jdbcType=VARCHAR}, #{subtitle,jdbcType=VARCHAR}, ",
        "#{imgUrl,jdbcType=VARCHAR}, #{targetUrl,jdbcType=VARCHAR}, ",
        "#{weight,jdbcType=INTEGER}, #{tag,jdbcType=VARCHAR}, #{property,jdbcType=VARCHAR}, ",
        "#{edu,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    int insertSelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    @Select({
        "select",
        "id, title, subtitle, img_url, target_url, weight, tag, property, edu",
        "from category",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.pinganzhiyuan.mapper.CategoryMapper.BaseResultMap")
    Category selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 08 11:34:49 CST 2017
     */
    @Update({
        "update category",
        "set title = #{title,jdbcType=VARCHAR},",
          "subtitle = #{subtitle,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "target_url = #{targetUrl,jdbcType=VARCHAR},",
          "weight = #{weight,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR},",
          "property = #{property,jdbcType=VARCHAR},",
          "edu = #{edu,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Category record);
}