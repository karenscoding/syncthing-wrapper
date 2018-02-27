package com.karens.coding.syncthing.wrapper.api.json.event.type;

import com.karens.coding.syncthing.wrapper.api.json.event.type.data.EventData;

/**
 * 
 * @author karen
 *
 */
public interface Event {
	/**
	 * 
	 * @return
	 */
	public EventData getData();
	
	/**
	 * 
	 * @param data
	 */
	public void setData(EventData data); 
	
}
