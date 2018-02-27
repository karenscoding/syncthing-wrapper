package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.ListenAddress;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListenAddressesChangedEventData implements Serializable, EventData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4497654762782615154L;

	private ListenAddress address = null;
	
	private List<ListenAddress> lan = null;
	
	private List<ListenAddress> wan = null;

	/**
	 * @return the address
	 */
	public ListenAddress getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(ListenAddress address) {
		this.address = address;
	}

	/**
	 * @return the lan
	 */
	public List<ListenAddress> getLan() {
		return lan;
	}

	/**
	 * @param lan the lan to set
	 */
	public void setLan(List<ListenAddress> lan) {
		this.lan = lan;
	}

	/**
	 * @return the wan
	 */
	public List<ListenAddress> getWan() {
		return wan;
	}

	/**
	 * @param wan the wan to set
	 */
	public void setWan(List<ListenAddress> wan) {
		this.wan = wan;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListenAddressesChangedEventData [address=").append(address).append(", lan=").append(lan).append(", wan=").append(wan).append("]");
		return builder.toString();
	}

	
}
