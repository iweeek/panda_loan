package com.pinganzhiyuan.model;

import java.util.ArrayList;
import java.util.List;

public class TDConfigExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public TDConfigExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
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

		public Criteria andPackageNameIsNull() {
			addCriterion("package_name is null");
			return (Criteria) this;
		}

		public Criteria andPackageNameIsNotNull() {
			addCriterion("package_name is not null");
			return (Criteria) this;
		}

		public Criteria andPackageNameEqualTo(String value) {
			addCriterion("package_name =", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameNotEqualTo(String value) {
			addCriterion("package_name <>", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameGreaterThan(String value) {
			addCriterion("package_name >", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
			addCriterion("package_name >=", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameLessThan(String value) {
			addCriterion("package_name <", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameLessThanOrEqualTo(String value) {
			addCriterion("package_name <=", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameLike(String value) {
			addCriterion("package_name like", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameNotLike(String value) {
			addCriterion("package_name not like", value, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameIn(List<String> values) {
			addCriterion("package_name in", values, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameNotIn(List<String> values) {
			addCriterion("package_name not in", values, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameBetween(String value1, String value2) {
			addCriterion("package_name between", value1, value2, "packageName");
			return (Criteria) this;
		}

		public Criteria andPackageNameNotBetween(String value1, String value2) {
			addCriterion("package_name not between", value1, value2, "packageName");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNull() {
			addCriterion("channel_id is null");
			return (Criteria) this;
		}

		public Criteria andChannelIdIsNotNull() {
			addCriterion("channel_id is not null");
			return (Criteria) this;
		}

		public Criteria andChannelIdEqualTo(Long value) {
			addCriterion("channel_id =", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotEqualTo(Long value) {
			addCriterion("channel_id <>", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThan(Long value) {
			addCriterion("channel_id >", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
			addCriterion("channel_id >=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThan(Long value) {
			addCriterion("channel_id <", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdLessThanOrEqualTo(Long value) {
			addCriterion("channel_id <=", value, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdIn(List<Long> values) {
			addCriterion("channel_id in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotIn(List<Long> values) {
			addCriterion("channel_id not in", values, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdBetween(Long value1, Long value2) {
			addCriterion("channel_id between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andChannelIdNotBetween(Long value1, Long value2) {
			addCriterion("channel_id not between", value1, value2, "channelId");
			return (Criteria) this;
		}

		public Criteria andThresholdIsNull() {
			addCriterion("threshold is null");
			return (Criteria) this;
		}

		public Criteria andThresholdIsNotNull() {
			addCriterion("threshold is not null");
			return (Criteria) this;
		}

		public Criteria andThresholdEqualTo(Integer value) {
			addCriterion("threshold =", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdNotEqualTo(Integer value) {
			addCriterion("threshold <>", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdGreaterThan(Integer value) {
			addCriterion("threshold >", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdGreaterThanOrEqualTo(Integer value) {
			addCriterion("threshold >=", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdLessThan(Integer value) {
			addCriterion("threshold <", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdLessThanOrEqualTo(Integer value) {
			addCriterion("threshold <=", value, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdIn(List<Integer> values) {
			addCriterion("threshold in", values, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdNotIn(List<Integer> values) {
			addCriterion("threshold not in", values, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdBetween(Integer value1, Integer value2) {
			addCriterion("threshold between", value1, value2, "threshold");
			return (Criteria) this;
		}

		public Criteria andThresholdNotBetween(Integer value1, Integer value2) {
			addCriterion("threshold not between", value1, value2, "threshold");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table td_config
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
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
     * This class corresponds to the database table td_config
     *
     * @mbg.generated do_not_delete_during_merge Wed Jan 24 14:33:00 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}