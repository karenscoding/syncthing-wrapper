package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemConfigInSync implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1878929994900173522L;
	
	private Boolean configInSync = null;

	/**
	 * @return the configInSync
	 */
	public Boolean getConfigInSync() {
		return configInSync;
	}

	/**
	 * @param configInSync the configInSync to set
	 */
	public void setConfigInSync(Boolean configInSync) {
		this.configInSync = configInSync;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConfigInSync [configInSync=").append(configInSync).append("]");
		return builder.toString();
	}

	
}
