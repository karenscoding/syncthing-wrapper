package com.karens.coding.syncthing.wrapper.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileFolderRequest extends FolderRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6577089606822126293L;
	
	private String file = null;

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileFolderRequest [file=").append(file).append("]");
		return builder.toString();
	}

	
}
