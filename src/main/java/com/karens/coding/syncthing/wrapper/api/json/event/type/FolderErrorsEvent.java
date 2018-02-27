package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderErrorsEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderErrorsEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3314173807757238913L;
	
	
	protected FolderErrorsEventData data = null;

	/**
	 * @return the data
	 */
	public FolderErrorsEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderErrorsEventData data) {
		this.data = data;
	}
	
	
}
