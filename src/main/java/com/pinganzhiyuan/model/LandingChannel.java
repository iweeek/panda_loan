package com.pinganzhiyuan.model;

public class LandingChannel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column landing_channel.id
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column landing_channel.name
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column landing_channel.channel_uid
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	private String channelUid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column landing_channel.id
	 * @return  the value of landing_channel.id
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column landing_channel.id
	 * @param id  the value for landing_channel.id
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column landing_channel.name
	 * @return  the value of landing_channel.name
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column landing_channel.name
	 * @param name  the value for landing_channel.name
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column landing_channel.channel_uid
	 * @return  the value of landing_channel.channel_uid
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public String getChannelUid() {
		return channelUid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column landing_channel.channel_uid
	 * @param channelUid  the value for landing_channel.channel_uid
	 * @mbg.generated  Wed Apr 04 16:23:39 CST 2018
	 */
	public void setChannelUid(String channelUid) {
		this.channelUid = channelUid;
	}
}