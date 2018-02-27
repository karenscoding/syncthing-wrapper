package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderRequest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3312180660250962132L;
	
	private String folder = null;

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
		builder.append("FolderRequest [folder=").append(folder).append("]");
		return builder.toString();
	}

	
}
