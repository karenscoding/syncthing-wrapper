package com.karens.coding.syncthing.wrapper.api.json.event.type;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.EventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract public class AbstractEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453849909950376156L;

	/** 
	 * A unique ID for this event on the events API. It always increases by 1: the first event generated has id 1, 
	 * the next has id 2 etc. If this increases by more than 1, then one or more events have been skipped by the 
	 * events API. 
	 */
	protected Integer id = null;
	
	/** 
	 * A global ID for this event, across the events API, the audit log, and any other sources. It may increase 
	 * by more than 1, but it will always be greater than or equal to the id. 
	 */
	protected Integer globalID = null;
	
	/** The time the event was generated. */
	protected String time = null;
    
	/** 
	 * Indicates the type of (i.e. reason for) the event and is one of the event types below:
	 *  
	 *  ConfigSaved
	 *  DeviceConnected
	 *  DeviceDisconnected
	 *  DeviceDiscovered
	 *  DevicePaused
	 *  DeviceRejected
	 *  DeviceResumed
	 *  DownloadProgress
	 *  FolderCompletion
	 *  FolderErrors
	 *  FolderRejected
	 *  Folder Scan Progress
	 *  FolderSummary
	 *  ItemFinished
	 *  ItemStarted
	 *  Listen Addresses Changed
	 *  LocalChangeDetected
	 *  LocalIndexUpdated
	 *  Login Attempt
	 *  RemoteChangeDetected
	 *  Remote Download Progress
	 *  RemoteIndexUpdated
	 *  Starting
	 *  StartupComplete
	 *  StateChanged
	 */
	protected String type = null;
	
	/** An object containing optional extra information; the exact structure is determined by the event type. */
	protected EventData data = null;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the globalID
	 */
	public Integer getGlobalID() {
		return globalID;
	}

	/**
	 * @param globalID the globalID to set
	 */
	public void setGlobalID(Integer globalID) {
		this.globalID = globalID;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the data
	 */
	public EventData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(EventData data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeneralEvent [id=").append(id).append(", globalID=").append(globalID).append(", time=").append(time).append(", type=").append(type).append(", data=")
				.append(data).append("]");
		return builder.toString();
	}
    
    
}
