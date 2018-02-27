package com.karens.coding.syncthing.wrapper.api.json.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.FolderRequest;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseScanRequest extends FolderRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3013995693228133199L;

	/** Path relative to the folder root */
	private String sub = null;
	
	/** Time in seconds to delay Syncthing's automated rescan interval */
	private Integer next = null;

	/**
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * @param sub the sub to set
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}

	/**
	 * @return the next
	 */
	public Integer getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Integer next) {
		this.next = next;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseScanRequest [sub=").append(sub).append(", next=").append(next).append("]");
		return builder.toString();
	}
	
	
}
