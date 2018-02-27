package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadProgressEventData implements Serializable, EventData {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -848408023941180854L;
	protected Map <String, Object> data = null;

	/**
	 * @return the data
	 */
	@JsonAnyGetter
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	@JsonAnySetter
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownloadProgressEventData [data=").append(data).append("]");
		return builder.toString();
	}
	
	
}
