package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadProgress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3397716228595573971L;

	private Integer total = null;
	
	private Integer reused = null;
	
	private Integer copiedFromOrigin = null;
	
	private Integer copiedFromOriginShifted = null;
	
	private Integer copiedFromElsewhere = null;
	
	private Integer pulled = null;
	
	private Integer pulling = null;
	
	private Long bytesDone = null;
	
	private Long bytesTotal = null;

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the reused
	 */
	public Integer getReused() {
		return reused;
	}

	/**
	 * @param reused the reused to set
	 */
	public void setReused(Integer reused) {
		this.reused = reused;
	}

	/**
	 * @return the copiedFromOrigin
	 */
	public Integer getCopiedFromOrigin() {
		return copiedFromOrigin;
	}

	/**
	 * @param copiedFromOrigin the copiedFromOrigin to set
	 */
	public void setCopiedFromOrigin(Integer copiedFromOrigin) {
		this.copiedFromOrigin = copiedFromOrigin;
	}

	/**
	 * @return the copiedFromOriginShifted
	 */
	public Integer getCopiedFromOriginShifted() {
		return copiedFromOriginShifted;
	}

	/**
	 * @param copiedFromOriginShifted the copiedFromOriginShifted to set
	 */
	public void setCopiedFromOriginShifted(Integer copiedFromOriginShifted) {
		this.copiedFromOriginShifted = copiedFromOriginShifted;
	}

	/**
	 * @return the copiedFromElsewhere
	 */
	public Integer getCopiedFromElsewhere() {
		return copiedFromElsewhere;
	}

	/**
	 * @param copiedFromElsewhere the copiedFromElsewhere to set
	 */
	public void setCopiedFromElsewhere(Integer copiedFromElsewhere) {
		this.copiedFromElsewhere = copiedFromElsewhere;
	}

	/**
	 * @return the pulled
	 */
	public Integer getPulled() {
		return pulled;
	}

	/**
	 * @param pulled the pulled to set
	 */
	public void setPulled(Integer pulled) {
		this.pulled = pulled;
	}

	/**
	 * @return the pulling
	 */
	public Integer getPulling() {
		return pulling;
	}

	/**
	 * @param pulling the pulling to set
	 */
	public void setPulling(Integer pulling) {
		this.pulling = pulling;
	}

	/**
	 * @return the bytesDone
	 */
	public Long getBytesDone() {
		return bytesDone;
	}

	/**
	 * @param bytesDone the bytesDone to set
	 */
	public void setBytesDone(Long bytesDone) {
		this.bytesDone = bytesDone;
	}

	/**
	 * @return the bytesTotal
	 */
	public Long getBytesTotal() {
		return bytesTotal;
	}

	/**
	 * @param bytesTotal the bytesTotal to set
	 */
	public void setBytesTotal(Long bytesTotal) {
		this.bytesTotal = bytesTotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownloadProgress [total=").append(total).append(", reused=").append(reused).append(", copiedFromOrigin=").append(copiedFromOrigin)
				.append(", copiedFromOriginShifted=").append(copiedFromOriginShifted).append(", copiedFromElsewhere=").append(copiedFromElsewhere).append(", pulled=")
				.append(pulled).append(", pulling=").append(pulling).append(", bytesDone=").append(bytesDone).append(", bytesTotal=").append(bytesTotal).append("]");
		return builder.toString();
	}
	
}
