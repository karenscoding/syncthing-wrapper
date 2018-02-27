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
public class Device implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2590514296263148511L;

	private String deviceID = null;
	
	private String name = null;
	
	private List<String> addresses = null;
	
	private String compression = null;
	
	private String certName = null;
	
	private Boolean introducer = null;
	
	private Boolean skipIntroductionRemovals = null;
	
	private String introducedBy = null;
	
	private Boolean paused = null;
	
	private List<String> allowedNetworks = null;

	/**
	 * @return the deviceID
	 */
	public String getDeviceID() {
		return deviceID;
	}

	/**
	 * @param deviceID the deviceID to set
	 */
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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

	/**
	 * @return the compression
	 */
	public String getCompression() {
		return compression;
	}

	/**
	 * @param compression the compression to set
	 */
	public void setCompression(String compression) {
		this.compression = compression;
	}

	/**
	 * @return the certName
	 */
	public String getCertName() {
		return certName;
	}

	/**
	 * @param certName the certName to set
	 */
	public void setCertName(String certName) {
		this.certName = certName;
	}

	/**
	 * @return the introducer
	 */
	public Boolean getIntroducer() {
		return introducer;
	}

	/**
	 * @param introducer the introducer to set
	 */
	public void setIntroducer(Boolean introducer) {
		this.introducer = introducer;
	}

	/**
	 * @return the skipIntroductionRemovals
	 */
	public Boolean getSkipIntroductionRemovals() {
		return skipIntroductionRemovals;
	}

	/**
	 * @param skipIntroductionRemovals the skipIntroductionRemovals to set
	 */
	public void setSkipIntroductionRemovals(Boolean skipIntroductionRemovals) {
		this.skipIntroductionRemovals = skipIntroductionRemovals;
	}

	/**
	 * @return the introducedBy
	 */
	public String getIntroducedBy() {
		return introducedBy;
	}

	/**
	 * @param introducedBy the introducedBy to set
	 */
	public void setIntroducedBy(String introducedBy) {
		this.introducedBy = introducedBy;
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
	 * @return the allowedNetworks
	 */
	public List<String> getAllowedNetworks() {
		return allowedNetworks;
	}

	/**
	 * @param allowedNetworks the allowedNetworks to set
	 */
	public void setAllowedNetworks(List<String> allowedNetworks) {
		this.allowedNetworks = allowedNetworks;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [deviceID=").append(deviceID).append(", name=").append(name).append(", addresses=").append(addresses).append(", compression=").append(compression)
				.append(", certName=").append(certName).append(", introducer=").append(introducer).append(", skipIntroductionRemovals=").append(skipIntroductionRemovals)
				.append(", introducedBy=").append(introducedBy).append(", paused=").append(paused).append(", allowedNetworks=").append(allowedNetworks).append("]");
		return builder.toString();
	}

	
}
