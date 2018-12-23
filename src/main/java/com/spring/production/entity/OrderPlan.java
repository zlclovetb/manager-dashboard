package com.spring.production.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * InnoDB free: 3917824 kB order_plan
 * @author Spring.Zhang
 * @company ParaDM Limited
 * @creation date:2018-12-21 18:48:00
 */
public class OrderPlan implements Serializable {
    /** 
     * 订单编号
     */ 
    private Integer id;

    /** 
     * 订单名称
     */ 
    private String orderName;

    /** 
     * 产品名称及规格
     */ 
    private String proName;

    /** 
     * 计划生产数
     */ 
    private Integer planCount;

    /** 
     * 实际生产数
     */ 
    private Integer actualCount;

    /** 
     * 差异数
     */ 
    private Integer diffCount;

    /** 
     * 达成率
     */ 
    private String achRate;

    /** 
     * 生产时间
     */ 
    private Date proDate;

    /** 
     * 紧要程度
     */ 
    private Integer propertie;

    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 1L;

    /** 
     * 获取 订单编号 order_plan.ID
     * @return 订单编号
     */
    public Integer getId() {
        return id;
    }

    /** 
     * 设置 订单编号 order_plan.ID
     * @param id 订单编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 订单名称 order_plan.ORDER_NAME
     * @return 订单名称
     */
    public String getOrderName() {
        return orderName;
    }

    /** 
     * 设置 订单名称 order_plan.ORDER_NAME
     * @param orderName 订单名称
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    /** 
     * 获取 产品名称及规格 order_plan.PRO_NAME
     * @return 产品名称及规格
     */
    public String getProName() {
        return proName;
    }

    /** 
     * 设置 产品名称及规格 order_plan.PRO_NAME
     * @param proName 产品名称及规格
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    /** 
     * 获取 计划生产数 order_plan.PLAN_COUNT
     * @return 计划生产数
     */
    public Integer getPlanCount() {
        return planCount;
    }

    /** 
     * 设置 计划生产数 order_plan.PLAN_COUNT
     * @param planCount 计划生产数
     */
    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    /** 
     * 获取 实际生产数 order_plan.ACTUAL_COUNT
     * @return 实际生产数
     */
    public Integer getActualCount() {
        return actualCount;
    }

    /** 
     * 设置 实际生产数 order_plan.ACTUAL_COUNT
     * @param actualCount 实际生产数
     */
    public void setActualCount(Integer actualCount) {
        this.actualCount = actualCount;
    }

    /** 
     * 获取 差异数 order_plan.DIFF_COUNT
     * @return 差异数
     */
    public Integer getDiffCount() {
        return diffCount;
    }

    /** 
     * 设置 差异数 order_plan.DIFF_COUNT
     * @param diffCount 差异数
     */
    public void setDiffCount(Integer diffCount) {
        this.diffCount = diffCount;
    }

    /** 
     * 获取 达成率 order_plan.ACH_RATE
     * @return 达成率
     */
    public String getAchRate() {
        return achRate;
    }

    /** 
     * 设置 达成率 order_plan.ACH_RATE
     * @param achRate 达成率
     */
    public void setAchRate(String achRate) {
        this.achRate = achRate == null ? null : achRate.trim();
    }

    /** 
     * 获取 生产时间 order_plan.PRO_DATE
     * @return 生产时间
     */
    public Date getProDate() {
        return proDate;
    }

    /** 
     * 设置 生产时间 order_plan.PRO_DATE
     * @param proDate 生产时间
     */
    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    /** 
     * 获取 紧要程度 order_plan.PROPERTIE
     * @return 紧要程度
     */
    public Integer getPropertie() {
        return propertie;
    }

    /** 
     * 设置 紧要程度 order_plan.PROPERTIE
     * @param propertie 紧要程度
     */
    public void setPropertie(Integer propertie) {
        this.propertie = propertie;
    }
}