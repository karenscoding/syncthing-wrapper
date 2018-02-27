package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gui implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -59838431345205440L;

	private Boolean enabled = null;
	
	private String address = null;
	
	private String user = null;
	
	private String password = null;
	
	private Boolean useTLS = null;
	
	private String apiKey = null;
	
	private Boolean insecureAdminAccess = null;
	
	private String theme = null;
	
	private Boolean debugging = null;
	
	private Boolean insecureSkipHostcheck = null;
	
	private Boolean insecureAllowFrameLoading = null;

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the useTLS
	 */
	public Boolean getUseTLS() {
		return useTLS;
	}

	/**
	 * @param useTLS the useTLS to set
	 */
	public void setUseTLS(Boolean useTLS) {
		this.useTLS = useTLS;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the insecureAdminAccess
	 */
	public Boolean getInsecureAdminAccess() {
		return insecureAdminAccess;
	}

	/**
	 * @param insecureAdminAccess the insecureAdminAccess to set
	 */
	public void setInsecureAdminAccess(Boolean insecureAdminAccess) {
		this.insecureAdminAccess = insecureAdminAccess;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the debugging
	 */
	public Boolean getDebugging() {
		return debugging;
	}

	/**
	 * @param debugging the debugging to set
	 */
	public void setDebugging(Boolean debugging) {
		this.debugging = debugging;
	}

	/**
	 * @return the insecureSkipHostcheck
	 */
	public Boolean getInsecureSkipHostcheck() {
		return insecureSkipHostcheck;
	}

	/**
	 * @param insecureSkipHostcheck the insecureSkipHostcheck to set
	 */
	public void setInsecureSkipHostcheck(Boolean insecureSkipHostcheck) {
		this.insecureSkipHostcheck = insecureSkipHostcheck;
	}

	/**
	 * @return the insecureAllowFrameLoading
	 */
	public Boolean getInsecureAllowFrameLoading() {
		return insecureAllowFrameLoading;
	}

	/**
	 * @param insecureAllowFrameLoading the insecureAllowFrameLoading to set
	 */
	public void setInsecureAllowFrameLoading(Boolean insecureAllowFrameLoading) {
		this.insecureAllowFrameLoading = insecureAllowFrameLoading;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gui [enabled=").append(enabled).append(", address=").append(address).append(", user=").append(user).append(", password=").append(password)
				.append(", useTLS=").append(useTLS).append(", apiKey=").append(apiKey).append(", insecureAdminAccess=").append(insecureAdminAccess).append(", theme=").append(theme)
				.append(", debugging=").append(debugging).append(", insecureSkipHostcheck=").append(insecureSkipHostcheck).append(", insecureAllowFrameLoading=")
				.append(insecureAllowFrameLoading).append("]");
		return builder.toString();
	}

	
}
