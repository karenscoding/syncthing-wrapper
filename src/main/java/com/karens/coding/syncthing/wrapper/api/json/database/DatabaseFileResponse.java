package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseFileResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -367964419076805370L;

	private String availability = null;
	
	private FileDetails global = null;
	
	private FileDetails local = null;

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the global
	 */
	public FileDetails getGlobal() {
		return global;
	}

	/**
	 * @param global the global to set
	 */
	public void setGlobal(FileDetails global) {
		this.global = global;
	}

	/**
	 * @return the local
	 */
	public FileDetails getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(FileDetails local) {
		this.local = local;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseFileResponse [availability=").append(availability).append(", global=").append(global).append(", local=").append(local).append("]");
		return builder.toString();
	}

	
}
