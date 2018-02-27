package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Addresses implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 641228675871887478L;
	
	private List<String> addresses = null;

	/**
	 * @return the addresses
	 */
	public List<String> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Addresses [addresses=").append(addresses).append("]");
		return builder.toString();
	}

	
}
