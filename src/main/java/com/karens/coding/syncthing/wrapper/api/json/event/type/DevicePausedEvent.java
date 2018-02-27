package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceIdEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DevicePausedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3699254825011172430L;
	
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
