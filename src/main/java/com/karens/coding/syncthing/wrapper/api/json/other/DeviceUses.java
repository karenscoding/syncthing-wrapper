package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceUses implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2681619201742367377L;

	private Integer compressAlways = null;
	
    private Integer compressMetadata = null;
    
    private Integer compressNever = null;
    
    private Integer customCertName = null;
    
    private Integer dynamicAddr = null;
    
    private Integer introducer = null;
    
    private Integer staticAddr = null;

	/**
	 * @return the compressAlways
	 */
	public Integer getCompressAlways() {
		return compressAlways;
	}

	/**
	 * @param compressAlways the compressAlways to set
	 */
	public void setCompressAlways(Integer compressAlways) {
		this.compressAlways = compressAlways;
	}

	/**
	 * @return the compressMetadata
	 */
	public Integer getCompressMetadata() {
		return compressMetadata;
	}

	/**
	 * @param compressMetadata the compressMetadata to set
	 */
	public void setCompressMetadata(Integer compressMetadata) {
		this.compressMetadata = compressMetadata;
	}

	/**
	 * @return the compressNever
	 */
	public Integer getCompressNever() {
		return compressNever;
	}

	/**
	 * @param compressNever the compressNever to set
	 */
	public void setCompressNever(Integer compressNever) {
		this.compressNever = compressNever;
	}

	/**
	 * @return the customCertName
	 */
	public Integer getCustomCertName() {
		return customCertName;
	}

	/**
	 * @param customCertName the customCertName to set
	 */
	public void setCustomCertName(Integer customCertName) {
		this.customCertName = customCertName;
	}

	/**
	 * @return the dynamicAddr
	 */
	public Integer getDynamicAddr() {
		return dynamicAddr;
	}

	/**
	 * @param dynamicAddr the dynamicAddr to set
	 */
	public void setDynamicAddr(Integer dynamicAddr) {
		this.dynamicAddr = dynamicAddr;
	}

	/**
	 * @return the introducer
	 */
	public Integer getIntroducer() {
		return introducer;
	}

	/**
	 * @param introducer the introducer to set
	 */
	public void setIntroducer(Integer introducer) {
		this.introducer = introducer;
	}

	/**
	 * @return the staticAddr
	 */
	public Integer getStaticAddr() {
		return staticAddr;
	}

	/**
	 * @param staticAddr the staticAddr to set
	 */
	public void setStaticAddr(Integer staticAddr) {
		this.staticAddr = staticAddr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceUses [compressAlways=").append(compressAlways).append(", compressMetadata=").append(compressMetadata).append(", compressNever=").append(compressNever)
				.append(", customCertName=").append(customCertName).append(", dynamicAddr=").append(dynamicAddr).append(", introducer=").append(introducer).append(", staticAddr=")
				.append(staticAddr).append("]");
		return builder.toString();
	}
    
    
}
