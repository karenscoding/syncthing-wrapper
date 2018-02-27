package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderCompletionEventData implements Serializable, EventData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3497898210153190584L;

	private Integer completion = null;
	
    private String device = null;
    
    private String folder = null;
    
    private Long globalBytes = null;
    
    private Integer needBytes = null;

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
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
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
	public Integer getNeedBytes() {
		return needBytes;
	}

	/**
	 * @param needBytes the needBytes to set
	 */
	public void setNeedBytes(Integer needBytes) {
		this.needBytes = needBytes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderCompletionEventData [completion=").append(completion).append(", device=").append(device).append(", folder=").append(folder).append(", globalBytes=")
				.append(globalBytes).append(", needBytes=").append(needBytes).append("]");
		return builder.toString();
	}
    
}
