package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderSummaryEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderSummaryEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375761000589436967L;
	
	public FolderSummaryEventData data = null;

	/**
	 * @return the data
	 */
	public FolderSummaryEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderSummaryEventData data) {
		this.data = data;
	}
	
	
}
