package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DownloadProgressEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadProgressEvent extends AbstractEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4325676098551047366L;
	
	protected DownloadProgressEventData data = null;

	/**
	 * @return the data
	 */
	public DownloadProgressEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DownloadProgressEventData data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownloadProgressEvent [data=").append(data).append("]");
		return builder.toString();
	}
	
	
}
