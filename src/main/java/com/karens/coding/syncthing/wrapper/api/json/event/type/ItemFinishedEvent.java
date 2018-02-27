package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.ItemFinishedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemFinishedEvent extends AbstractEvent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8407962806054206021L;
	
	protected ItemFinishedEventData data = null;

	/**
	 * @return the data
	 */
	public ItemFinishedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ItemFinishedEventData data) {
		this.data = data;
	}
	
	
}
