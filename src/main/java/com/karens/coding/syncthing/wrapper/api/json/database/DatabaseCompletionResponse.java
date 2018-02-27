package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseCompletionResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6979493115311098210L;

	private Integer completion = null;
	
	private Long globalBytes = null;
	
	private Long needBytes = null;
	
	private Long needDeletes = null;

	/**
	 * @return the completion
	 */
	public Integer getCompletion() {
		return completion;
	}

	/**
	 * @param completion the completion to set
	 */
	public void setCompletion(Integer completion) {
		this.completion = completion;
	}

	/**
	 * @return the globalBytes
	 */
	public Long getGlobalBytes() {
		return globalBytes;
	}

	/**
	 * @param globalBytes the globalBytes to set
	 */
	public void setGlobalBytes(Long globalBytes) {
		this.globalBytes = globalBytes;
	}

	/**
	 * @return the needBytes
	 */
	public Long getNeedBytes() {
		return needBytes;
	}

	/**
	 * @param needBytes the needBytes to set
	 */
	public void setNeedBytes(Long needBytes) {
		this.needBytes = needBytes;
	}

	/**
	 * @return the needDeletes
	 */
	public Long getNeedDeletes() {
		return needDeletes;
	}

	/**
	 * @param needDeletes the needDeletes to set
	 */
	public void setNeedDeletes(Long needDeletes) {
		this.needDeletes = needDeletes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatabaseCompletionResponse [completion=").append(completion).append(", globalBytes=").append(globalBytes).append(", needBytes=").append(needBytes)
				.append(", needDeletes=").append(needDeletes).append("]");
		return builder.toString();
	}

	
}
