package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileProgress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6966207538991782372L;

	private Boolean deleted = null;
	
    private Boolean invalid = null;
    
    private String modified = null;
    
    private String name = null;
    
    private Boolean noPermissions = null;
    
    private Integer permissions = null;
    
    private Integer sequence = null;
    
    private Long size = null;
    
    private Integer type = null;

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the invalid
	 */
	public Boolean getInvalid() {
		return invalid;
	}

	/**
	 * @param invalid the invalid to set
	 */
	public void setInvalid(Boolean invalid) {
		this.invalid = invalid;
	}

	/**
	 * @return the modified
	 */
	public String getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(String modified) {
		this.modified = modified;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the noPermissions
	 */
	public Boolean getNoPermissions() {
		return noPermissions;
	}

	/**
	 * @param noPermissions the noPermissions to set
	 */
	public void setNoPermissions(Boolean noPermissions) {
		this.noPermissions = noPermissions;
	}

	/**
	 * @return the permissions
	 */
	public Integer getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Integer permissions) {
		this.permissions = permissions;
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
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileProgress [deleted=").append(deleted).append(", invalid=").append(invalid).append(", modified=").append(modified).append(", name=").append(name)
				.append(", noPermissions=").append(noPermissions).append(", permissions=").append(permissions).append(", sequence=").append(sequence).append(", size=").append(size)
				.append(", type=").append(type).append("]");
		return builder.toString();
	}

	
}
