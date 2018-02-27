package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.DeviceRejectedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceRejectedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6902491704594320312L;
	
	
	protected DeviceRejectedEventData data = null;

	/**
	 * @return the data
	 */
	public DeviceRejectedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DeviceRejectedEventData data) {
		this.data = data;
	}

	
	
}
