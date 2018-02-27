package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderCompletionEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderCompletionEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2396123720792434287L;
	
	protected FolderCompletionEventData data = null;

	/**
	 * @return the data
	 */
	public FolderCompletionEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderCompletionEventData data) {
		this.data = data;
	}
	
	
}
