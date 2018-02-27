package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteDownloadProgressEventData implements Serializable, EventData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909177692570941518L;
	
	private String device = null;
	
	private String folder = null;
	
    private Map<String, Integer> state = null;
    
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
	
	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}
	
	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	/**
	 * @return the state
	 */
	public Map<String, Integer> getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(Map<String, Integer> state) {
		this.state = state;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RemoteDownloadProgressEventData [device=").append(device).append(", folder=").append(folder).append(", state=").append(state).append("]");
		return builder.toString();
	}
    
}
