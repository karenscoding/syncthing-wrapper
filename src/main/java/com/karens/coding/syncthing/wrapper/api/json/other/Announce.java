package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Announce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6086240749598260217L;

	private Integer defaultServersDNS = null;
	
	private Integer defaultServersIP = null;
	
	private Boolean globalEnabled = null;
	
	private Boolean localEnabled = null;
	
	private Integer otherServers = null;

	/**
	 * @return the defaultServersDNS
	 */
	public Integer getDefaultServersDNS() {
		return defaultServersDNS;
	}

	/**
	 * @param defaultServersDNS the defaultServersDNS to set
	 */
	public void setDefaultServersDNS(Integer defaultServersDNS) {
		this.defaultServersDNS = defaultServersDNS;
	}

	/**
	 * @return the defaultServersIP
	 */
	public Integer getDefaultServersIP() {
		return defaultServersIP;
	}

	/**
	 * @param defaultServersIP the defaultServersIP to set
	 */
	public void setDefaultServersIP(Integer defaultServersIP) {
		this.defaultServersIP = defaultServersIP;
	}

	/**
	 * @return the globalEnabled
	 */
	public Boolean getGlobalEnabled() {
		return globalEnabled;
	}

	/**
	 * @param globalEnabled the globalEnabled to set
	 */
	public void setGlobalEnabled(Boolean globalEnabled) {
		this.globalEnabled = globalEnabled;
	}

	/**
	 * @return the localEnabled
	 */
	public Boolean getLocalEnabled() {
		return localEnabled;
	}

	/**
	 * @param localEnabled the localEnabled to set
	 */
	public void setLocalEnabled(Boolean localEnabled) {
		this.localEnabled = localEnabled;
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
		builder.append("Announce [defaultServersDNS=").append(defaultServersDNS).append(", defaultServersIP=").append(defaultServersIP).append(", globalEnabled=")
				.append(globalEnabled).append(", localEnabled=").append(localEnabled).append(", otherServers=").append(otherServers).append("]");
		return builder.toString();
	}
	
	
}
