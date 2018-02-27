package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomString implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2467136473050281940L;
	
	private String random = null;

	/**
	 * @return the random
	 */
	public String getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(String random) {
		this.random = random;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RandomString [random=").append(random).append("]");
		return builder.toString();
	}
	
	
	
}
