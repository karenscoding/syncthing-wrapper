package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2645905690700029884L;

	private Long alloc = null;
	
	private Map<String, SystemConnectionService> connectionServiceStatus = null;
	
	private Double cpuPercent = null;
	
	private Boolean discoveryEnabled = null;
	
	private Map<String,String> discoveryErrors = null;
	
	private Integer discoveryMethods = null;
	
	private Integer goroutines = null;
	
    private String myID = null;
    
    private String pathSeparator = null;
    
    private String startTime = null;
    
    private Integer sys = null;
    
    private String tilde = null;
    
    private Integer uptime = null;
    
    private Integer urVersionMax = null;

	/**
	 * @return the alloc
	 */
	public Long getAlloc() {
		return alloc;
	}

	/**
	 * @param alloc the alloc to set
	 */
	public void setAlloc(Long alloc) {
		this.alloc = alloc;
	}

	/**
	 * @return the connectionServiceStatus
	 */
	public Map<String, SystemConnectionService> getConnectionServiceStatus() {
		return connectionServiceStatus;
	}

	/**
	 * @param connectionServiceStatus the connectionServiceStatus to set
	 */
	public void setConnectionServiceStatus(Map<String, SystemConnectionService> connectionServiceStatus) {
		this.connectionServiceStatus = connectionServiceStatus;
	}

	/**
	 * @return the cpuPercent
	 */
	public Double getCpuPercent() {
		return cpuPercent;
	}

	/**
	 * @param cpuPercent the cpuPercent to set
	 */
	public void setCpuPercent(Double cpuPercent) {
		this.cpuPercent = cpuPercent;
	}

	/**
	 * @return the discoveryEnabled
	 */
	public Boolean getDiscoveryEnabled() {
		return discoveryEnabled;
	}

	/**
	 * @param discoveryEnabled the discoveryEnabled to set
	 */
	public void setDiscoveryEnabled(Boolean discoveryEnabled) {
		this.discoveryEnabled = discoveryEnabled;
	}

	/**
	 * @return the discoveryErrors
	 */
	public Map<String, String> getDiscoveryErrors() {
		return discoveryErrors;
	}

	/**
	 * @param discoveryErrors the discoveryErrors to set
	 */
	public void setDiscoveryErrors(Map<String, String> discoveryErrors) {
		this.discoveryErrors = discoveryErrors;
	}

	/**
	 * @return the discoveryMethods
	 */
	public Integer getDiscoveryMethods() {
		return discoveryMethods;
	}

	/**
	 * @param discoveryMethods the discoveryMethods to set
	 */
	public void setDiscoveryMethods(Integer discoveryMethods) {
		this.discoveryMethods = discoveryMethods;
	}

	/**
	 * @return the goroutines
	 */
	public Integer getGoroutines() {
		return goroutines;
	}

	/**
	 * @param goroutines the goroutines to set
	 */
	public void setGoroutines(Integer goroutines) {
		this.goroutines = goroutines;
	}

	/**
	 * @return the myID
	 */
	public String getMyID() {
		return myID;
	}

	/**
	 * @param myID the myID to set
	 */
	public void setMyID(String myID) {
		this.myID = myID;
	}

	/**
	 * @return the pathSeparator
	 */
	public String getPathSeparator() {
		return pathSeparator;
	}

	/**
	 * @param pathSeparator the pathSeparator to set
	 */
	public void setPathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the sys
	 */
	public Integer getSys() {
		return sys;
	}

	/**
	 * @param sys the sys to set
	 */
	public void setSys(Integer sys) {
		this.sys = sys;
	}

	/**
	 * @return the tilde
	 */
	public String getTilde() {
		return tilde;
	}

	/**
	 * @param tilde the tilde to set
	 */
	public void setTilde(String tilde) {
		this.tilde = tilde;
	}

	/**
	 * @return the uptime
	 */
	public Integer getUptime() {
		return uptime;
	}

	/**
	 * @param uptime the uptime to set
	 */
	public void setUptime(Integer uptime) {
		this.uptime = uptime;
	}

	/**
	 * @return the urVersionMax
	 */
	public Integer getUrVersionMax() {
		return urVersionMax;
	}

	/**
	 * @param urVersionMax the urVersionMax to set
	 */
	public void setUrVersionMax(Integer urVersionMax) {
		this.urVersionMax = urVersionMax;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemStatus [alloc=").append(alloc).append(", connectionServiceStatus=").append(connectionServiceStatus).append(", cpuPercent=").append(cpuPercent)
				.append(", discoveryEnabled=").append(discoveryEnabled).append(", discoveryErrors=").append(discoveryErrors).append(", discoveryMethods=").append(discoveryMethods)
				.append(", goroutines=").append(goroutines).append(", myID=").append(myID).append(", pathSeparator=").append(pathSeparator).append(", startTime=").append(startTime)
				.append(", sys=").append(sys).append(", tilde=").append(tilde).append(", uptime=").append(uptime).append(", urVersionMax=").append(urVersionMax).append("]");
		return builder.toString();
	}

	
}
