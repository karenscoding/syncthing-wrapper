package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.FolderRejectedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderRejectedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2552879121329836183L;
	
	protected FolderRejectedEventData data = null;

	/**
	 * @return the data
	 */
	public FolderRejectedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(FolderRejectedEventData data) {
		this.data = data;
	}
	
	
}
