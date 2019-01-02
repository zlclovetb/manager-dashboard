package com.spring.production.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderPlanExample {
    /** 
     * 排序字段
    */
    protected String orderByClause;

    /** 
     * 过滤重复数据
    */
    protected boolean distinct;

    /** 
     * 查询条件
    */
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public OrderPlanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * InnoDB free: 3917824 kBorder_plan的基本动态SQL对象.
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("ORDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("ORDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("ORDER_NAME =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("ORDER_NAME <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("ORDER_NAME >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NAME >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("ORDER_NAME <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NAME <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("ORDER_NAME like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("ORDER_NAME not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("ORDER_NAME in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("ORDER_NAME not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("ORDER_NAME between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("ORDER_NAME not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("PRO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("PRO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("PRO_NAME =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("PRO_NAME <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("PRO_NAME >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_NAME >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("PRO_NAME <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("PRO_NAME <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("PRO_NAME like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("PRO_NAME not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("PRO_NAME in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("PRO_NAME not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("PRO_NAME between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("PRO_NAME not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andPlanCountIsNull() {
            addCriterion("PLAN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPlanCountIsNotNull() {
            addCriterion("PLAN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPlanCountEqualTo(Integer value) {
            addCriterion("PLAN_COUNT =", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotEqualTo(Integer value) {
            addCriterion("PLAN_COUNT <>", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountGreaterThan(Integer value) {
            addCriterion("PLAN_COUNT >", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAN_COUNT >=", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountLessThan(Integer value) {
            addCriterion("PLAN_COUNT <", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountLessThanOrEqualTo(Integer value) {
            addCriterion("PLAN_COUNT <=", value, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountIn(List<Integer> values) {
            addCriterion("PLAN_COUNT in", values, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotIn(List<Integer> values) {
            addCriterion("PLAN_COUNT not in", values, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_COUNT between", value1, value2, "planCount");
            return (Criteria) this;
        }

        public Criteria andPlanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAN_COUNT not between", value1, value2, "planCount");
            return (Criteria) this;
        }

        public Criteria andActualCountIsNull() {
            addCriterion("ACTUAL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andActualCountIsNotNull() {
            addCriterion("ACTUAL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andActualCountEqualTo(Integer value) {
            addCriterion("ACTUAL_COUNT =", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountNotEqualTo(Integer value) {
            addCriterion("ACTUAL_COUNT <>", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountGreaterThan(Integer value) {
            addCriterion("ACTUAL_COUNT >", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTUAL_COUNT >=", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountLessThan(Integer value) {
            addCriterion("ACTUAL_COUNT <", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountLessThanOrEqualTo(Integer value) {
            addCriterion("ACTUAL_COUNT <=", value, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountIn(List<Integer> values) {
            addCriterion("ACTUAL_COUNT in", values, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountNotIn(List<Integer> values) {
            addCriterion("ACTUAL_COUNT not in", values, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountBetween(Integer value1, Integer value2) {
            addCriterion("ACTUAL_COUNT between", value1, value2, "actualCount");
            return (Criteria) this;
        }

        public Criteria andActualCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTUAL_COUNT not between", value1, value2, "actualCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountIsNull() {
            addCriterion("DIFF_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDiffCountIsNotNull() {
            addCriterion("DIFF_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDiffCountEqualTo(Integer value) {
            addCriterion("DIFF_COUNT =", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountNotEqualTo(Integer value) {
            addCriterion("DIFF_COUNT <>", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountGreaterThan(Integer value) {
            addCriterion("DIFF_COUNT >", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("DIFF_COUNT >=", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountLessThan(Integer value) {
            addCriterion("DIFF_COUNT <", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountLessThanOrEqualTo(Integer value) {
            addCriterion("DIFF_COUNT <=", value, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountIn(List<Integer> values) {
            addCriterion("DIFF_COUNT in", values, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountNotIn(List<Integer> values) {
            addCriterion("DIFF_COUNT not in", values, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountBetween(Integer value1, Integer value2) {
            addCriterion("DIFF_COUNT between", value1, value2, "diffCount");
            return (Criteria) this;
        }

        public Criteria andDiffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("DIFF_COUNT not between", value1, value2, "diffCount");
            return (Criteria) this;
        }

        public Criteria andAchRateIsNull() {
            addCriterion("ACH_RATE is null");
            return (Criteria) this;
        }

        public Criteria andAchRateIsNotNull() {
            addCriterion("ACH_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andAchRateEqualTo(String value) {
            addCriterion("ACH_RATE =", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateNotEqualTo(String value) {
            addCriterion("ACH_RATE <>", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateGreaterThan(String value) {
            addCriterion("ACH_RATE >", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateGreaterThanOrEqualTo(String value) {
            addCriterion("ACH_RATE >=", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateLessThan(String value) {
            addCriterion("ACH_RATE <", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateLessThanOrEqualTo(String value) {
            addCriterion("ACH_RATE <=", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateLike(String value) {
            addCriterion("ACH_RATE like", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateNotLike(String value) {
            addCriterion("ACH_RATE not like", value, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateIn(List<String> values) {
            addCriterion("ACH_RATE in", values, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateNotIn(List<String> values) {
            addCriterion("ACH_RATE not in", values, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateBetween(String value1, String value2) {
            addCriterion("ACH_RATE between", value1, value2, "achRate");
            return (Criteria) this;
        }

        public Criteria andAchRateNotBetween(String value1, String value2) {
            addCriterion("ACH_RATE not between", value1, value2, "achRate");
            return (Criteria) this;
        }

        public Criteria andProDateIsNull() {
            addCriterion("PRO_DATE is null");
            return (Criteria) this;
        }

        public Criteria andProDateIsNotNull() {
            addCriterion("PRO_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andProDateEqualTo(Date value) {
            addCriterion("PRO_DATE =", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateNotEqualTo(Date value) {
            addCriterion("PRO_DATE <>", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateGreaterThan(Date value) {
            addCriterion("PRO_DATE >", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PRO_DATE >=", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateLessThan(Date value) {
            addCriterion("PRO_DATE <", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateLessThanOrEqualTo(Date value) {
            addCriterion("PRO_DATE <=", value, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateIn(List<Date> values) {
            addCriterion("PRO_DATE in", values, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateNotIn(List<Date> values) {
            addCriterion("PRO_DATE not in", values, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateBetween(Date value1, Date value2) {
            addCriterion("PRO_DATE between", value1, value2, "proDate");
            return (Criteria) this;
        }

        public Criteria andProDateNotBetween(Date value1, Date value2) {
            addCriterion("PRO_DATE not between", value1, value2, "proDate");
            return (Criteria) this;
        }

        public Criteria andPropertieIsNull() {
            addCriterion("PROPERTIE is null");
            return (Criteria) this;
        }

        public Criteria andPropertieIsNotNull() {
            addCriterion("PROPERTIE is not null");
            return (Criteria) this;
        }

        public Criteria andPropertieEqualTo(Integer value) {
            addCriterion("PROPERTIE =", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieNotEqualTo(Integer value) {
            addCriterion("PROPERTIE <>", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieGreaterThan(Integer value) {
            addCriterion("PROPERTIE >", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROPERTIE >=", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieLessThan(Integer value) {
            addCriterion("PROPERTIE <", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieLessThanOrEqualTo(Integer value) {
            addCriterion("PROPERTIE <=", value, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieIn(List<Integer> values) {
            addCriterion("PROPERTIE in", values, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieNotIn(List<Integer> values) {
            addCriterion("PROPERTIE not in", values, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTIE between", value1, value2, "propertie");
            return (Criteria) this;
        }

        public Criteria andPropertieNotBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTIE not between", value1, value2, "propertie");
            return (Criteria) this;
        }

        public Criteria andProStatusIsNull() {
            addCriterion("PRO_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andProStatusIsNotNull() {
            addCriterion("PRO_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andProStatusEqualTo(String value) {
            addCriterion("PRO_STATUS =", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusNotEqualTo(String value) {
            addCriterion("PRO_STATUS <>", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusGreaterThan(String value) {
            addCriterion("PRO_STATUS >", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_STATUS >=", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusLessThan(String value) {
            addCriterion("PRO_STATUS <", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusLessThanOrEqualTo(String value) {
            addCriterion("PRO_STATUS <=", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusLike(String value) {
            addCriterion("PRO_STATUS like", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusNotLike(String value) {
            addCriterion("PRO_STATUS not like", value, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusIn(List<String> values) {
            addCriterion("PRO_STATUS in", values, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusNotIn(List<String> values) {
            addCriterion("PRO_STATUS not in", values, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusBetween(String value1, String value2) {
            addCriterion("PRO_STATUS between", value1, value2, "proStatus");
            return (Criteria) this;
        }

        public Criteria andProStatusNotBetween(String value1, String value2) {
            addCriterion("PRO_STATUS not between", value1, value2, "proStatus");
            return (Criteria) this;
        }
    }

    /**
     * InnoDB free: 3917824 kBorder_plan的映射实体
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * InnoDB free: 3917824 kBorder_plan的动态SQL对象.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}