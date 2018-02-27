package com.karens.coding.syncthing.wrapper.api.json.statistics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8281802092389375539L;
	
	private String lastSeen = null;

	/**
	 * @return the lastSeen
	 */
	public String getLastSeen() {
		return lastSeen;
	}

	/**
	 * @param lastSeen the lastSeen to set
	 */
	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatisticsDevice [lastSeen=").append(lastSeen).append("]");
		return builder.toString();
	}
	
	
}
