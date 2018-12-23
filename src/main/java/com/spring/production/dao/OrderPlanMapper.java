package com.spring.production.dao;

import org.springframework.stereotype.Repository;

import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;

/**
 * 通用IMapper<T, E, PK>
 * T:实体类
 * E:Example
 * PK:主键的变量类型
 *
 * @author spring
 *         github: https://github.com/zlc_tb
 *         date: 2018-12-21 18:48:00
 */
@Repository
public interface OrderPlanMapper extends BaseMapper<OrderPlan, OrderPlanExample, Integer> {
}