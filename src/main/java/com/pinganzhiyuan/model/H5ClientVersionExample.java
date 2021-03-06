package com.pinganzhiyuan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class H5ClientVersionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public H5ClientVersionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table h5_client_version
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table h5_client_version
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

		public Criteria andLogoUrlIsNull() {
			addCriterion("logo_url is null");
			return (Criteria) this;
		}

		public Criteria andLogoUrlIsNotNull() {
			addCriterion("logo_url is not null");
			return (Criteria) this;
		}

		public Criteria andLogoUrlEqualTo(String value) {
			addCriterion("logo_url =", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotEqualTo(String value) {
			addCriterion("logo_url <>", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlGreaterThan(String value) {
			addCriterion("logo_url >", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
			addCriterion("logo_url >=", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLessThan(String value) {
			addCriterion("logo_url <", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLessThanOrEqualTo(String value) {
			addCriterion("logo_url <=", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlLike(String value) {
			addCriterion("logo_url like", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotLike(String value) {
			addCriterion("logo_url not like", value, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlIn(List<String> values) {
			addCriterion("logo_url in", values, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotIn(List<String> values) {
			addCriterion("logo_url not in", values, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlBetween(String value1, String value2) {
			addCriterion("logo_url between", value1, value2, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andLogoUrlNotBetween(String value1, String value2) {
			addCriterion("logo_url not between", value1, value2, "logoUrl");
			return (Criteria) this;
		}

		public Criteria andChangeLogIsNull() {
			addCriterion("change_log is null");
			return (Criteria) this;
		}

		public Criteria andChangeLogIsNotNull() {
			addCriterion("change_log is not null");
			return (Criteria) this;
		}

		public Criteria andChangeLogEqualTo(String value) {
			addCriterion("change_log =", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotEqualTo(String value) {
			addCriterion("change_log <>", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogGreaterThan(String value) {
			addCriterion("change_log >", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogGreaterThanOrEqualTo(String value) {
			addCriterion("change_log >=", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLessThan(String value) {
			addCriterion("change_log <", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLessThanOrEqualTo(String value) {
			addCriterion("change_log <=", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLike(String value) {
			addCriterion("change_log like", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotLike(String value) {
			addCriterion("change_log not like", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogIn(List<String> values) {
			addCriterion("change_log in", values, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotIn(List<String> values) {
			addCriterion("change_log not in", values, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogBetween(String value1, String value2) {
			addCriterion("change_log between", value1, value2, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotBetween(String value1, String value2) {
			addCriterion("change_log not between", value1, value2, "changeLog");
			return (Criteria) this;
		}

		public Criteria andPageTypeIsNull() {
			addCriterion("page_type is null");
			return (Criteria) this;
		}

		public Criteria andPageTypeIsNotNull() {
			addCriterion("page_type is not null");
			return (Criteria) this;
		}

		public Criteria andPageTypeEqualTo(Byte value) {
			addCriterion("page_type =", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeNotEqualTo(Byte value) {
			addCriterion("page_type <>", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeGreaterThan(Byte value) {
			addCriterion("page_type >", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("page_type >=", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeLessThan(Byte value) {
			addCriterion("page_type <", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("page_type <=", value, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeIn(List<Byte> values) {
			addCriterion("page_type in", values, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeNotIn(List<Byte> values) {
			addCriterion("page_type not in", values, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeBetween(Byte value1, Byte value2) {
			addCriterion("page_type between", value1, value2, "pageType");
			return (Criteria) this;
		}

		public Criteria andPageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("page_type not between", value1, value2, "pageType");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdIsNull() {
			addCriterion("client_version_id is null");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdIsNotNull() {
			addCriterion("client_version_id is not null");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdEqualTo(Long value) {
			addCriterion("client_version_id =", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdNotEqualTo(Long value) {
			addCriterion("client_version_id <>", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdGreaterThan(Long value) {
			addCriterion("client_version_id >", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("client_version_id >=", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdLessThan(Long value) {
			addCriterion("client_version_id <", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdLessThanOrEqualTo(Long value) {
			addCriterion("client_version_id <=", value, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdIn(List<Long> values) {
			addCriterion("client_version_id in", values, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdNotIn(List<Long> values) {
			addCriterion("client_version_id not in", values, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdBetween(Long value1, Long value2) {
			addCriterion("client_version_id between", value1, value2, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andClientVersionIdNotBetween(Long value1, Long value2) {
			addCriterion("client_version_id not between", value1, value2, "clientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdIsNull() {
			addCriterion("ios_client_version_id is null");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdIsNotNull() {
			addCriterion("ios_client_version_id is not null");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdEqualTo(Long value) {
			addCriterion("ios_client_version_id =", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdNotEqualTo(Long value) {
			addCriterion("ios_client_version_id <>", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdGreaterThan(Long value) {
			addCriterion("ios_client_version_id >", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ios_client_version_id >=", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdLessThan(Long value) {
			addCriterion("ios_client_version_id <", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdLessThanOrEqualTo(Long value) {
			addCriterion("ios_client_version_id <=", value, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdIn(List<Long> values) {
			addCriterion("ios_client_version_id in", values, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdNotIn(List<Long> values) {
			addCriterion("ios_client_version_id not in", values, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdBetween(Long value1, Long value2) {
			addCriterion("ios_client_version_id between", value1, value2, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andIosClientVersionIdNotBetween(Long value1, Long value2) {
			addCriterion("ios_client_version_id not between", value1, value2, "iosClientVersionId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdIsNull() {
			addCriterion("h5_channel_id is null");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdIsNotNull() {
			addCriterion("h5_channel_id is not null");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdEqualTo(Long value) {
			addCriterion("h5_channel_id =", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdNotEqualTo(Long value) {
			addCriterion("h5_channel_id <>", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdGreaterThan(Long value) {
			addCriterion("h5_channel_id >", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdGreaterThanOrEqualTo(Long value) {
			addCriterion("h5_channel_id >=", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdLessThan(Long value) {
			addCriterion("h5_channel_id <", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdLessThanOrEqualTo(Long value) {
			addCriterion("h5_channel_id <=", value, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdIn(List<Long> values) {
			addCriterion("h5_channel_id in", values, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdNotIn(List<Long> values) {
			addCriterion("h5_channel_id not in", values, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdBetween(Long value1, Long value2) {
			addCriterion("h5_channel_id between", value1, value2, "h5ChannelId");
			return (Criteria) this;
		}

		public Criteria andH5ChannelIdNotBetween(Long value1, Long value2) {
			addCriterion("h5_channel_id not between", value1, value2, "h5ChannelId");
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

		public Criteria andPlatformIdIsNull() {
			addCriterion("platform_id is null");
			return (Criteria) this;
		}

		public Criteria andPlatformIdIsNotNull() {
			addCriterion("platform_id is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformIdEqualTo(Byte value) {
			addCriterion("platform_id =", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotEqualTo(Byte value) {
			addCriterion("platform_id <>", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdGreaterThan(Byte value) {
			addCriterion("platform_id >", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdGreaterThanOrEqualTo(Byte value) {
			addCriterion("platform_id >=", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdLessThan(Byte value) {
			addCriterion("platform_id <", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdLessThanOrEqualTo(Byte value) {
			addCriterion("platform_id <=", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdIn(List<Byte> values) {
			addCriterion("platform_id in", values, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotIn(List<Byte> values) {
			addCriterion("platform_id not in", values, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdBetween(Byte value1, Byte value2) {
			addCriterion("platform_id between", value1, value2, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotBetween(Byte value1, Byte value2) {
			addCriterion("platform_id not between", value1, value2, "platformId");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIsNull() {
			addCriterion("is_published is null");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIsNotNull() {
			addCriterion("is_published is not null");
			return (Criteria) this;
		}

		public Criteria andIsPublishedEqualTo(Boolean value) {
			addCriterion("is_published =", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotEqualTo(Boolean value) {
			addCriterion("is_published <>", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedGreaterThan(Boolean value) {
			addCriterion("is_published >", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_published >=", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedLessThan(Boolean value) {
			addCriterion("is_published <", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_published <=", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIn(List<Boolean> values) {
			addCriterion("is_published in", values, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotIn(List<Boolean> values) {
			addCriterion("is_published not in", values, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_published between", value1, value2, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_published not between", value1, value2, "isPublished");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIsNull() {
			addCriterion("publish_time is null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIsNotNull() {
			addCriterion("publish_time is not null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeEqualTo(Date value) {
			addCriterion("publish_time =", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotEqualTo(Date value) {
			addCriterion("publish_time <>", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThan(Date value) {
			addCriterion("publish_time >", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("publish_time >=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThan(Date value) {
			addCriterion("publish_time <", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
			addCriterion("publish_time <=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIn(List<Date> values) {
			addCriterion("publish_time in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotIn(List<Date> values) {
			addCriterion("publish_time not in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeBetween(Date value1, Date value2) {
			addCriterion("publish_time between", value1, value2, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
			addCriterion("publish_time not between", value1, value2, "publishTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table h5_client_version
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
     * This class corresponds to the database table h5_client_version
     *
     * @mbg.generated do_not_delete_during_merge Tue Mar 13 17:05:25 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}