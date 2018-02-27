package com.karens.coding.syncthing.wrapper.api.json.database;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileDetails extends FileProgress {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5624220790987454715L;

	private Integer numBlocks = null;
    
    private String[] version = null;

	

	/**
	 * @return the numBlocks
	 */
	public Integer getNumBlocks() {
		return numBlocks;
	}

	/**
	 * @param numBlocks the numBlocks to set
	 */
	public void setNumBlocks(Integer numBlocks) {
		this.numBlocks = numBlocks;
	}

	/**
	 * @return the version
	 */
	public String[] getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String[] version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileDetails [numBlocks=").append(numBlocks).append(", version=").append(Arrays.toString(version)).append("]");
		return builder.toString();
	}


}
