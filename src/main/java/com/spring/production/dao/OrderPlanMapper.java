package com.spring.production.dao;

import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
@Repository
public interface OrderPlanMapper extends BaseMapper<OrderPlan, OrderPlanExample, Integer> {
}