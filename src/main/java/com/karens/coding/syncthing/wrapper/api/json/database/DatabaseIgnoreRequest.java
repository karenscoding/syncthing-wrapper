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
public class DatabaseIgnoreRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406583915174529849L;
	
	private List<String> ignore = null;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseIgnoreRequest [ignore=").append(ignore).append("]");
		return builder.toString();
	}
	
	
}
