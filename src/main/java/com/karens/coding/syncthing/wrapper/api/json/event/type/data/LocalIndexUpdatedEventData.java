package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalIndexUpdatedEventData implements Serializable, EventData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2835150155243202235L;

	private List<String> filenames = null;
	
	private String folder = null;
	
	private Integer items = null;
	
	private Integer version = null;

	/**
	 * @return the filenames
	 */
	public List<String> getFilenames() {
		return filenames;
	}

	/**
	 * @param filenames the filenames to set
	 */
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
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
	 * @return the items
	 */
	public Integer getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Integer items) {
		this.items = items;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocalIndexUpdatedEventData [filenames=").append(filenames).append(", folder=").append(folder).append(", items=").append(items).append(", version=")
				.append(version).append("]");
		return builder.toString();
	}
	
	
}
