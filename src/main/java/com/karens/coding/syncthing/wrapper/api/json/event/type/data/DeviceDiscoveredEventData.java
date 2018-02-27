package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDiscoveredEventData implements Serializable, EventData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7162808698992698729L;

	private String[] addrs = null;
	
	private String device = null;

	/**
	 * @return the addrs
	 */
	public String[] getAddrs() {
		return addrs;
	}

	/**
	 * @param addrs the addrs to set
	 */
	public void setAddrs(String[] addrs) {
		this.addrs = addrs;
	}

	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceDiscoveredEventData [addrs=").append(Arrays.toString(addrs)).append(", device=").append(device).append("]");
		return builder.toString();
	}
	
	

}
