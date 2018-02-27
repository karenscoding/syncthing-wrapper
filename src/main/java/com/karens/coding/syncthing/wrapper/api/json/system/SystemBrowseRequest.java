package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemBrowseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7966320931658948153L;
	
	
	private String current = null;

	/**
	 * @return the current
	 */
	public String getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(String current) {
		this.current = current;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemBrowseRequest [current=").append(current).append("]");
		return builder.toString();
	}

	
}
