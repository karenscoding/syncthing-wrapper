package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderPausedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderPausedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4916893532124029251L;
	
	protected FolderPausedEventData data = null;

	/**
	 * @return the data
	 */
	public FolderPausedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderPausedEventData data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderPausedEvent [data=").append(data).append("]");
		return builder.toString();
	}
	
	
}
