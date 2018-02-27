package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemOk implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2288628047071230474L;
	private String ok = null;

	/**
	 * @return the ok
	 */
	public String getOk() {
		return ok;
	}

	/**
	 * @param ok the ok to set
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemOk [ok=").append(ok).append("]");
		return builder.toString();
	}

	
}
