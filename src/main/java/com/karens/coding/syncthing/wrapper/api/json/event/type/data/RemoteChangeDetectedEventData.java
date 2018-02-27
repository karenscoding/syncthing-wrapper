package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteChangeDetectedEventData implements Serializable, EventData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6651594947743143599L;

	private String action = null;
	
	private String folder = null;
	
	private String folderID = null;
	
	private String label = null;
	
	private String modifiedBy = null;
	
	private String path = null;
	
	private String type = null;

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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
	 * @return the folderID
	 */
	public String getFolderID() {
		return folderID;
	}

	/**
	 * @param folderID the folderID to set
	 */
	public void setFolderID(String folderID) {
		this.folderID = folderID;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RemoteChangeDetectedEventData [action=").append(action).append(", folder=").append(folder).append(", folderID=").append(folderID).append(", label=")
				.append(label).append(", modifiedBy=").append(modifiedBy).append(", path=").append(path).append(", type=").append(type).append("]");
		return builder.toString();
	}
	
	
}
