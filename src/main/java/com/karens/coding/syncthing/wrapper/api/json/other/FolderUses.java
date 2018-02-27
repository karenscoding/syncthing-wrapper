package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderUses implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7384047950536496049L;

	private Integer autoNormalize = null;
	
    private Integer externalVersioning = null;
    
    private Integer ignoreDelete = null;
    
    private Integer ignorePerms = null;
    
    private Integer readonly = null;
    
    private Integer simpleVersioning = null;
    
    private Integer staggeredVersioning = null;
    
    private Integer trashcanVersioning = null;

	/**
	 * @return the autoNormalize
	 */
	public Integer getAutoNormalize() {
		return autoNormalize;
	}

	/**
	 * @param autoNormalize the autoNormalize to set
	 */
	public void setAutoNormalize(Integer autoNormalize) {
		this.autoNormalize = autoNormalize;
	}

	/**
	 * @return the externalVersioning
	 */
	public Integer getExternalVersioning() {
		return externalVersioning;
	}

	/**
	 * @param externalVersioning the externalVersioning to set
	 */
	public void setExternalVersioning(Integer externalVersioning) {
		this.externalVersioning = externalVersioning;
	}

	/**
	 * @return the ignoreDelete
	 */
	public Integer getIgnoreDelete() {
		return ignoreDelete;
	}

	/**
	 * @param ignoreDelete the ignoreDelete to set
	 */
	public void setIgnoreDelete(Integer ignoreDelete) {
		this.ignoreDelete = ignoreDelete;
	}

	/**
	 * @return the ignorePerms
	 */
	public Integer getIgnorePerms() {
		return ignorePerms;
	}

	/**
	 * @param ignorePerms the ignorePerms to set
	 */
	public void setIgnorePerms(Integer ignorePerms) {
		this.ignorePerms = ignorePerms;
	}

	/**
	 * @return the readonly
	 */
	public Integer getReadonly() {
		return readonly;
	}

	/**
	 * @param readonly the readonly to set
	 */
	public void setReadonly(Integer readonly) {
		this.readonly = readonly;
	}

	/**
	 * @return the simpleVersioning
	 */
	public Integer getSimpleVersioning() {
		return simpleVersioning;
	}

	/**
	 * @param simpleVersioning the simpleVersioning to set
	 */
	public void setSimpleVersioning(Integer simpleVersioning) {
		this.simpleVersioning = simpleVersioning;
	}

	/**
	 * @return the staggeredVersioning
	 */
	public Integer getStaggeredVersioning() {
		return staggeredVersioning;
	}

	/**
	 * @param staggeredVersioning the staggeredVersioning to set
	 */
	public void setStaggeredVersioning(Integer staggeredVersioning) {
		this.staggeredVersioning = staggeredVersioning;
	}

	/**
	 * @return the trashcanVersioning
	 */
	public Integer getTrashcanVersioning() {
		return trashcanVersioning;
	}

	/**
	 * @param trashcanVersioning the trashcanVersioning to set
	 */
	public void setTrashcanVersioning(Integer trashcanVersioning) {
		this.trashcanVersioning = trashcanVersioning;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolderUses [autoNormalize=").append(autoNormalize).append(", externalVersioning=").append(externalVersioning).append(", ignoreDelete=").append(ignoreDelete)
				.append(", ignorePerms=").append(ignorePerms).append(", readonly=").append(readonly).append(", simpleVersioning=").append(simpleVersioning)
				.append(", staggeredVersioning=").append(staggeredVersioning).append(", trashcanVersioning=").append(trashcanVersioning).append("]");
		return builder.toString();
	}
    
    
}
