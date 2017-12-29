package com.pinganzhiyuan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CaptchaExample {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    protected String orderByClause;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    protected boolean distinct;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public CaptchaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNull() {
            addCriterion("captcha is null");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNotNull() {
            addCriterion("captcha is not null");
            return (Criteria) this;
        }

        public Criteria andCaptchaEqualTo(String value) {
            addCriterion("captcha =", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotEqualTo(String value) {
            addCriterion("captcha <>", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThan(String value) {
            addCriterion("captcha >", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThanOrEqualTo(String value) {
            addCriterion("captcha >=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThan(String value) {
            addCriterion("captcha <", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThanOrEqualTo(String value) {
            addCriterion("captcha <=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLike(String value) {
            addCriterion("captcha like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotLike(String value) {
            addCriterion("captcha not like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaIn(List<String> values) {
            addCriterion("captcha in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotIn(List<String> values) {
            addCriterion("captcha not in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaBetween(String value1, String value2) {
            addCriterion("captcha between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotBetween(String value1, String value2) {
            addCriterion("captcha not between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNull() {
            addCriterion("is_expired is null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNotNull() {
            addCriterion("is_expired is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredEqualTo(Boolean value) {
            addCriterion("is_expired =", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotEqualTo(Boolean value) {
            addCriterion("is_expired <>", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThan(Boolean value) {
            addCriterion("is_expired >", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_expired >=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThan(Boolean value) {
            addCriterion("is_expired <", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("is_expired <=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIn(List<Boolean> values) {
            addCriterion("is_expired in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotIn(List<Boolean> values) {
            addCriterion("is_expired not in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired not between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNull() {
            addCriterion("applied_time is null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIsNotNull() {
            addCriterion("applied_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeEqualTo(Date value) {
            addCriterion("applied_time =", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotEqualTo(Date value) {
            addCriterion("applied_time <>", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThan(Date value) {
            addCriterion("applied_time >", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applied_time >=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThan(Date value) {
            addCriterion("applied_time <", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeLessThanOrEqualTo(Date value) {
            addCriterion("applied_time <=", value, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeIn(List<Date> values) {
            addCriterion("applied_time in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotIn(List<Date> values) {
            addCriterion("applied_time not in", values, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeBetween(Date value1, Date value2) {
            addCriterion("applied_time between", value1, value2, "appliedTime");
            return (Criteria) this;
        }

        public Criteria andAppliedTimeNotBetween(Date value1, Date value2) {
            addCriterion("applied_time not between", value1, value2, "appliedTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table captcha
     * @mbg.generated  Fri Dec 29 15:21:02 CST 2017
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

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table captcha
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 11 11:23:31 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}