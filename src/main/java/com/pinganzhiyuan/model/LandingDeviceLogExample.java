package com.pinganzhiyuan.model;

import java.util.ArrayList;
import java.util.List;

public class LandingDeviceLogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public LandingDeviceLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table landing_device_log
	 * @mbg.generated  Tue Mar 20 16:02:34 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table landing_device_log
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

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdIsNull() {
			addCriterion("landing_channel_id is null");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdIsNotNull() {
			addCriterion("landing_channel_id is not null");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdEqualTo(Long value) {
			addCriterion("landing_channel_id =", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdNotEqualTo(Long value) {
			addCriterion("landing_channel_id <>", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdGreaterThan(Long value) {
			addCriterion("landing_channel_id >", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdGreaterThanOrEqualTo(Long value) {
			addCriterion("landing_channel_id >=", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdLessThan(Long value) {
			addCriterion("landing_channel_id <", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdLessThanOrEqualTo(Long value) {
			addCriterion("landing_channel_id <=", value, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdIn(List<Long> values) {
			addCriterion("landing_channel_id in", values, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdNotIn(List<Long> values) {
			addCriterion("landing_channel_id not in", values, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdBetween(Long value1, Long value2) {
			addCriterion("landing_channel_id between", value1, value2, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelIdNotBetween(Long value1, Long value2) {
			addCriterion("landing_channel_id not between", value1, value2, "landingChannelId");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidIsNull() {
			addCriterion("landing_channel_uid is null");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidIsNotNull() {
			addCriterion("landing_channel_uid is not null");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidEqualTo(String value) {
			addCriterion("landing_channel_uid =", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidNotEqualTo(String value) {
			addCriterion("landing_channel_uid <>", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidGreaterThan(String value) {
			addCriterion("landing_channel_uid >", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidGreaterThanOrEqualTo(String value) {
			addCriterion("landing_channel_uid >=", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidLessThan(String value) {
			addCriterion("landing_channel_uid <", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidLessThanOrEqualTo(String value) {
			addCriterion("landing_channel_uid <=", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidLike(String value) {
			addCriterion("landing_channel_uid like", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidNotLike(String value) {
			addCriterion("landing_channel_uid not like", value, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidIn(List<String> values) {
			addCriterion("landing_channel_uid in", values, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidNotIn(List<String> values) {
			addCriterion("landing_channel_uid not in", values, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidBetween(String value1, String value2) {
			addCriterion("landing_channel_uid between", value1, value2, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andLandingChannelUidNotBetween(String value1, String value2) {
			addCriterion("landing_channel_uid not between", value1, value2, "landingChannelUid");
			return (Criteria) this;
		}

		public Criteria andH5AppIdIsNull() {
			addCriterion("h5_app_id is null");
			return (Criteria) this;
		}

		public Criteria andH5AppIdIsNotNull() {
			addCriterion("h5_app_id is not null");
			return (Criteria) this;
		}

		public Criteria andH5AppIdEqualTo(Long value) {
			addCriterion("h5_app_id =", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdNotEqualTo(Long value) {
			addCriterion("h5_app_id <>", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdGreaterThan(Long value) {
			addCriterion("h5_app_id >", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdGreaterThanOrEqualTo(Long value) {
			addCriterion("h5_app_id >=", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdLessThan(Long value) {
			addCriterion("h5_app_id <", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdLessThanOrEqualTo(Long value) {
			addCriterion("h5_app_id <=", value, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdIn(List<Long> values) {
			addCriterion("h5_app_id in", values, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdNotIn(List<Long> values) {
			addCriterion("h5_app_id not in", values, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdBetween(Long value1, Long value2) {
			addCriterion("h5_app_id between", value1, value2, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andH5AppIdNotBetween(Long value1, Long value2) {
			addCriterion("h5_app_id not between", value1, value2, "h5AppId");
			return (Criteria) this;
		}

		public Criteria andPIdIsNull() {
			addCriterion("p_id is null");
			return (Criteria) this;
		}

		public Criteria andPIdIsNotNull() {
			addCriterion("p_id is not null");
			return (Criteria) this;
		}

		public Criteria andPIdEqualTo(Long value) {
			addCriterion("p_id =", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotEqualTo(Long value) {
			addCriterion("p_id <>", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdGreaterThan(Long value) {
			addCriterion("p_id >", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdGreaterThanOrEqualTo(Long value) {
			addCriterion("p_id >=", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdLessThan(Long value) {
			addCriterion("p_id <", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdLessThanOrEqualTo(Long value) {
			addCriterion("p_id <=", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdIn(List<Long> values) {
			addCriterion("p_id in", values, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotIn(List<Long> values) {
			addCriterion("p_id not in", values, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdBetween(Long value1, Long value2) {
			addCriterion("p_id between", value1, value2, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotBetween(Long value1, Long value2) {
			addCriterion("p_id not between", value1, value2, "pId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserAgentIsNull() {
			addCriterion("user_agent is null");
			return (Criteria) this;
		}

		public Criteria andUserAgentIsNotNull() {
			addCriterion("user_agent is not null");
			return (Criteria) this;
		}

		public Criteria andUserAgentEqualTo(String value) {
			addCriterion("user_agent =", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentNotEqualTo(String value) {
			addCriterion("user_agent <>", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentGreaterThan(String value) {
			addCriterion("user_agent >", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentGreaterThanOrEqualTo(String value) {
			addCriterion("user_agent >=", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentLessThan(String value) {
			addCriterion("user_agent <", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentLessThanOrEqualTo(String value) {
			addCriterion("user_agent <=", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentLike(String value) {
			addCriterion("user_agent like", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentNotLike(String value) {
			addCriterion("user_agent not like", value, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentIn(List<String> values) {
			addCriterion("user_agent in", values, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentNotIn(List<String> values) {
			addCriterion("user_agent not in", values, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentBetween(String value1, String value2) {
			addCriterion("user_agent between", value1, value2, "userAgent");
			return (Criteria) this;
		}

		public Criteria andUserAgentNotBetween(String value1, String value2) {
			addCriterion("user_agent not between", value1, value2, "userAgent");
			return (Criteria) this;
		}

		public Criteria andSidIsNull() {
			addCriterion("sid is null");
			return (Criteria) this;
		}

		public Criteria andSidIsNotNull() {
			addCriterion("sid is not null");
			return (Criteria) this;
		}

		public Criteria andSidEqualTo(String value) {
			addCriterion("sid =", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotEqualTo(String value) {
			addCriterion("sid <>", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThan(String value) {
			addCriterion("sid >", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThanOrEqualTo(String value) {
			addCriterion("sid >=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThan(String value) {
			addCriterion("sid <", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThanOrEqualTo(String value) {
			addCriterion("sid <=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLike(String value) {
			addCriterion("sid like", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotLike(String value) {
			addCriterion("sid not like", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidIn(List<String> values) {
			addCriterion("sid in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotIn(List<String> values) {
			addCriterion("sid not in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidBetween(String value1, String value2) {
			addCriterion("sid between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotBetween(String value1, String value2) {
			addCriterion("sid not between", value1, value2, "sid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table landing_device_log
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
     * This class corresponds to the database table landing_device_log
     *
     * @mbg.generated do_not_delete_during_merge Thu Jan 18 15:03:11 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}