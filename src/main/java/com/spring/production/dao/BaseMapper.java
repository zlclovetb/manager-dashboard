package com.spring.production.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 通用IMapper<T, E, PK>
 * T:实体类
 * E:Example
 * PK:主键的变量类型
 *
 * @author spring
 *         github: https://github.com/zlc_tb
 *         date: 2018-12-28 15:02:43
 */
public interface BaseMapper<T, E, PK extends Serializable> {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    int countByExample(E example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(E example);

    /** 
     * 根据ID删除
     * @param pk
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(PK pk);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(T record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(T record);

    /** 
     * 添加List集合对象所有字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatch(List<T> record);

    /** 
     * 添加List集合对象对应字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatchSelective(List<T> record);

    /** 
     * 根据条件查询（包含二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<T> selectByExampleWithBLOBs(E example);

    /** 
     *
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<T> selectByExampleWithoutBLOBs(E example);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<T> selectByExample(E example);

    /** 
     * 根据ID查询
     * @param pk
     * @return 返回查询的结果
     */
    T selectByPrimaryKey(PK pk);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(T record);

    /** 
     * 根据ID修改字段（包含二进制大对象）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeyWithBLOBs(T record);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeyWithoutBLOBs(T record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(T record);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") T record, @Param("example") E example);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    /** 
     * 根据条件修改字段 （包含二进制大对象）
     * @param record 修改字段对象(必须含ID）
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleWithoutBLOBs(@Param("record") T record, @Param("example") E example);

    /** 
     * 根据主键，批量更新
     * @param record 批量修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateBatchByPrimaryKey(List<T> record);

    /** 
     * 根据主键，批量更新对应字段数据
     * @param record 批量修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateBatchByPrimaryKeySelective(List<T> record);

    /** 
     * 根据条件，批量更新对应字段数据
     * @param record 批量修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateBatchByExampleSelective(@Param("recordList") List<T> record, @Param("example") E example);

    /** 
     * 根据条件，批量更新
     * @param record 批量修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateBatchByExample(@Param("recordList") List<T> record, @Param("example") E example);
}