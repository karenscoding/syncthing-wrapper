package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemDebugResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8780315480711356281L;

	private List<String> enabled = null;
	
	private SystemDebugFacilities facilities = null;

	/**
	 * @return the enabled
	 */
	public List<String> getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(List<String> enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the facilities
	 */
	public SystemDebugFacilities getFacilities() {
		return facilities;
	}

	/**
	 * @param facilities the facilities to set
	 */
	public void setFacilities(SystemDebugFacilities facilities) {
		this.facilities = facilities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemDebugResponse [enabled=").append(enabled).append(", facilities=").append(facilities).append("]");
		return builder.toString();
	}

	
}
