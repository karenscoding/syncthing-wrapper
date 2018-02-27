package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3080526372761977928L;

	/** Logger */
	private static final Logger logger = LogManager.getLogger(Folder.class);
	

	private String id = null;
	
    private String label = null;
    
    private String filesystemType = null;
    
    private String path = null;
    
    private String type = null;
    
    private List<Device> devices = null;
    
    private Integer rescanIntervalS = null;
    
    private Boolean fsWatcherEnabled =  null;
    
    private Integer fsWatcherDelayS = null;
    
    private Boolean ignorePerms = null;
    
    private Boolean autoNormalize = null;
    
    private Integer minDiskFreePct = null;
    
    private DiskFree minDiskFree = null;
    
    private Versioning versioning = null;
    
    private Integer copiers = null;
    
    private Integer pullers = null;
    
    private Integer hashers = null;
    
    private String order = null;
    
    private Boolean ignoreDelete = null;
    
    private Integer scanProgressIntervalS = null;
    
    private Integer pullerSleepS = null;
    
    private Integer pullerPauseS = null;
    
    private Integer maxConflicts = null;
    
    private Boolean disableSparseFiles = null;
    
    private Boolean disableTempIndexes = null;
    
    private Boolean paused = null;
    
    private Integer weakHashThresholdPct = null;
    
    private Boolean fsync = null;
    
    private String invalid = null;
    
    private String markerName = null;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the filesystemType
	 */
	public String getFilesystemType() {
		return filesystemType;
	}

	/**
	 * @param filesystemType the filesystemType to set
	 */
	public void setFilesystemType(String filesystemType) {
		this.filesystemType = filesystemType;
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

	/**
	 * @return the devices
	 */
	public List<Device> getDevices() {
		return devices;
	}

	/**
	 * @param devices the devices to set
	 */
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}

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
	
	/**
	 * @return the fsWatcherEnabled
	 */
	public Boolean getFsWatcherEnabled() {
		return fsWatcherEnabled;
	}

	/**
	 * @param fsWatcherEnabled the fsWatcherEnabled to set
	 */
	public void setFsWatcherEnabled(Boolean fsWatcherEnabled) {
		this.fsWatcherEnabled = fsWatcherEnabled;
	}

	/**
	 * @return the fsWatcherDelayS
	 */
	public Integer getFsWatcherDelayS() {
		return fsWatcherDelayS;
	}

	/**
	 * @param fsWatcherDelayS the fsWatcherDelayS to set
	 */
	public void setFsWatcherDelayS(Integer fsWatcherDelayS) {
		this.fsWatcherDelayS = fsWatcherDelayS;
	}

	/**
	 * @return the rescanIntervalS
	 */
	public Integer getRescanIntervalS() {
		return rescanIntervalS;
	}

	/**
	 * @param rescanIntervalS the rescanIntervalS to set
	 */
	public void setRescanIntervalS(Integer rescanIntervalS) {
		this.rescanIntervalS = rescanIntervalS;
	}

	/**
	 * @return the ignorePerms
	 */
	public Boolean getIgnorePerms() {
		return ignorePerms;
	}

	/**
	 * @param ignorePerms the ignorePerms to set
	 */
	public void setIgnorePerms(Boolean ignorePerms) {
		this.ignorePerms = ignorePerms;
	}

	/**
	 * @return the autoNormalize
	 */
	public Boolean getAutoNormalize() {
		return autoNormalize;
	}

	/**
	 * @param autoNormalize the autoNormalize to set
	 */
	public void setAutoNormalize(Boolean autoNormalize) {
		this.autoNormalize = autoNormalize;
	}

	/**
	 * @return the minDiskFreePct
	 */
	public Integer getMinDiskFreePct() {
		return minDiskFreePct;
	}

	/**
	 * @param minDiskFreePct the minDiskFreePct to set
	 */
	public void setMinDiskFreePct(Integer minDiskFreePct) {
		this.minDiskFreePct = minDiskFreePct;
	}

	/**
	 * @return the minDiskFree
	 */
	public DiskFree getMinDiskFree() {
		return minDiskFree;
	}

	/**
	 * @param minDiskFree the minDiskFree to set
	 */
	public void setMinDiskFree(DiskFree minDiskFree) {
		this.minDiskFree = minDiskFree;
	}

	/**
	 * @return the versioning
	 */
	public Versioning getVersioning() {
		return versioning;
	}

	/**
	 * @param versioning the versioning to set
	 */
	public void setVersioning(Versioning versioning) {
		this.versioning = versioning;
	}

	/**
	 * @return the copiers
	 */
	public Integer getCopiers() {
		return copiers;
	}

	/**
	 * @param copiers the copiers to set
	 */
	public void setCopiers(Integer copiers) {
		this.copiers = copiers;
	}

	/**
	 * @return the pullers
	 */
	public Integer getPullers() {
		return pullers;
	}

	/**
	 * @param pullers the pullers to set
	 */
	public void setPullers(Integer pullers) {
		this.pullers = pullers;
	}

	/**
	 * @return the hashers
	 */
	public Integer getHashers() {
		return hashers;
	}

	/**
	 * @param hashers the hashers to set
	 */
	public void setHashers(Integer hashers) {
		this.hashers = hashers;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the ignoreDelete
	 */
	public Boolean getIgnoreDelete() {
		return ignoreDelete;
	}

	/**
	 * @param ignoreDelete the ignoreDelete to set
	 */
	public void setIgnoreDelete(Boolean ignoreDelete) {
		this.ignoreDelete = ignoreDelete;
	}

	/**
	 * @return the scanProgressIntervalS
	 */
	public Integer getScanProgressIntervalS() {
		return scanProgressIntervalS;
	}

	/**
	 * @param scanProgressIntervalS the scanProgressIntervalS to set
	 */
	public void setScanProgressIntervalS(Integer scanProgressIntervalS) {
		this.scanProgressIntervalS = scanProgressIntervalS;
	}

	/**
	 * @return the pullerSleepS
	 */
	public Integer getPullerSleepS() {
		return pullerSleepS;
	}

	/**
	 * @param pullerSleepS the pullerSleepS to set
	 */
	public void setPullerSleepS(Integer pullerSleepS) {
		this.pullerSleepS = pullerSleepS;
	}

	/**
	 * @return the pullerPauseS
	 */
	public Integer getPullerPauseS() {
		return pullerPauseS;
	}

	/**
	 * @param pullerPauseS the pullerPauseS to set
	 */
	public void setPullerPauseS(Integer pullerPauseS) {
		this.pullerPauseS = pullerPauseS;
	}

	/**
	 * @return the maxConflicts
	 */
	public Integer getMaxConflicts() {
		return maxConflicts;
	}

	/**
	 * @param maxConflicts the maxConflicts to set
	 */
	public void setMaxConflicts(Integer maxConflicts) {
		this.maxConflicts = maxConflicts;
	}

	/**
	 * @return the disableSparseFiles
	 */
	public Boolean getDisableSparseFiles() {
		return disableSparseFiles;
	}

	/**
	 * @param disableSparseFiles the disableSparseFiles to set
	 */
	public void setDisableSparseFiles(Boolean disableSparseFiles) {
		this.disableSparseFiles = disableSparseFiles;
	}

	/**
	 * @return the disableTempIndexes
	 */
	public Boolean getDisableTempIndexes() {
		return disableTempIndexes;
	}

	/**
	 * @param disableTempIndexes the disableTempIndexes to set
	 */
	public void setDisableTempIndexes(Boolean disableTempIndexes) {
		this.disableTempIndexes = disableTempIndexes;
	}

	/**
	 * @return the paused
	 */
	public Boolean getPaused() {
		return paused;
	}

	/**
	 * @param paused the paused to set
	 */
	public void setPaused(Boolean paused) {
		this.paused = paused;
	}

	/**
	 * @return the weakHashThresholdPct
	 */
	public Integer getWeakHashThresholdPct() {
		return weakHashThresholdPct;
	}

	/**
	 * @param weakHashThresholdPct the weakHashThresholdPct to set
	 */
	public void setWeakHashThresholdPct(Integer weakHashThresholdPct) {
		this.weakHashThresholdPct = weakHashThresholdPct;
	}

	/**
	 * @return the fsync
	 */
	public Boolean getFsync() {
		return fsync;
	}

	/**
	 * @param fsync the fsync to set
	 */
	public void setFsync(Boolean fsync) {
		this.fsync = fsync;
	}

	/**
	 * @return the invalid
	 */
	public String getInvalid() {
		return invalid;
	}

	/**
	 * @param invalid the invalid to set
	 */
	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	/**
	 * @return the markerName
	 */
	public String getMarkerName() {
		return markerName;
	}

	/**
	 * @param markerName the markerName to set
	 */
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Folder [id=").append(id).append(", label=").append(label).append(", filesystemType=").append(filesystemType).append(", path=").append(path)
				.append(", type=").append(type).append(", devices=").append(devices).append(", fsWatcherEnabled=").append(fsWatcherEnabled).append(", fsWatcherDelayS=")
				.append(fsWatcherDelayS).append(", rescanIntervalS=").append(rescanIntervalS).append(", ignorePerms=").append(ignorePerms).append(", autoNormalize=")
				.append(autoNormalize).append(", minDiskFreePct=").append(minDiskFreePct).append(", minDiskFree=").append(minDiskFree).append(", versioning=").append(versioning)
				.append(", copiers=").append(copiers).append(", pullers=").append(pullers).append(", hashers=").append(hashers).append(", order=").append(order)
				.append(", ignoreDelete=").append(ignoreDelete).append(", scanProgressIntervalS=").append(scanProgressIntervalS).append(", pullerSleepS=").append(pullerSleepS)
				.append(", pullerPauseS=").append(pullerPauseS).append(", maxConflicts=").append(maxConflicts).append(", disableSparseFiles=").append(disableSparseFiles)
				.append(", disableTempIndexes=").append(disableTempIndexes).append(", paused=").append(paused).append(", weakHashThresholdPct=").append(weakHashThresholdPct)
				.append(", fsync=").append(fsync).append(", invalid=").append(invalid).append(", markerName=").append(markerName).append("]");
		return builder.toString();
	}

	
}
