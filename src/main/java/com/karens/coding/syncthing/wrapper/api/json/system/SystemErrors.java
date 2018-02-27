package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemErrors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5095035688296518521L;
	
	private List<SystemError> errors = null;

	/**
	 * @return the errors
	 */
	public List<SystemError> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<SystemError> errors) {
		this.errors = errors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemErrors [errors=").append(errors).append("]");
		return builder.toString();
	}

	
}
