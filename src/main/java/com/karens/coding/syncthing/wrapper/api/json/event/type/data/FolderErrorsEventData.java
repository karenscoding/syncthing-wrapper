package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.FolderError;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderErrorsEventData implements Serializable, EventData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148012570999047414L;

	private FolderError errors = null;
	
	private String folder = null;

	/**
	 * @return the errors
	 */
	public FolderError getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(FolderError errors) {
		this.errors = errors;
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
		builder.append("FolderErrorsEventData [errors=").append(errors).append(", folder=").append(folder).append("]");
		return builder.toString();
	}
	
	
}
