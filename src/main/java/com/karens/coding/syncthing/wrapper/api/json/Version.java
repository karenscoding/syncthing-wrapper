package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Version implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2126957435008295300L;

	private String arch = null;
	
	private String codename = null;
	
	private String longVersion = null;
	
	private String os = null;
	
	private String version = null;

	/**
	 * @return the arch
	 */
	public String getArch() {
		return arch;
	}

	/**
	 * @param arch the arch to set
	 */
	public void setArch(String arch) {
		this.arch = arch;
	}

	/**
	 * @return the codename
	 */
	public String getCodename() {
		return codename;
	}

	/**
	 * @param codename the codename to set
	 */
	public void setCodename(String codename) {
		this.codename = codename;
	}

	/**
	 * @return the longVersion
	 */
	public String getLongVersion() {
		return longVersion;
	}

	/**
	 * @param longVersion the longVersion to set
	 */
	public void setLongVersion(String longVersion) {
		this.longVersion = longVersion;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Version [arch=").append(arch).append(", codename=").append(codename).append(", longVersion=").append(longVersion).append(", os=").append(os)
				.append(", version=").append(version).append("]");
		return builder.toString();
	}

	
}
