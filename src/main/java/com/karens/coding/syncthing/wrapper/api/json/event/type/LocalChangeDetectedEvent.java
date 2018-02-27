package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.LocalChangeDetectedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalChangeDetectedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -544230266894436888L;
	
	protected LocalChangeDetectedEventData data = null;

	/**
	 * @return the data
	 */
	public LocalChangeDetectedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalChangeDetectedEventData data) {
		this.data = data;
	}
	
	
}
