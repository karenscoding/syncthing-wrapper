package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7010103952867441119L;
	
	private Integer random = null;

	/**
	 * @return the random
	 */
	public Integer getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(Integer random) {
		this.random = random;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PullOrder [random=").append(random).append("]");
		return builder.toString();
	}
	
	
}
