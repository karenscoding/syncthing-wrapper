package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.StateChangedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateChangedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7460137223120183356L;
	
	protected StateChangedEventData data = null;
	
	/**
	 * @return the data
	 */
	public StateChangedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(StateChangedEventData data) {
		this.data = data;
	}
}
