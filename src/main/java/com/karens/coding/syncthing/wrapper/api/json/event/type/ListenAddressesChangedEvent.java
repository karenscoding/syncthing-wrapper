package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.ListenAddressesChangedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListenAddressesChangedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7712813396776241455L;
	
	protected ListenAddressesChangedEventData data = null;

	/**
	 * @return the data
	 */
	public ListenAddressesChangedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ListenAddressesChangedEventData data) {
		this.data = data;
	}
	
	
}
