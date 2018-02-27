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
public class Directories implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3637840005868907977L;
	private List<String> listings = null;

	/**
	 * @return the listings
	 */
	public List<String> getListings() {
		return listings;
	}

	/**
	 * @param listings the listings to set
	 */
	public void setListings(List<String> listings) {
		this.listings = listings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Directories [listings=").append(listings).append("]");
		return builder.toString();
	}

	
}
