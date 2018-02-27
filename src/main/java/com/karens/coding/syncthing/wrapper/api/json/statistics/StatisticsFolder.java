package com.karens.coding.syncthing.wrapper.api.json.statistics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsFolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8205424319445989286L;

	private String lastSeen = null;
	
	private StatisticsFile lastFile = null;
	
	private String lastScan = null;

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

	/**
	 * @return the lastFile
	 */
	public StatisticsFile getLastFile() {
		return lastFile;
	}

	/**
	 * @param lastFile the lastFile to set
	 */
	public void setLastFile(StatisticsFile lastFile) {
		this.lastFile = lastFile;
	}

	/**
	 * @return the lastScan
	 */
	public String getLastScan() {
		return lastScan;
	}

	/**
	 * @param lastScan the lastScan to set
	 */
	public void setLastScan(String lastScan) {
		this.lastScan = lastScan;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatisticsFolder [lastSeen=").append(lastSeen).append(", lastFile=").append(lastFile).append(", lastScan=").append(lastScan).append("]");
		return builder.toString();
	}
	
	
}
