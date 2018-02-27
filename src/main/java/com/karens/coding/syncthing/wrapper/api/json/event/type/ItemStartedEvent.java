package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.ItemStartedEventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemStartedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -700629676047250139L;
	
	
	protected ItemStartedEventData data = null;

	/**
	 * @return the data
	 */
	public ItemStartedEventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ItemStartedEventData data) {
		this.data = data;
	}
	
	
}
