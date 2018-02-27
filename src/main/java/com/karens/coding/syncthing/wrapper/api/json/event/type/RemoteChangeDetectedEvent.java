package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.RemoteChangeDetectedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteChangeDetectedEvent extends AbstractEvent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6111788267180016909L;
	
	protected RemoteChangeDetectedEventData data = null;

	/**
	 * @return the data
	 */
	public RemoteChangeDetectedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(RemoteChangeDetectedEventData data) {
		this.data = data;
	}
	
	
}
