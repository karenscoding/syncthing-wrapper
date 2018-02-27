package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemUpgrade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -32619917946820310L;

	private String latest = null;
	
	private String majorNewer = null;
	
	private String newer = null;
	
	private String running = null;

	/**
	 * @return the latest
	 */
	public String getLatest() {
		return latest;
	}

	/**
	 * @param latest the latest to set
	 */
	public void setLatest(String latest) {
		this.latest = latest;
	}

	/**
	 * @return the majorNewer
	 */
	public String getMajorNewer() {
		return majorNewer;
	}

	/**
	 * @param majorNewer the majorNewer to set
	 */
	public void setMajorNewer(String majorNewer) {
		this.majorNewer = majorNewer;
	}

	/**
	 * @return the newer
	 */
	public String getNewer() {
		return newer;
	}

	/**
	 * @param newer the newer to set
	 */
	public void setNewer(String newer) {
		this.newer = newer;
	}

	/**
	 * @return the running
	 */
	public String getRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(String running) {
		this.running = running;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemUpgrade [latest=").append(latest).append(", majorNewer=").append(majorNewer).append(", newer=").append(newer).append(", running=").append(running)
				.append("]");
		return builder.toString();
	}

	
}
