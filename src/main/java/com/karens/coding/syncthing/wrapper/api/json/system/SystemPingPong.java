package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemPingPong implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1856493989414603927L;
	
	private String ping = null;

	/**
	 * @return the ping
	 */
	public String getPing() {
		return ping;
	}

	/**
	 * @param ping the ping to set
	 */
	public void setPing(String ping) {
		this.ping = ping;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemPingPong [ping=").append(ping).append("]");
		return builder.toString();
	}

	
}
