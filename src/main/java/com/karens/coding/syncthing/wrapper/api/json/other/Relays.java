package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Relays implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7143215186431076886L;

	private Integer defaultServers = null;
	
    private Boolean enabled = null;
    
    private Integer otherServers = null;

	/**
	 * @return the defaultServers
	 */
	public Integer getDefaultServers() {
		return defaultServers;
	}

	/**
	 * @param defaultServers the defaultServers to set
	 */
	public void setDefaultServers(Integer defaultServers) {
		this.defaultServers = defaultServers;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the otherServers
	 */
	public Integer getOtherServers() {
		return otherServers;
	}

	/**
	 * @param otherServers the otherServers to set
	 */
	public void setOtherServers(Integer otherServers) {
		this.otherServers = otherServers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Relays [defaultServers=").append(defaultServers).append(", enabled=").append(enabled).append(", otherServers=").append(otherServers).append("]");
		return builder.toString();
	}
    
}
