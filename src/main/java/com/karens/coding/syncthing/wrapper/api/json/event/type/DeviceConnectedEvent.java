package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceConnectedEvent extends AbstractEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2589991887987023159L;
	
	protected DeviceEventData data = null;
	
	/**
	 * @return the data
	 */
	public DeviceEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DeviceEventData data) {
		this.data = data;
	}
}
