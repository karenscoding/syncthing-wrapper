package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseBrowseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9070979488502883395L;

	@NotNull
	private String folder = null;
	
	private Integer levels = null;
	
	private String prefix = null;

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	/**
	 * @return the levels
	 */
	public Integer getLevels() {
		return levels;
	}

	/**
	 * @param levels the levels to set
	 */
	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseBrowseRequest [folder=").append(folder).append(", levels=").append(levels).append(", prefix=").append(prefix).append("]");
		return builder.toString();
	}

	
}
