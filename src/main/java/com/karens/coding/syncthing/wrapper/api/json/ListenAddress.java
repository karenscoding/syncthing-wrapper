package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListenAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2199628414192400340L;

	@JsonProperty("Scheme")
	private String scheme = null;
	
	@JsonProperty("Opaque")
	private String opaque = null;
	
	@JsonProperty("User")
	private Object user = null;
	
	@JsonProperty("Host")
	private String host = null;
	
	@JsonProperty("Path")
	private String path = null;
	
	@JsonProperty("RawPath")
	private String rawPath = null;
	
	@JsonProperty("ForceQuery")
	private Boolean forceQuery = null;
	
	@JsonProperty("RawQuery")
	private String rawQuery = null;
	
	@JsonProperty("Fragment")
	private String fragment = null;

	/**
	 * @return the scheme
	 */
	@JsonProperty("Scheme")
	public String getScheme() {
		return scheme;
	}

	/**
	 * @param scheme the scheme to set
	 */
	@JsonProperty("Scheme")
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the opaque
	 */
	@JsonProperty("Opaque")
	public String getOpaque() {
		return opaque;
	}

	/**
	 * @param opaque the opaque to set
	 */
	@JsonProperty("Opaque")
	public void setOpaque(String opaque) {
		this.opaque = opaque;
	}

	/**
	 * @return the user
	 */
	@JsonProperty("User")
	public Object getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	@JsonProperty("User")
	public void setUser(Object user) {
		this.user = user;
	}

	/**
	 * @return the host
	 */
	@JsonProperty("Host")
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	@JsonProperty("Host")
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the path
	 */
	@JsonProperty("Path")
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	@JsonProperty("Path")
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the rawPath
	 */
	@JsonProperty("RawPath")
	public String getRawPath() {
		return rawPath;
	}

	/**
	 * @param rawPath the rawPath to set
	 */
	@JsonProperty("RawPath")
	public void setRawPath(String rawPath) {
		this.rawPath = rawPath;
	}

	/**
	 * @return the forceQuery
	 */
	@JsonProperty("ForceQuery")
	public Boolean getForceQuery() {
		return forceQuery;
	}

	/**
	 * @param forceQuery the forceQuery to set
	 */
	@JsonProperty("ForceQuery")
	public void setForceQuery(Boolean forceQuery) {
		this.forceQuery = forceQuery;
	}

	/**
	 * @return the rawQuery
	 */
	@JsonProperty("RawQuery")
	public String getRawQuery() {
		return rawQuery;
	}

	/**
	 * @param rawQuery the rawQuery to set
	 */
	@JsonProperty("RawQuery")
	public void setRawQuery(String rawQuery) {
		this.rawQuery = rawQuery;
	}

	/**
	 * @return the fragment
	 */
	@JsonProperty("Fragment")
	public String getFragment() {
		return fragment;
	}

	/**
	 * @param fragment the fragment to set
	 */
	@JsonProperty("Fragment")
	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListenAddress [scheme=").append(scheme).append(", opaque=").append(opaque).append(", user=").append(user).append(", host=").append(host).append(", path=")
				.append(path).append(", rawPath=").append(rawPath).append(", forceQuery=").append(forceQuery).append(", rawQuery=").append(rawQuery).append(", fragment=")
				.append(fragment).append("]");
		return builder.toString();
	}

	
	
}
