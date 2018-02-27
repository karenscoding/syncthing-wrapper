package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 402389581067601661L;
	
	private Integer tcp = null;

	/**
	 * @return the tcp
	 */
	public Integer getTcp() {
		return tcp;
	}

	/**
	 * @param tcp the tcp to set
	 */
	public void setTcp(Integer tcp) {
		this.tcp = tcp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransportStats [tcp=").append(tcp).append("]");
		return builder.toString();
	}
	
}
