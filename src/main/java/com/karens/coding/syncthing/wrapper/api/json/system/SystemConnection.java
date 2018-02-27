package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362883000415329810L;

	private Boolean connected = null;
	
	private Integer inBytesTotal = null;
	
	private Boolean paused = null;
	
	private String at = null;
	
	private String clientVersion = null;
	
	private String address = null;
	
	private String type = null;
	
	private Integer outBytesTotal = null;

	/**
	 * @return the connected
	 */
	public Boolean getConnected() {
		return connected;
	}

	/**
	 * @param connected the connected to set
	 */
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	/**
	 * @return the inBytesTotal
	 */
	public Integer getInBytesTotal() {
		return inBytesTotal;
	}

	/**
	 * @param inBytesTotal the inBytesTotal to set
	 */
	public void setInBytesTotal(Integer inBytesTotal) {
		this.inBytesTotal = inBytesTotal;
	}

	/**
	 * @return the paused
	 */
	public Boolean getPaused() {
		return paused;
	}

	/**
	 * @param paused the paused to set
	 */
	public void setPaused(Boolean paused) {
		this.paused = paused;
	}

	/**
	 * @return the at
	 */
	public String getAt() {
		return at;
	}

	/**
	 * @param at the at to set
	 */
	public void setAt(String at) {
		this.at = at;
	}

	/**
	 * @return the clientVersion
	 */
	public String getClientVersion() {
		return clientVersion;
	}

	/**
	 * @param clientVersion the clientVersion to set
	 */
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the outBytesTotal
	 */
	public Integer getOutBytesTotal() {
		return outBytesTotal;
	}

	/**
	 * @param outBytesTotal the outBytesTotal to set
	 */
	public void setOutBytesTotal(Integer outBytesTotal) {
		this.outBytesTotal = outBytesTotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConnection [connected=").append(connected).append(", inBytesTotal=").append(inBytesTotal).append(", paused=").append(paused).append(", at=")
				.append(at).append(", clientVersion=").append(clientVersion).append(", address=").append(address).append(", type=").append(type).append(", outBytesTotal=")
				.append(outBytesTotal).append("]");
		return builder.toString();
	}

	
}
