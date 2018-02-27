package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 892622113322689734L;

	private Long globalBytes = null;
	
	private Integer globalDeleted = null;
	
	private Integer globalDirectories = null;
	
	private Integer globalFiles = null;
	
	private Integer globalSymlinks = null;
	
	private Boolean ignorePatterns = null;
	
    private Long inSyncBytes = null;
    
    private Integer inSyncFiles = null;
    
    private String invalid = null;
    
    private Long localBytes = null;
    
    private Integer localDeleted = null;
    
    private Integer localDirectories = null;
    
    private Integer localFiles = null;
    
    private Integer localSymlinks = null;
    
    private Long needBytes = null;
    
    private Integer needDeletes = null;
    
    private Integer needDirectories = null;
    
    private Integer needFiles = null;
    
    private Integer needSymlinks = null;
    
    private Integer sequence = null;
    
    private String state = null;
    
    private String stateChanged = null;
    
    private Integer version = null;

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
	 * @return the globalDeleted
	 */
	public Integer getGlobalDeleted() {
		return globalDeleted;
	}

	/**
	 * @param globalDeleted the globalDeleted to set
	 */
	public void setGlobalDeleted(Integer globalDeleted) {
		this.globalDeleted = globalDeleted;
	}

	/**
	 * @return the globalDirectories
	 */
	public Integer getGlobalDirectories() {
		return globalDirectories;
	}

	/**
	 * @param globalDirectories the globalDirectories to set
	 */
	public void setGlobalDirectories(Integer globalDirectories) {
		this.globalDirectories = globalDirectories;
	}

	/**
	 * @return the globalFiles
	 */
	public Integer getGlobalFiles() {
		return globalFiles;
	}

	/**
	 * @param globalFiles the globalFiles to set
	 */
	public void setGlobalFiles(Integer globalFiles) {
		this.globalFiles = globalFiles;
	}

	/**
	 * @return the globalSymlinks
	 */
	public Integer getGlobalSymlinks() {
		return globalSymlinks;
	}

	/**
	 * @param globalSymlinks the globalSymlinks to set
	 */
	public void setGlobalSymlinks(Integer globalSymlinks) {
		this.globalSymlinks = globalSymlinks;
	}

	/**
	 * @return the ignorePatterns
	 */
	public Boolean getIgnorePatterns() {
		return ignorePatterns;
	}

	/**
	 * @param ignorePatterns the ignorePatterns to set
	 */
	public void setIgnorePatterns(Boolean ignorePatterns) {
		this.ignorePatterns = ignorePatterns;
	}

	/**
	 * @return the inSyncBytes
	 */
	public Long getInSyncBytes() {
		return inSyncBytes;
	}

	/**
	 * @param inSyncBytes the inSyncBytes to set
	 */
	public void setInSyncBytes(Long inSyncBytes) {
		this.inSyncBytes = inSyncBytes;
	}

	/**
	 * @return the inSyncFiles
	 */
	public Integer getInSyncFiles() {
		return inSyncFiles;
	}

	/**
	 * @param inSyncFiles the inSyncFiles to set
	 */
	public void setInSyncFiles(Integer inSyncFiles) {
		this.inSyncFiles = inSyncFiles;
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
	 * @return the localBytes
	 */
	public Long getLocalBytes() {
		return localBytes;
	}

	/**
	 * @param localBytes the localBytes to set
	 */
	public void setLocalBytes(Long localBytes) {
		this.localBytes = localBytes;
	}

	/**
	 * @return the localDeleted
	 */
	public Integer getLocalDeleted() {
		return localDeleted;
	}

	/**
	 * @param localDeleted the localDeleted to set
	 */
	public void setLocalDeleted(Integer localDeleted) {
		this.localDeleted = localDeleted;
	}

	/**
	 * @return the localDirectories
	 */
	public Integer getLocalDirectories() {
		return localDirectories;
	}

	/**
	 * @param localDirectories the localDirectories to set
	 */
	public void setLocalDirectories(Integer localDirectories) {
		this.localDirectories = localDirectories;
	}

	/**
	 * @return the localFiles
	 */
	public Integer getLocalFiles() {
		return localFiles;
	}

	/**
	 * @param localFiles the localFiles to set
	 */
	public void setLocalFiles(Integer localFiles) {
		this.localFiles = localFiles;
	}

	/**
	 * @return the localSymlinks
	 */
	public Integer getLocalSymlinks() {
		return localSymlinks;
	}

	/**
	 * @param localSymlinks the localSymlinks to set
	 */
	public void setLocalSymlinks(Integer localSymlinks) {
		this.localSymlinks = localSymlinks;
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
	public Integer getNeedDeletes() {
		return needDeletes;
	}

	/**
	 * @param needDeletes the needDeletes to set
	 */
	public void setNeedDeletes(Integer needDeletes) {
		this.needDeletes = needDeletes;
	}

	/**
	 * @return the needDirectories
	 */
	public Integer getNeedDirectories() {
		return needDirectories;
	}

	/**
	 * @param needDirectories the needDirectories to set
	 */
	public void setNeedDirectories(Integer needDirectories) {
		this.needDirectories = needDirectories;
	}

	/**
	 * @return the needFiles
	 */
	public Integer getNeedFiles() {
		return needFiles;
	}

	/**
	 * @param needFiles the needFiles to set
	 */
	public void setNeedFiles(Integer needFiles) {
		this.needFiles = needFiles;
	}

	/**
	 * @return the needSymlinks
	 */
	public Integer getNeedSymlinks() {
		return needSymlinks;
	}

	/**
	 * @param needSymlinks the needSymlinks to set
	 */
	public void setNeedSymlinks(Integer needSymlinks) {
		this.needSymlinks = needSymlinks;
	}

	/**
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the stateChanged
	 */
	public String getStateChanged() {
		return stateChanged;
	}

	/**
	 * @param stateChanged the stateChanged to set
	 */
	public void setStateChanged(String stateChanged) {
		this.stateChanged = stateChanged;
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
		builder.append("FolderStatus [globalBytes=").append(globalBytes).append(", globalDeleted=").append(globalDeleted).append(", globalDirectories=").append(globalDirectories)
				.append(", globalFiles=").append(globalFiles).append(", globalSymlinks=").append(globalSymlinks).append(", ignorePatterns=").append(ignorePatterns)
				.append(", inSyncBytes=").append(inSyncBytes).append(", inSyncFiles=").append(inSyncFiles).append(", invalid=").append(invalid).append(", localBytes=")
				.append(localBytes).append(", localDeleted=").append(localDeleted).append(", localDirectories=").append(localDirectories).append(", localFiles=").append(localFiles)
				.append(", localSymlinks=").append(localSymlinks).append(", needBytes=").append(needBytes).append(", needDeletes=").append(needDeletes).append(", needDirectories=")
				.append(needDirectories).append(", needFiles=").append(needFiles).append(", needSymlinks=").append(needSymlinks).append(", sequence=").append(sequence)
				.append(", state=").append(state).append(", stateChanged=").append(stateChanged).append(", version=").append(version).append("]");
		return builder.toString();
	}
    
    
}
