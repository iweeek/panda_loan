package com.pinganzhiyuan.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public ColumnExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
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

		public Criteria andColumnKeyIsNull() {
			addCriterion("column_key is null");
			return (Criteria) this;
		}

		public Criteria andColumnKeyIsNotNull() {
			addCriterion("column_key is not null");
			return (Criteria) this;
		}

		public Criteria andColumnKeyEqualTo(String value) {
			addCriterion("column_key =", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyNotEqualTo(String value) {
			addCriterion("column_key <>", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyGreaterThan(String value) {
			addCriterion("column_key >", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyGreaterThanOrEqualTo(String value) {
			addCriterion("column_key >=", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyLessThan(String value) {
			addCriterion("column_key <", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyLessThanOrEqualTo(String value) {
			addCriterion("column_key <=", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyLike(String value) {
			addCriterion("column_key like", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyNotLike(String value) {
			addCriterion("column_key not like", value, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyIn(List<String> values) {
			addCriterion("column_key in", values, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyNotIn(List<String> values) {
			addCriterion("column_key not in", values, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyBetween(String value1, String value2) {
			addCriterion("column_key between", value1, value2, "columnKey");
			return (Criteria) this;
		}

		public Criteria andColumnKeyNotBetween(String value1, String value2) {
			addCriterion("column_key not between", value1, value2, "columnKey");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andSubtitleIsNull() {
			addCriterion("subtitle is null");
			return (Criteria) this;
		}

		public Criteria andSubtitleIsNotNull() {
			addCriterion("subtitle is not null");
			return (Criteria) this;
		}

		public Criteria andSubtitleEqualTo(String value) {
			addCriterion("subtitle =", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleNotEqualTo(String value) {
			addCriterion("subtitle <>", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleGreaterThan(String value) {
			addCriterion("subtitle >", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
			addCriterion("subtitle >=", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleLessThan(String value) {
			addCriterion("subtitle <", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleLessThanOrEqualTo(String value) {
			addCriterion("subtitle <=", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleLike(String value) {
			addCriterion("subtitle like", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleNotLike(String value) {
			addCriterion("subtitle not like", value, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleIn(List<String> values) {
			addCriterion("subtitle in", values, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleNotIn(List<String> values) {
			addCriterion("subtitle not in", values, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleBetween(String value1, String value2) {
			addCriterion("subtitle between", value1, value2, "subtitle");
			return (Criteria) this;
		}

		public Criteria andSubtitleNotBetween(String value1, String value2) {
			addCriterion("subtitle not between", value1, value2, "subtitle");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andIconUrlIsNull() {
			addCriterion("icon_url is null");
			return (Criteria) this;
		}

		public Criteria andIconUrlIsNotNull() {
			addCriterion("icon_url is not null");
			return (Criteria) this;
		}

		public Criteria andIconUrlEqualTo(String value) {
			addCriterion("icon_url =", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlNotEqualTo(String value) {
			addCriterion("icon_url <>", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlGreaterThan(String value) {
			addCriterion("icon_url >", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlGreaterThanOrEqualTo(String value) {
			addCriterion("icon_url >=", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlLessThan(String value) {
			addCriterion("icon_url <", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlLessThanOrEqualTo(String value) {
			addCriterion("icon_url <=", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlLike(String value) {
			addCriterion("icon_url like", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlNotLike(String value) {
			addCriterion("icon_url not like", value, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlIn(List<String> values) {
			addCriterion("icon_url in", values, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlNotIn(List<String> values) {
			addCriterion("icon_url not in", values, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlBetween(String value1, String value2) {
			addCriterion("icon_url between", value1, value2, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andIconUrlNotBetween(String value1, String value2) {
			addCriterion("icon_url not between", value1, value2, "iconUrl");
			return (Criteria) this;
		}

		public Criteria andMaxIsNull() {
			addCriterion("max is null");
			return (Criteria) this;
		}

		public Criteria andMaxIsNotNull() {
			addCriterion("max is not null");
			return (Criteria) this;
		}

		public Criteria andMaxEqualTo(Integer value) {
			addCriterion("max =", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotEqualTo(Integer value) {
			addCriterion("max <>", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxGreaterThan(Integer value) {
			addCriterion("max >", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxGreaterThanOrEqualTo(Integer value) {
			addCriterion("max >=", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxLessThan(Integer value) {
			addCriterion("max <", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxLessThanOrEqualTo(Integer value) {
			addCriterion("max <=", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxIn(List<Integer> values) {
			addCriterion("max in", values, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotIn(List<Integer> values) {
			addCriterion("max not in", values, "max");
			return (Criteria) this;
		}

		public Criteria andMaxBetween(Integer value1, Integer value2) {
			addCriterion("max between", value1, value2, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotBetween(Integer value1, Integer value2) {
			addCriterion("max not between", value1, value2, "max");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table app_column
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
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
     * This class corresponds to the database table column
     *
     * @mbg.generated do_not_delete_during_merge Sat Feb 03 11:45:23 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}