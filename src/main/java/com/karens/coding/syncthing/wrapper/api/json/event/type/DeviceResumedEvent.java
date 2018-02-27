package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceIdEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceResumedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6478168612170861208L;
	
	protected DeviceIdEventData data = null;

	/**
	 * @return the data
	 */
	public DeviceIdEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DeviceIdEventData data) {
		this.data = data;
	}

	
}
