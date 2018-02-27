package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6413245412769673003L;

	private List<String> listenAddresses = null;
		
	private List<String> globalAnnounceServers = null;
	
	private Boolean globalAnnounceEnabled = null;
	
	private Boolean localAnnounceEnabled = null;
	
	private Integer localAnnouncePort = null;
		
	private String localAnnounceMCAddr = null;
	
	private Integer maxSendKbps = null;
	
	private Integer maxRecvKbps = null;
	
	private Integer reconnectionIntervalS = null;
	
	private Boolean relaysEnabled = null;
	
	private Integer relayReconnectIntervalM = null;
	
	private Boolean startBrowser = null;
	
	private Boolean natEnabled = null;
	
	private Integer natLeaseMinutes = null;
	
	private Integer natRenewalMinutes = null;
	
	private Integer natTimeoutSeconds = null;
	
	private Integer urAccepted = null;
	
	private Integer urSeen = null;
	
	private String urUniqueId = null;
	
	private String urURL = null;
	
	private Boolean urPostInsecurely = null;
	
	private Integer urInitialDelayS = null;
	
	private Boolean restartOnWakeup = null;
	
	private Integer autoUpgradeIntervalH = null;
	
	private Boolean upgradeToPreReleases = null;
	
	private Integer keepTemporariesH = null;
	
    private Boolean cacheIgnoredFiles = null;
    
    private Integer progressUpdateIntervalS = null;
    
    private Boolean limitBandwidthInLan = null;
    
    private DiskFree minHomeDiskFree = null;
    
    private String releasesURL = null;
    
    private List<String> alwaysLocalNets = null;
    
    private Boolean overwriteRemoteDeviceNamesOnConnect = null;
    
    private Integer tempIndexMinBlocks = null;
    
    private List<String> unackedNotificationIDs = null;
    
    private Integer trafficClass = null;
    
    private String weakHashSelectionMethod = null;
    
    private List<String> stunServers = null;
    
    private Integer stunKeepaliveSeconds = null;
    
    private Boolean kcpNoDelay = null;
    
    private Integer kcpUpdateIntervalMs = null;
    
    private Boolean kcpFastResend = null;
    
    private Boolean kcpCongestionControl = null;
    
    private Integer kcpSendWindowSize = null;
    
    private Integer kcpReceiveWindowSize = null;
    
    private String defaultFolderPath = null;

	/**
	 * @return the listenAddresses
	 */
	public List<String> getListenAddresses() {
		return listenAddresses;
	}

	/**
	 * @param listenAddresses the listenAddresses to set
	 */
	public void setListenAddresses(List<String> listenAddresses) {
		this.listenAddresses = listenAddresses;
	}

	/**
	 * @return the globalAnnounceServers
	 */
	public List<String> getGlobalAnnounceServers() {
		return globalAnnounceServers;
	}

	/**
	 * @param globalAnnounceServers the globalAnnounceServers to set
	 */
	public void setGlobalAnnounceServers(List<String> globalAnnounceServers) {
		this.globalAnnounceServers = globalAnnounceServers;
	}

	/**
	 * @return the globalAnnounceEnabled
	 */
	public Boolean getGlobalAnnounceEnabled() {
		return globalAnnounceEnabled;
	}

	/**
	 * @param globalAnnounceEnabled the globalAnnounceEnabled to set
	 */
	public void setGlobalAnnounceEnabled(Boolean globalAnnounceEnabled) {
		this.globalAnnounceEnabled = globalAnnounceEnabled;
	}

	/**
	 * @return the localAnnounceEnabled
	 */
	public Boolean getLocalAnnounceEnabled() {
		return localAnnounceEnabled;
	}

	/**
	 * @param localAnnounceEnabled the localAnnounceEnabled to set
	 */
	public void setLocalAnnounceEnabled(Boolean localAnnounceEnabled) {
		this.localAnnounceEnabled = localAnnounceEnabled;
	}

	/**
	 * @return the localAnnouncePort
	 */
	public Integer getLocalAnnouncePort() {
		return localAnnouncePort;
	}

	/**
	 * @param localAnnouncePort the localAnnouncePort to set
	 */
	public void setLocalAnnouncePort(Integer localAnnouncePort) {
		this.localAnnouncePort = localAnnouncePort;
	}

	/**
	 * @return the localAnnounceMCAddr
	 */
	public String getLocalAnnounceMCAddr() {
		return localAnnounceMCAddr;
	}

	/**
	 * @param localAnnounceMCAddr the localAnnounceMCAddr to set
	 */
	public void setLocalAnnounceMCAddr(String localAnnounceMCAddr) {
		this.localAnnounceMCAddr = localAnnounceMCAddr;
	}

	/**
	 * @return the maxSendKbps
	 */
	public Integer getMaxSendKbps() {
		return maxSendKbps;
	}

	/**
	 * @param maxSendKbps the maxSendKbps to set
	 */
	public void setMaxSendKbps(Integer maxSendKbps) {
		this.maxSendKbps = maxSendKbps;
	}

	/**
	 * @return the maxRecvKbps
	 */
	public Integer getMaxRecvKbps() {
		return maxRecvKbps;
	}

	/**
	 * @param maxRecvKbps the maxRecvKbps to set
	 */
	public void setMaxRecvKbps(Integer maxRecvKbps) {
		this.maxRecvKbps = maxRecvKbps;
	}

	/**
	 * @return the reconnectionIntervalS
	 */
	public Integer getReconnectionIntervalS() {
		return reconnectionIntervalS;
	}

	/**
	 * @param reconnectionIntervalS the reconnectionIntervalS to set
	 */
	public void setReconnectionIntervalS(Integer reconnectionIntervalS) {
		this.reconnectionIntervalS = reconnectionIntervalS;
	}

	/**
	 * @return the relaysEnabled
	 */
	public Boolean getRelaysEnabled() {
		return relaysEnabled;
	}

	/**
	 * @param relaysEnabled the relaysEnabled to set
	 */
	public void setRelaysEnabled(Boolean relaysEnabled) {
		this.relaysEnabled = relaysEnabled;
	}

	/**
	 * @return the relayReconnectIntervalM
	 */
	public Integer getRelayReconnectIntervalM() {
		return relayReconnectIntervalM;
	}

	/**
	 * @param relayReconnectIntervalM the relayReconnectIntervalM to set
	 */
	public void setRelayReconnectIntervalM(Integer relayReconnectIntervalM) {
		this.relayReconnectIntervalM = relayReconnectIntervalM;
	}

	/**
	 * @return the startBrowser
	 */
	public Boolean getStartBrowser() {
		return startBrowser;
	}

	/**
	 * @param startBrowser the startBrowser to set
	 */
	public void setStartBrowser(Boolean startBrowser) {
		this.startBrowser = startBrowser;
	}

	/**
	 * @return the natEnabled
	 */
	public Boolean getNatEnabled() {
		return natEnabled;
	}

	/**
	 * @param natEnabled the natEnabled to set
	 */
	public void setNatEnabled(Boolean natEnabled) {
		this.natEnabled = natEnabled;
	}

	/**
	 * @return the natLeaseMinutes
	 */
	public Integer getNatLeaseMinutes() {
		return natLeaseMinutes;
	}

	/**
	 * @param natLeaseMinutes the natLeaseMinutes to set
	 */
	public void setNatLeaseMinutes(Integer natLeaseMinutes) {
		this.natLeaseMinutes = natLeaseMinutes;
	}

	/**
	 * @return the natRenewalMinutes
	 */
	public Integer getNatRenewalMinutes() {
		return natRenewalMinutes;
	}

	/**
	 * @param natRenewalMinutes the natRenewalMinutes to set
	 */
	public void setNatRenewalMinutes(Integer natRenewalMinutes) {
		this.natRenewalMinutes = natRenewalMinutes;
	}

	/**
	 * @return the natTimeoutSeconds
	 */
	public Integer getNatTimeoutSeconds() {
		return natTimeoutSeconds;
	}

	/**
	 * @param natTimeoutSeconds the natTimeoutSeconds to set
	 */
	public void setNatTimeoutSeconds(Integer natTimeoutSeconds) {
		this.natTimeoutSeconds = natTimeoutSeconds;
	}

	/**
	 * @return the urAccepted
	 */
	public Integer getUrAccepted() {
		return urAccepted;
	}

	/**
	 * @param urAccepted the urAccepted to set
	 */
	public void setUrAccepted(Integer urAccepted) {
		this.urAccepted = urAccepted;
	}

	/**
	 * @return the urSeen
	 */
	public Integer getUrSeen() {
		return urSeen;
	}

	/**
	 * @param urSeen the urSeen to set
	 */
	public void setUrSeen(Integer urSeen) {
		this.urSeen = urSeen;
	}

	/**
	 * @return the urUniqueId
	 */
	public String getUrUniqueId() {
		return urUniqueId;
	}

	/**
	 * @param urUniqueId the urUniqueId to set
	 */
	public void setUrUniqueId(String urUniqueId) {
		this.urUniqueId = urUniqueId;
	}

	/**
	 * @return the urURL
	 */
	public String getUrURL() {
		return urURL;
	}

	/**
	 * @param urURL the urURL to set
	 */
	public void setUrURL(String urURL) {
		this.urURL = urURL;
	}

	/**
	 * @return the urPostInsecurely
	 */
	public Boolean getUrPostInsecurely() {
		return urPostInsecurely;
	}

	/**
	 * @param urPostInsecurely the urPostInsecurely to set
	 */
	public void setUrPostInsecurely(Boolean urPostInsecurely) {
		this.urPostInsecurely = urPostInsecurely;
	}

	/**
	 * @return the urInitialDelayS
	 */
	public Integer getUrInitialDelayS() {
		return urInitialDelayS;
	}

	/**
	 * @param urInitialDelayS the urInitialDelayS to set
	 */
	public void setUrInitialDelayS(Integer urInitialDelayS) {
		this.urInitialDelayS = urInitialDelayS;
	}

	/**
	 * @return the restartOnWakeup
	 */
	public Boolean getRestartOnWakeup() {
		return restartOnWakeup;
	}

	/**
	 * @param restartOnWakeup the restartOnWakeup to set
	 */
	public void setRestartOnWakeup(Boolean restartOnWakeup) {
		this.restartOnWakeup = restartOnWakeup;
	}

	/**
	 * @return the autoUpgradeIntervalH
	 */
	public Integer getAutoUpgradeIntervalH() {
		return autoUpgradeIntervalH;
	}

	/**
	 * @param autoUpgradeIntervalH the autoUpgradeIntervalH to set
	 */
	public void setAutoUpgradeIntervalH(Integer autoUpgradeIntervalH) {
		this.autoUpgradeIntervalH = autoUpgradeIntervalH;
	}

	/**
	 * @return the upgradeToPreReleases
	 */
	public Boolean getUpgradeToPreReleases() {
		return upgradeToPreReleases;
	}

	/**
	 * @param upgradeToPreReleases the upgradeToPreReleases to set
	 */
	public void setUpgradeToPreReleases(Boolean upgradeToPreReleases) {
		this.upgradeToPreReleases = upgradeToPreReleases;
	}

	/**
	 * @return the keepTemporariesH
	 */
	public Integer getKeepTemporariesH() {
		return keepTemporariesH;
	}

	/**
	 * @param keepTemporariesH the keepTemporariesH to set
	 */
	public void setKeepTemporariesH(Integer keepTemporariesH) {
		this.keepTemporariesH = keepTemporariesH;
	}

	/**
	 * @return the cacheIgnoredFiles
	 */
	public Boolean getCacheIgnoredFiles() {
		return cacheIgnoredFiles;
	}

	/**
	 * @param cacheIgnoredFiles the cacheIgnoredFiles to set
	 */
	public void setCacheIgnoredFiles(Boolean cacheIgnoredFiles) {
		this.cacheIgnoredFiles = cacheIgnoredFiles;
	}

	/**
	 * @return the progressUpdateIntervalS
	 */
	public Integer getProgressUpdateIntervalS() {
		return progressUpdateIntervalS;
	}

	/**
	 * @param progressUpdateIntervalS the progressUpdateIntervalS to set
	 */
	public void setProgressUpdateIntervalS(Integer progressUpdateIntervalS) {
		this.progressUpdateIntervalS = progressUpdateIntervalS;
	}

	/**
	 * @return the limitBandwidthInLan
	 */
	public Boolean getLimitBandwidthInLan() {
		return limitBandwidthInLan;
	}

	/**
	 * @param limitBandwidthInLan the limitBandwidthInLan to set
	 */
	public void setLimitBandwidthInLan(Boolean limitBandwidthInLan) {
		this.limitBandwidthInLan = limitBandwidthInLan;
	}

	/**
	 * @return the minHomeDiskFree
	 */
	public DiskFree getMinHomeDiskFree() {
		return minHomeDiskFree;
	}

	/**
	 * @param minHomeDiskFree the minHomeDiskFree to set
	 */
	public void setMinHomeDiskFree(DiskFree minHomeDiskFree) {
		this.minHomeDiskFree = minHomeDiskFree;
	}

	/**
	 * @return the releasesURL
	 */
	public String getReleasesURL() {
		return releasesURL;
	}

	/**
	 * @param releasesURL the releasesURL to set
	 */
	public void setReleasesURL(String releasesURL) {
		this.releasesURL = releasesURL;
	}

	/**
	 * @return the alwaysLocalNets
	 */
	public List<String> getAlwaysLocalNets() {
		return alwaysLocalNets;
	}

	/**
	 * @param alwaysLocalNets the alwaysLocalNets to set
	 */
	public void setAlwaysLocalNets(List<String> alwaysLocalNets) {
		this.alwaysLocalNets = alwaysLocalNets;
	}

	/**
	 * @return the overwriteRemoteDeviceNamesOnConnect
	 */
	public Boolean getOverwriteRemoteDeviceNamesOnConnect() {
		return overwriteRemoteDeviceNamesOnConnect;
	}

	/**
	 * @param overwriteRemoteDeviceNamesOnConnect the overwriteRemoteDeviceNamesOnConnect to set
	 */
	public void setOverwriteRemoteDeviceNamesOnConnect(Boolean overwriteRemoteDeviceNamesOnConnect) {
		this.overwriteRemoteDeviceNamesOnConnect = overwriteRemoteDeviceNamesOnConnect;
	}

	/**
	 * @return the tempIndexMinBlocks
	 */
	public Integer getTempIndexMinBlocks() {
		return tempIndexMinBlocks;
	}

	/**
	 * @param tempIndexMinBlocks the tempIndexMinBlocks to set
	 */
	public void setTempIndexMinBlocks(Integer tempIndexMinBlocks) {
		this.tempIndexMinBlocks = tempIndexMinBlocks;
	}

	/**
	 * @return the unackedNotificationIDs
	 */
	public List<String> getUnackedNotificationIDs() {
		return unackedNotificationIDs;
	}

	/**
	 * @param unackedNotificationIDs the unackedNotificationIDs to set
	 */
	public void setUnackedNotificationIDs(List<String> unackedNotificationIDs) {
		this.unackedNotificationIDs = unackedNotificationIDs;
	}

	/**
	 * @return the trafficClass
	 */
	public Integer getTrafficClass() {
		return trafficClass;
	}

	/**
	 * @param trafficClass the trafficClass to set
	 */
	public void setTrafficClass(Integer trafficClass) {
		this.trafficClass = trafficClass;
	}

	/**
	 * @return the weakHashSelectionMethod
	 */
	public String getWeakHashSelectionMethod() {
		return weakHashSelectionMethod;
	}

	/**
	 * @param weakHashSelectionMethod the weakHashSelectionMethod to set
	 */
	public void setWeakHashSelectionMethod(String weakHashSelectionMethod) {
		this.weakHashSelectionMethod = weakHashSelectionMethod;
	}

	/**
	 * @return the stunServers
	 */
	public List<String> getStunServers() {
		return stunServers;
	}

	/**
	 * @param stunServers the stunServers to set
	 */
	public void setStunServers(List<String> stunServers) {
		this.stunServers = stunServers;
	}

	/**
	 * @return the stunKeepaliveSeconds
	 */
	public Integer getStunKeepaliveSeconds() {
		return stunKeepaliveSeconds;
	}

	/**
	 * @param stunKeepaliveSeconds the stunKeepaliveSeconds to set
	 */
	public void setStunKeepaliveSeconds(Integer stunKeepaliveSeconds) {
		this.stunKeepaliveSeconds = stunKeepaliveSeconds;
	}

	/**
	 * @return the kcpNoDelay
	 */
	public Boolean getKcpNoDelay() {
		return kcpNoDelay;
	}

	/**
	 * @param kcpNoDelay the kcpNoDelay to set
	 */
	public void setKcpNoDelay(Boolean kcpNoDelay) {
		this.kcpNoDelay = kcpNoDelay;
	}

	/**
	 * @return the kcpUpdateIntervalMs
	 */
	public Integer getKcpUpdateIntervalMs() {
		return kcpUpdateIntervalMs;
	}

	/**
	 * @param kcpUpdateIntervalMs the kcpUpdateIntervalMs to set
	 */
	public void setKcpUpdateIntervalMs(Integer kcpUpdateIntervalMs) {
		this.kcpUpdateIntervalMs = kcpUpdateIntervalMs;
	}

	/**
	 * @return the kcpFastResend
	 */
	public Boolean getKcpFastResend() {
		return kcpFastResend;
	}

	/**
	 * @param kcpFastResend the kcpFastResend to set
	 */
	public void setKcpFastResend(Boolean kcpFastResend) {
		this.kcpFastResend = kcpFastResend;
	}

	/**
	 * @return the kcpCongestionControl
	 */
	public Boolean getKcpCongestionControl() {
		return kcpCongestionControl;
	}

	/**
	 * @param kcpCongestionControl the kcpCongestionControl to set
	 */
	public void setKcpCongestionControl(Boolean kcpCongestionControl) {
		this.kcpCongestionControl = kcpCongestionControl;
	}

	/**
	 * @return the kcpSendWindowSize
	 */
	public Integer getKcpSendWindowSize() {
		return kcpSendWindowSize;
	}

	/**
	 * @param kcpSendWindowSize the kcpSendWindowSize to set
	 */
	public void setKcpSendWindowSize(Integer kcpSendWindowSize) {
		this.kcpSendWindowSize = kcpSendWindowSize;
	}

	/**
	 * @return the kcpReceiveWindowSize
	 */
	public Integer getKcpReceiveWindowSize() {
		return kcpReceiveWindowSize;
	}

	/**
	 * @param kcpReceiveWindowSize the kcpReceiveWindowSize to set
	 */
	public void setKcpReceiveWindowSize(Integer kcpReceiveWindowSize) {
		this.kcpReceiveWindowSize = kcpReceiveWindowSize;
	}

	/**
	 * @return the defaultFolderPath
	 */
	public String getDefaultFolderPath() {
		return defaultFolderPath;
	}

	/**
	 * @param defaultFolderPath the defaultFolderPath to set
	 */
	public void setDefaultFolderPath(String defaultFolderPath) {
		this.defaultFolderPath = defaultFolderPath;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Options [listenAddresses=").append(listenAddresses).append(", globalAnnounceServers=").append(globalAnnounceServers).append(", globalAnnounceEnabled=")
				.append(globalAnnounceEnabled).append(", localAnnounceEnabled=").append(localAnnounceEnabled).append(", localAnnouncePort=").append(localAnnouncePort)
				.append(", localAnnounceMCAddr=").append(localAnnounceMCAddr).append(", maxSendKbps=").append(maxSendKbps).append(", maxRecvKbps=").append(maxRecvKbps)
				.append(", reconnectionIntervalS=").append(reconnectionIntervalS).append(", relaysEnabled=").append(relaysEnabled).append(", relayReconnectIntervalM=")
				.append(relayReconnectIntervalM).append(", startBrowser=").append(startBrowser).append(", natEnabled=").append(natEnabled).append(", natLeaseMinutes=")
				.append(natLeaseMinutes).append(", natRenewalMinutes=").append(natRenewalMinutes).append(", natTimeoutSeconds=").append(natTimeoutSeconds).append(", urAccepted=")
				.append(urAccepted).append(", urSeen=").append(urSeen).append(", urUniqueId=").append(urUniqueId).append(", urURL=").append(urURL).append(", urPostInsecurely=")
				.append(urPostInsecurely).append(", urInitialDelayS=").append(urInitialDelayS).append(", restartOnWakeup=").append(restartOnWakeup)
				.append(", autoUpgradeIntervalH=").append(autoUpgradeIntervalH).append(", upgradeToPreReleases=").append(upgradeToPreReleases).append(", keepTemporariesH=")
				.append(keepTemporariesH).append(", cacheIgnoredFiles=").append(cacheIgnoredFiles).append(", progressUpdateIntervalS=").append(progressUpdateIntervalS)
				.append(", limitBandwidthInLan=").append(limitBandwidthInLan).append(", minHomeDiskFree=").append(minHomeDiskFree).append(", releasesURL=").append(releasesURL)
				.append(", alwaysLocalNets=").append(alwaysLocalNets).append(", overwriteRemoteDeviceNamesOnConnect=").append(overwriteRemoteDeviceNamesOnConnect)
				.append(", tempIndexMinBlocks=").append(tempIndexMinBlocks).append(", unackedNotificationIDs=").append(unackedNotificationIDs).append(", trafficClass=")
				.append(trafficClass).append(", weakHashSelectionMethod=").append(weakHashSelectionMethod).append(", stunServers=").append(stunServers)
				.append(", stunKeepaliveSeconds=").append(stunKeepaliveSeconds).append(", kcpNoDelay=").append(kcpNoDelay).append(", kcpUpdateIntervalMs=")
				.append(kcpUpdateIntervalMs).append(", kcpFastResend=").append(kcpFastResend).append(", kcpCongestionControl=").append(kcpCongestionControl)
				.append(", kcpSendWindowSize=").append(kcpSendWindowSize).append(", kcpReceiveWindowSize=").append(kcpReceiveWindowSize).append(", defaultFolderPath=")
				.append(defaultFolderPath).append("]");
		return builder.toString();
	}

	
}
