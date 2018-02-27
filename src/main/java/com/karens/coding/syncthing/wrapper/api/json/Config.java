package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.event.type.data.EventData;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Config implements Serializable, EventData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7419493307395572093L;

	/** Logger */
	private static final Logger logger = LogManager.getLogger(Config.class);
	
	
	private Integer version;
	
	private List<Folder> folders = new ArrayList<Folder>();
	
	private List<Device> devices = new ArrayList<Device>();
	
	private Gui gui = null;
	
	private Options options = null;
	
	private List<String> ignoredDevices = null;
	
	private List<String> ignoredFolders = null;

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

	/**
	 * @return the folders
	 */
	public List<Folder> getFolders() {
		return folders;
	}

	/**
	 * @param folders the folders to set
	 */
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}
	
	/**
	 * 
	 * @param folder
	 */
	public void addFolder(Folder folder) {
		this.folders.add(folder);
	}
	
	/**
	 * 
	 * @param folder
	 */
	public void addFolderIfNotExists(Folder folder) {
		if ( !hasFolder(folder.getId()) ){
			this.folders.add(folder);
		}
	}
	
	/**
	 * 
	 * @param folderId
	 * @return
	 */
	public Boolean hasFolder(String folderId) {
		Boolean folderExists = false;
		for (Folder currentFolder : this.folders) {
			if (currentFolder.getId().equals(folderId)) {
				folderExists = true;
				break;
			}
		}
		//logger.debug("searching for folderId :" + folderId + " exists " + folderExists);
		return folderExists;
	}
	
	public Folder getFolderById(String folderId) {
		Folder folder = null;
		for (Folder currentFolder : this.folders) {
			if (currentFolder.getId().equals(folderId)) {
				folder = currentFolder;
				break;
			}
		}
		return folder;
	}
	
	
	/**
	 * 
	 * @param folder
	 */
	public void removeFolder(Folder folder) {
		this.folders.remove(folder);
		
	}
	
	/**
	 * 
	 * @param folder
	 */
	public void removeFolderIfExists(Folder folder) {
		if ( hasFolder(folder.getId()) ){
			this.folders.remove(folder);
		}
	}
	
	/**
	 * 
	 * @param folderId
	 */
	public void removeFolderIfExists(String folderId) {
		//logger.debug("Remove folder " + folderId);
		Folder folderToDelete = null;
		for (Folder currentFolder : this.folders) {
			if (currentFolder.getId().equals(folderId)) {
				folderToDelete = currentFolder;
				break;
			}
		}
		if (folderToDelete != null) {
			this.folders.remove(folderToDelete);
			//logger.debug("Removed folder " + folderId);
		}
	}
	
	


	/**
	 * @return the devices
	 */
	public List<Device> getDevices() {
		return devices;
	}
	
	public Device getDeviceByDeviceId(String deviceId) {
		Device device = null;
		for (Device currentDevice : this.devices) {
			if (currentDevice.getDeviceID().equals(deviceId)) {
				device = currentDevice;
				break;
			}
		}
		return device;
	}


	/**
	 * @param devices the devices to set
	 */
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	/**
	 * 
	 * @param device
	 */
	public void addDevice(Device device) {
		this.devices.add(device);
	}
	
	/**
	 * 
	 * @param device
	 */
	public void addDeviceIfNotExists(Device device) {
		if ( !hasDevice(device.getDeviceID()) ){
			this.devices.add(device);
		}
	}
	
	/**
	 * 
	 * @param deviceID
	 * @return
	 */
	private boolean hasDevice(String deviceID) {
		Boolean deviceExists = false;
		for (Device currentDevice : this.devices) {
			if (currentDevice.getDeviceID().equals(deviceID)) {
				deviceExists = true;
				break;
			}
		}
		return deviceExists;
	}

	/**
	 * 
	 * @param device
	 */
	public void removeDevice(Device device) {
		this.devices.remove(device);
	}

	/**
	 * 
	 * @param deviceId
	 */
	public void removeDeviceIfExists(String deviceId) {
		Device deviceToBeRemoved = null;
		for (Device currentDevice : this.devices) {
			if (currentDevice.getDeviceID().equals(deviceId)) {
				deviceToBeRemoved = currentDevice;
				break;
			}
		}
		if (deviceToBeRemoved != null) {
			this.devices.remove(deviceToBeRemoved);
			logger.debug("Removed device " + deviceId);
		}
	}
	
	
	public Boolean addDeviceToFolder(String deviceId, String folderId) {
		Boolean result = false;
		if (deviceId != null && folderId != null) {
			Device device = getDeviceByDeviceId(deviceId);
			Folder folder = getFolderById(folderId);
			if (device != null && folder != null) {
				result = addDeviceToFolder(device, folder);
			}
		}
		return result;
	}
	
	public Boolean removeDeviceFromFolder(String deviceId, String folderId) {
		Boolean result = false;
		if (deviceId != null && folderId != null) {
			Folder folder = getFolderById(folderId);
			if (folder != null) {
				folder.removeDeviceIfExists(deviceId);
			}
		}
		return result;
	}
	
	public Boolean addDeviceToFolder(Device device, Folder folder) {
		Boolean result = false;
		if (device != null && folder != null) {
			folder.addDevice(device);
		}
		return result;
	}
	
	/**
	 * @return the gui
	 */
	public Gui getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(Gui gui) {
		this.gui = gui;
	}

	/**
	 * @return the options
	 */
	public Options getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

	/**
	 * @return the ignoredDevices
	 */
	public List<String> getIgnoredDevices() {
		return ignoredDevices;
	}

	/**
	 * @param ignoredDevices the ignoredDevices to set
	 */
	public void setIgnoredDevices(List<String> ignoredDevices) {
		this.ignoredDevices = ignoredDevices;
	}

	/**
	 * @return the ignoredFolders
	 */
	public List<String> getIgnoredFolders() {
		return ignoredFolders;
	}

	/**
	 * @param ignoredFolders the ignoredFolders to set
	 */
	public void setIgnoredFolders(List<String> ignoredFolders) {
		this.ignoredFolders = ignoredFolders;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConfig [version=").append(version).append(", folders=").append(folders).append(", devices=").append(devices).append(", gui=").append(gui)
				.append(", options=").append(options).append(", ignoredDevices=").append(ignoredDevices).append(", ignoredFolders=").append(ignoredFolders).append("]");
		return builder.toString();
	}

	
}
