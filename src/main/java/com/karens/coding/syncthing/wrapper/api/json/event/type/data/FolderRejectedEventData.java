package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderRejectedEventData implements Serializable, EventData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2714226269177001472L;

	private String device = null;
	
	private String folder = null;
	
	private String folderLabel = null;

	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
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

	/**
	 * @return the folderLabel
	 */
	public String getFolderLabel() {
		return folderLabel;
	}

	/**
	 * @param folderLabel the folderLabel to set
	 */
	public void setFolderLabel(String folderLabel) {
		this.folderLabel = folderLabel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderRejectedEventData [device=").append(device).append(", folder=").append(folder).append(", folderLabel=").append(folderLabel).append("]");
		return builder.toString();
	}
	
	
	
}
