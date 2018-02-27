package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuiStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229350012335616155L;

	private Integer debugging = null;
	
    private Integer enabled = null;
    
    private Integer insecureAdminAccess = null;
    
    private Integer insecureAllowFrameLoading = null;
    
    private Integer insecureSkipHostCheck = null;
    
    private Integer listenLocal = null;
    
    private Integer listenUnspecified = null;
    
    private Theme theme = null;
    
    private Integer useAuth = null;
    
    private Integer useTLS = null;

	/**
	 * @return the debugging
	 */
	public Integer getDebugging() {
		return debugging;
	}

	/**
	 * @param debugging the debugging to set
	 */
	public void setDebugging(Integer debugging) {
		this.debugging = debugging;
	}

	/**
	 * @return the enabled
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the insecureAdminAccess
	 */
	public Integer getInsecureAdminAccess() {
		return insecureAdminAccess;
	}

	/**
	 * @param insecureAdminAccess the insecureAdminAccess to set
	 */
	public void setInsecureAdminAccess(Integer insecureAdminAccess) {
		this.insecureAdminAccess = insecureAdminAccess;
	}

	/**
	 * @return the insecureAllowFrameLoading
	 */
	public Integer getInsecureAllowFrameLoading() {
		return insecureAllowFrameLoading;
	}

	/**
	 * @param insecureAllowFrameLoading the insecureAllowFrameLoading to set
	 */
	public void setInsecureAllowFrameLoading(Integer insecureAllowFrameLoading) {
		this.insecureAllowFrameLoading = insecureAllowFrameLoading;
	}

	/**
	 * @return the insecureSkipHostCheck
	 */
	public Integer getInsecureSkipHostCheck() {
		return insecureSkipHostCheck;
	}

	/**
	 * @param insecureSkipHostCheck the insecureSkipHostCheck to set
	 */
	public void setInsecureSkipHostCheck(Integer insecureSkipHostCheck) {
		this.insecureSkipHostCheck = insecureSkipHostCheck;
	}

	/**
	 * @return the listenLocal
	 */
	public Integer getListenLocal() {
		return listenLocal;
	}

	/**
	 * @param listenLocal the listenLocal to set
	 */
	public void setListenLocal(Integer listenLocal) {
		this.listenLocal = listenLocal;
	}

	/**
	 * @return the listenUnspecified
	 */
	public Integer getListenUnspecified() {
		return listenUnspecified;
	}

	/**
	 * @param listenUnspecified the listenUnspecified to set
	 */
	public void setListenUnspecified(Integer listenUnspecified) {
		this.listenUnspecified = listenUnspecified;
	}

	/**
	 * @return the theme
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	/**
	 * @return the useAuth
	 */
	public Integer getUseAuth() {
		return useAuth;
	}

	/**
	 * @param useAuth the useAuth to set
	 */
	public void setUseAuth(Integer useAuth) {
		this.useAuth = useAuth;
	}

	/**
	 * @return the useTLS
	 */
	public Integer getUseTLS() {
		return useTLS;
	}

	/**
	 * @param useTLS the useTLS to set
	 */
	public void setUseTLS(Integer useTLS) {
		this.useTLS = useTLS;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuiStats [debugging=").append(debugging).append(", enabled=").append(enabled).append(", insecureAdminAccess=").append(insecureAdminAccess)
				.append(", insecureAllowFrameLoading=").append(insecureAllowFrameLoading).append(", insecureSkipHostCheck=").append(insecureSkipHostCheck).append(", listenLocal=")
				.append(listenLocal).append(", listenUnspecified=").append(listenUnspecified).append(", theme=").append(theme).append(", useAuth=").append(useAuth)
				.append(", useTLS=").append(useTLS).append("]");
		return builder.toString();
	}

	
    
}
