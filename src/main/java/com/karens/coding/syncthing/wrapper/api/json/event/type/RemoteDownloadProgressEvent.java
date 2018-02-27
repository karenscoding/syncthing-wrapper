package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.RemoteDownloadProgressEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteDownloadProgressEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7857811774129468771L;
	
	protected RemoteDownloadProgressEventData data = null;

	/**
	 * @return the data
	 */
	public RemoteDownloadProgressEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(RemoteDownloadProgressEventData data) {
		this.data = data;
	}
	
	
}
