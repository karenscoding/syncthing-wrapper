package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Directory implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2153812802981547930L;

	private Map<String, Long> file = null;
	
	private Map<String,  Map<String, Long>> subdirectory = null;

	/**
	 * @return the file
	 */
	public Map<String, Long> getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(Map<String, Long> file) {
		this.file = file;
	}

	/**
	 * @return the subdirectory
	 */
	public Map<String, Map<String, Long>> getSubdirectory() {
		return subdirectory;
	}

	/**
	 * @param subdirectory the subdirectory to set
	 */
	public void setSubdirectory(Map<String, Map<String, Long>> subdirectory) {
		this.subdirectory = subdirectory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Directory [file=").append(file).append(", subdirectory=").append(subdirectory).append("]");
		return builder.toString();
	}

	
}
