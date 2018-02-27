package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemConnectionService implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6994258739079432670L;

	private String[] lanAddresses = null;
	
	private String[] wanAddresses = null;

	/**
	 * @return the lanAddresses
	 */
	public String[] getLanAddresses() {
		return lanAddresses;
	}

	/**
	 * @param lanAddresses the lanAddresses to set
	 */
	public void setLanAddresses(String[] lanAddresses) {
		this.lanAddresses = lanAddresses;
	}

	/**
	 * @return the wanAddresses
	 */
	public String[] getWanAddresses() {
		return wanAddresses;
	}

	/**
	 * @param wanAddresses the wanAddresses to set
	 */
	public void setWanAddresses(String[] wanAddresses) {
		this.wanAddresses = wanAddresses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConnectionService [lanAddresses=").append(Arrays.toString(lanAddresses)).append(", wanAddresses=").append(Arrays.toString(wanAddresses)).append("]");
		return builder.toString();
	}

	
}
