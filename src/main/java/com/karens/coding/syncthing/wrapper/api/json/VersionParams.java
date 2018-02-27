package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionParams implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5677304543262452264L;

	private String cleanInterval = null;
	
    private String maxAge = null;
    
    private String versionsPath = null;
    
    private String cleanoutDays = null;
    
    private String keep = null;
    
    private String command = null;

	/**
	 * @return the cleanInterval
	 */
	public String getCleanInterval() {
		return cleanInterval;
	}

	/**
	 * @param cleanInterval the cleanInterval to set
	 */
	public void setCleanInterval(String cleanInterval) {
		this.cleanInterval = cleanInterval;
	}

	/**
	 * @return the maxAge
	 */
	public String getMaxAge() {
		return maxAge;
	}

	/**
	 * @param maxAge the maxAge to set
	 */
	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * @return the versionsPath
	 */
	public String getVersionsPath() {
		return versionsPath;
	}

	/**
	 * @param versionsPath the versionsPath to set
	 */
	public void setVersionsPath(String versionsPath) {
		this.versionsPath = versionsPath;
	}

	/**
	 * @return the cleanoutDays
	 */
	public String getCleanoutDays() {
		return cleanoutDays;
	}

	/**
	 * @param cleanoutDays the cleanoutDays to set
	 */
	public void setCleanoutDays(String cleanoutDays) {
		this.cleanoutDays = cleanoutDays;
	}

	/**
	 * @return the keep
	 */
	public String getKeep() {
		return keep;
	}

	/**
	 * @param keep the keep to set
	 */
	public void setKeep(String keep) {
		this.keep = keep;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VersionParams [cleanInterval=").append(cleanInterval).append(", maxAge=").append(maxAge).append(", versionsPath=").append(versionsPath)
				.append(", cleanoutDays=").append(cleanoutDays).append(", keep=").append(keep).append(", command=").append(command).append("]");
		return builder.toString();
	}

}
