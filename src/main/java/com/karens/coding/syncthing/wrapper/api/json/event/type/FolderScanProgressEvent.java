package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderScanProgressEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderScanProgressEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158655431750377163L;
	
	protected FolderScanProgressEventData data = null;

	/**
	 * @return the data
	 */
	public FolderScanProgressEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderScanProgressEventData data) {
		this.data = data;
	}
	
	
}
