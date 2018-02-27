package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.LocalIndexUpdatedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalIndexUpdatedEvent extends AbstractEvent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2466091002816132014L;
	
	protected LocalIndexUpdatedEventData data = null;

	/**
	 * @return the data
	 */
	public LocalIndexUpdatedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalIndexUpdatedEventData data) {
		this.data = data;
	}
	
	
}
