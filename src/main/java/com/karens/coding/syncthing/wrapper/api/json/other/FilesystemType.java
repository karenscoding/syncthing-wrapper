package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilesystemType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1776253419131519171L;
	
	private Integer basic = null;

	/**
	 * @return the basic
	 */
	public Integer getBasic() {
		return basic;
	}

	/**
	 * @param basic the basic to set
	 */
	public void setBasic(Integer basic) {
		this.basic = basic;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilesystemType [basic=").append(basic).append("]");
		return builder.toString();
	}
	
	
}
