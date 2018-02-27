package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartupCompleteEventData implements Serializable, EventData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4902776366297628400L;

	
	
}
