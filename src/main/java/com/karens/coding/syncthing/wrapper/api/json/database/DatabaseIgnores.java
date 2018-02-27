package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseIgnores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6908215413958561903L;

	private List<String> ignore = null;
	
	private List<String> expanded = null;
	
	private String folder = null;

	/**
	 * @return the ignore
	 */
	public List<String> getIgnore() {
		return ignore;
	}

	/**
	 * @param ignore the ignore to set
	 */
	public void setIgnore(List<String> ignore) {
		this.ignore = ignore;
	}

	/**
	 * @return the expanded
	 */
	public List<String> getExpanded() {
		return expanded;
	}

	/**
	 * @param expanded the expanded to set
	 */
	public void setExpanded(List<String> expanded) {
		this.expanded = expanded;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseIgnores [ignore=").append(ignore).append(", expanded=").append(expanded).append(", folder=").append(folder).append("]");
		return builder.toString();
	}

	
}
