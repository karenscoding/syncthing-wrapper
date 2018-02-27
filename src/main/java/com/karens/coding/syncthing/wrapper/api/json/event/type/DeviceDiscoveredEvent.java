package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceDiscoveredEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDiscoveredEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7313768168512896698L;
	
	
	protected DeviceDiscoveredEventData data = null;

	/**
	 * @return the data
	 */
	public DeviceDiscoveredEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DeviceDiscoveredEventData data) {
		this.data = data;
	}

	
}
