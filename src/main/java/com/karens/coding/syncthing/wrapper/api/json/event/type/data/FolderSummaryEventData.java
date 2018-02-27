package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.FolderStatus;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderSummaryEventData implements Serializable, EventData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 242148691992110294L;

	private String folder = null;
	
	private FolderStatus summary = null;

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
	 * @return the summary
	 */
	public FolderStatus getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(FolderStatus summary) {
		this.summary = summary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderSummaryEventData [folder=").append(folder).append("]");
		return builder.toString();
	}
	
	
}
