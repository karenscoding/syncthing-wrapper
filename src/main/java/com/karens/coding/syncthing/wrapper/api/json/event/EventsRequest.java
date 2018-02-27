package com.karens.coding.syncthing.wrapper.api.json.event;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3123645163816233411L;

	/** Events starting after the given ID */
	private Integer since = null;
	
	/** Fail after given seconds if no event is available, 2s by default */
	private Integer timeout = null;
	
	/** The last x number of events to be returned */
	private Integer limit = null;
	
	private String events = null;

	/**
	 * @return the since
	 */
	public Integer getSince() {
		return since;
	}

	/**
	 * @param since the since to set
	 */
	public void setSince(Integer since) {
		this.since = since;
	}

	/**
	 * @return the timeout
	 */
	public Integer getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the events
	 */
	public String getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventsRequest [since=").append(since).append(", timeout=").append(timeout).append(", limit=").append(limit).append(", events=").append(events).append("]");
		return builder.toString();
	}

	
}
