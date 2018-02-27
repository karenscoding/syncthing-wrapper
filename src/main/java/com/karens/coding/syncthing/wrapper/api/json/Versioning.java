package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Versioning implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8794101256953851461L;

	private String type = null;
	
    private VersionParams params = null;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the params
	 */
	public VersionParams getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(VersionParams params) {
		this.params = params;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Versioning [type=").append(type).append(", params=").append(params).append("]");
		return builder.toString();
	}

	
}
