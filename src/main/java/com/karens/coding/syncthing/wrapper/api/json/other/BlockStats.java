package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5739198586440510690L;

	private Long total = null;
	
	private Long renamed = null;

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the renamed
	 */
	public Long getRenamed() {
		return renamed;
	}

	/**
	 * @param renamed the renamed to set
	 */
	public void setRenamed(Long renamed) {
		this.renamed = renamed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlockStats [total=").append(total).append(", renamed=").append(renamed).append("]");
		return builder.toString();
	}
	
	
}
