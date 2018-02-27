package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemDebugRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5711629686578765230L;

	private String disable = null;
	
	private String enable = null;

	/**
	 * @return the disable
	 */
	public String getDisable() {
		return disable;
	}

	/**
	 * @param disable the disable to set
	 */
	public void setDisable(String disable) {
		this.disable = disable;
	}

	/**
	 * @return the enable
	 */
	public String getEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemDebugRequest [disable=").append(disable).append(", enable=").append(enable).append("]");
		return builder.toString();
	}

	
}
