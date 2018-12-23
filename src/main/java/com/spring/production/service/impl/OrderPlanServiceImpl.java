package com.spring.production.service.impl;

import com.spring.production.dao.OrderPlanMapper;
import com.spring.production.entity.OrderPlan;
import com.spring.production.entity.OrderPlanExample;
import com.spring.production.service.OrderPlanService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPlanServiceImpl implements OrderPlanService {
    @Autowired
    private OrderPlanMapper orderPlanMapper;

    private static final Logger logger = LoggerFactory.getLogger(OrderPlanServiceImpl.class);

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#countByExample(com.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public int countByExample(OrderPlanExample example) {
        int count = this.orderPlanMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#selectByPrimaryKey(java.lang.Integer)
     */ 
    @Override
    public OrderPlan selectByPrimaryKey(Integer id) {
        return this.orderPlanMapper.selectByPrimaryKey(id);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#selectByExample(com.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public List<OrderPlan> selectByExample(OrderPlanExample example) {
        return this.orderPlanMapper.selectByExample(example);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#deleteByExample(com.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public int deleteByExample(OrderPlanExample example) {
        return this.orderPlanMapper.deleteByExample(example);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#deleteByPrimaryKey(java.lang.Integer)
     */ 
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.orderPlanMapper.deleteByPrimaryKey(id);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#insert(com.spring.production.entity.OrderPlan)
     */ 
    @Override
    public int insert(OrderPlan record) {
        return this.orderPlanMapper.insert(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#insertSelective(com.spring.production.entity.OrderPlan)
     */ 
    @Override
    public int insertSelective(OrderPlan record) {
        return this.orderPlanMapper.insertSelective(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#insertBatch(.List<OrderPlan>)
     */ 
    @Override
    public int insertBatch(List<OrderPlan> record) {
        return this.orderPlanMapper.insertBatch(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#insertBatchSelective(.List<OrderPlan>)
     */ 
    @Override
    public int insertBatchSelective(List<OrderPlan> record) {
        return this.orderPlanMapper.insertBatchSelective(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateByPrimaryKeySelective(com.spring.production.entity.OrderPlan)
     */ 
    @Override
    public int updateByPrimaryKeySelective(OrderPlan record) {
        return this.orderPlanMapper.updateByPrimaryKeySelective(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateByPrimaryKey(com.spring.production.entity.OrderPlan)
     */ 
    @Override
    public int updateByPrimaryKey(OrderPlan record) {
        return this.orderPlanMapper.updateByPrimaryKey(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateByExampleSelective(com.spring.production.entity.OrderPlancom.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public int updateByExampleSelective(OrderPlan record, OrderPlanExample example) {
        return this.orderPlanMapper.updateByExampleSelective(record, example);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateByExample(com.spring.production.entity.OrderPlancom.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public int updateByExample(OrderPlan record, OrderPlanExample example) {
        return this.orderPlanMapper.updateByExample(record, example);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateByPrimaryKeyWithBLOBs(com.spring.production.entity.OrderPlan)
     */ 
    @Override
    public int updateByPrimaryKeyWithBLOBs(OrderPlan record) {
        return this.orderPlanMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#selectByExampleWithBLOBs(com.spring.production.entity.OrderPlanExample)
     */ 
    @Override
    public List<OrderPlan> selectByExampleWithBLOBs(OrderPlanExample example) {
        return this.orderPlanMapper.selectByExampleWithBLOBs(example);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateBatchByPrimaryKeySelective(.List<OrderPlan>)
     */ 
    @Override
    public int updateBatchByPrimaryKeySelective(List<OrderPlan> records) {
        return this.orderPlanMapper.updateBatchByPrimaryKeySelective(records);
    }

    /* (non-Javadoc) 
     * @see com.spring.production.service.OrderPlanService#updateBatchByPrimaryKey(.List<OrderPlan>)
     */ 
    @Override
    public int updateBatchByPrimaryKey(List<OrderPlan> records) {
        return this.orderPlanMapper.updateBatchByPrimaryKey(records);
    }
}