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
public class DatabaseIgnoresRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3628809755823105417L;

	private String folder = null;
	
	private List<String> expanded = null;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseIgnoresRequest [folder=").append(folder).append(", expanded=").append(expanded).append("]");
		return builder.toString();
	}

	
}
