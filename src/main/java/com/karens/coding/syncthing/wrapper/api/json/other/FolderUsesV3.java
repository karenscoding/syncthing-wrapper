package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderUsesV3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3393140975561085754L;

	private Integer alwaysWeakHash = null;
	
    private Integer conflictsDisabled = null;
    
    private Integer conflictsOther = null;
    
    private Integer conflictsUnlimited = null;
    
    private Integer customWeakHashThreshold = null;
    
    private Integer disableSparseFiles = null;
    
    private Integer disableTempIndexes = null;
    
    private FilesystemType filesystemType = null;
    
    private Integer[] fsWatcherDelays = null;
    
    private Integer fsWatcherEnabled = null;
    
    private PullOrder pullOrder = null;
    
    private Integer scanProgressDisabled = null;

	/**
	 * @return the alwaysWeakHash
	 */
	public Integer getAlwaysWeakHash() {
		return alwaysWeakHash;
	}

	/**
	 * @param alwaysWeakHash the alwaysWeakHash to set
	 */
	public void setAlwaysWeakHash(Integer alwaysWeakHash) {
		this.alwaysWeakHash = alwaysWeakHash;
	}

	/**
	 * @return the conflictsDisabled
	 */
	public Integer getConflictsDisabled() {
		return conflictsDisabled;
	}

	/**
	 * @param conflictsDisabled the conflictsDisabled to set
	 */
	public void setConflictsDisabled(Integer conflictsDisabled) {
		this.conflictsDisabled = conflictsDisabled;
	}

	/**
	 * @return the conflictsOther
	 */
	public Integer getConflictsOther() {
		return conflictsOther;
	}

	/**
	 * @param conflictsOther the conflictsOther to set
	 */
	public void setConflictsOther(Integer conflictsOther) {
		this.conflictsOther = conflictsOther;
	}

	/**
	 * @return the conflictsUnlimited
	 */
	public Integer getConflictsUnlimited() {
		return conflictsUnlimited;
	}

	/**
	 * @param conflictsUnlimited the conflictsUnlimited to set
	 */
	public void setConflictsUnlimited(Integer conflictsUnlimited) {
		this.conflictsUnlimited = conflictsUnlimited;
	}

	/**
	 * @return the customWeakHashThreshold
	 */
	public Integer getCustomWeakHashThreshold() {
		return customWeakHashThreshold;
	}

	/**
	 * @param customWeakHashThreshold the customWeakHashThreshold to set
	 */
	public void setCustomWeakHashThreshold(Integer customWeakHashThreshold) {
		this.customWeakHashThreshold = customWeakHashThreshold;
	}

	/**
	 * @return the disableSparseFiles
	 */
	public Integer getDisableSparseFiles() {
		return disableSparseFiles;
	}

	/**
	 * @param disableSparseFiles the disableSparseFiles to set
	 */
	public void setDisableSparseFiles(Integer disableSparseFiles) {
		this.disableSparseFiles = disableSparseFiles;
	}

	/**
	 * @return the disableTempIndexes
	 */
	public Integer getDisableTempIndexes() {
		return disableTempIndexes;
	}

	/**
	 * @param disableTempIndexes the disableTempIndexes to set
	 */
	public void setDisableTempIndexes(Integer disableTempIndexes) {
		this.disableTempIndexes = disableTempIndexes;
	}

	/**
	 * @return the filesystemType
	 */
	public FilesystemType getFilesystemType() {
		return filesystemType;
	}

	/**
	 * @param filesystemType the filesystemType to set
	 */
	public void setFilesystemType(FilesystemType filesystemType) {
		this.filesystemType = filesystemType;
	}

	/**
	 * @return the fsWatcherDelays
	 */
	public Integer[] getFsWatcherDelays() {
		return fsWatcherDelays;
	}

	/**
	 * @param fsWatcherDelays the fsWatcherDelays to set
	 */
	public void setFsWatcherDelays(Integer[] fsWatcherDelays) {
		this.fsWatcherDelays = fsWatcherDelays;
	}

	/**
	 * @return the fsWatcherEnabled
	 */
	public Integer getFsWatcherEnabled() {
		return fsWatcherEnabled;
	}

	/**
	 * @param fsWatcherEnabled the fsWatcherEnabled to set
	 */
	public void setFsWatcherEnabled(Integer fsWatcherEnabled) {
		this.fsWatcherEnabled = fsWatcherEnabled;
	}

	/**
	 * @return the pullOrder
	 */
	public PullOrder getPullOrder() {
		return pullOrder;
	}

	/**
	 * @param pullOrder the pullOrder to set
	 */
	public void setPullOrder(PullOrder pullOrder) {
		this.pullOrder = pullOrder;
	}

	/**
	 * @return the scanProgressDisabled
	 */
	public Integer getScanProgressDisabled() {
		return scanProgressDisabled;
	}

	/**
	 * @param scanProgressDisabled the scanProgressDisabled to set
	 */
	public void setScanProgressDisabled(Integer scanProgressDisabled) {
		this.scanProgressDisabled = scanProgressDisabled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderUsesV3 [alwaysWeakHash=").append(alwaysWeakHash).append(", conflictsDisabled=").append(conflictsDisabled).append(", conflictsOther=")
				.append(conflictsOther).append(", conflictsUnlimited=").append(conflictsUnlimited).append(", customWeakHashThreshold=").append(customWeakHashThreshold)
				.append(", disableSparseFiles=").append(disableSparseFiles).append(", disableTempIndexes=").append(disableTempIndexes).append(", filesystemType=")
				.append(filesystemType).append(", fsWatcherDelays=").append(Arrays.toString(fsWatcherDelays)).append(", fsWatcherEnabled=").append(fsWatcherEnabled)
				.append(", pullOrder=").append(pullOrder).append(", scanProgressDisabled=").append(scanProgressDisabled).append("]");
		return builder.toString();
	}
    
    
}
