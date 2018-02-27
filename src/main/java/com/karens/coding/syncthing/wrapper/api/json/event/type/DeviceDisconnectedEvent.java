package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceErrorEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDisconnectedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5506703621095516164L;
	
	protected DeviceErrorEventData data = null;

	/**
	 * @return the data
	 */
	public DeviceErrorEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DeviceErrorEventData data) {
		this.data = data;
	}
	
	
}
