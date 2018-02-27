package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Theme implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8816805405158716313L;
	
	@JsonProperty("default")
	private Integer defaultTheme = null;

	/**
	 * @return the defaultTheme
	 */
	@JsonProperty("default")
	public Integer getDefaultTheme() {
		return defaultTheme;
	}

	/**
	 * @param defaultTheme the defaultTheme to set
	 */
	@JsonProperty("default")
	public void setDefaultTheme(Integer defaultTheme) {
		this.defaultTheme = defaultTheme;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theme [defaultTheme=").append(defaultTheme).append("]");
		return builder.toString();
	}
	
	
}
