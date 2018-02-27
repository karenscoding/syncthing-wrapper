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
public class ServicesReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5674605794150749030L;

	private Boolean alwaysLocalNets = null;
	
    private Announce announce = null;
    
    private BlockStats blockStats = null;
    
    private Boolean cacheIgnoredFiles = null;
    
    private Boolean customDefaultFolderPath = null;
    
    private Boolean customReleaseURL = null;
    
    private Boolean customStunServers = null;
    
    private Boolean customTempIndexMinBlocks = null;
    
    private Boolean customTrafficClass = null;
    
    private DeviceUses deviceUses = null;
    
	private Integer folderMaxFiles = null;
	
	private Long folderMaxMiB = null;
	
	private FolderUses folderUses = null;
	
	private FolderUsesV3 folderUsesV3 = null;
	
    private GuiStats guiStats = null;
    
    private Double hashPerf = null;
    
    private IgnoreStats ignoreStats = null;
    
    private Boolean limitBandwidthInLan = null;
    
    private String longVersion = null;
    
    private Long memorySize = null;
    
    private Long memoryUsageMiB = null;
    
    private String natType = null;
    
    private Integer numCPU = null;
    
    private Integer numDevices = null;
    
    private Integer numFolders = null;
    
    private Boolean overwriteRemoteDeviceNames = null;
    
    private String platform = null;
    
    private Boolean progressEmitterEnabled = null;
    
    private Relays relays = null;
    
    private Integer[] rescanIntvs = null;
    
    private Boolean restartOnWakeup = null;
    
    private Double sha256Perf = null;
    
    private Boolean temporariesCustom = null;
    
    private Boolean temporariesDisabled = null;
    
    private Integer totFiles = null;
    
    private Long totMiB = null;
    
    private TransportStats transportStats = null;
    
    private String uniqueID = null;
    
    private Boolean upgradeAllowedAuto = null;
    
    private Boolean upgradeAllowedManual = null;
    
    private Boolean upgradeAllowedPre = null;
    
    private Long uptime = null;
    
    private Integer urVersion = null;
    
    private Boolean usesRateLimit = null;
    
    private String version = null;
    
    private String weakHashSelection = null;

	/**
	 * @return the alwaysLocalNets
	 */
	public Boolean getAlwaysLocalNets() {
		return alwaysLocalNets;
	}

	/**
	 * @param alwaysLocalNets the alwaysLocalNets to set
	 */
	public void setAlwaysLocalNets(Boolean alwaysLocalNets) {
		this.alwaysLocalNets = alwaysLocalNets;
	}

	/**
	 * @return the announce
	 */
	public Announce getAnnounce() {
		return announce;
	}

	/**
	 * @param announce the announce to set
	 */
	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	/**
	 * @return the blockStats
	 */
	public BlockStats getBlockStats() {
		return blockStats;
	}

	/**
	 * @param blockStats the blockStats to set
	 */
	public void setBlockStats(BlockStats blockStats) {
		this.blockStats = blockStats;
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
	 * @return the customDefaultFolderPath
	 */
	public Boolean getCustomDefaultFolderPath() {
		return customDefaultFolderPath;
	}

	/**
	 * @param customDefaultFolderPath the customDefaultFolderPath to set
	 */
	public void setCustomDefaultFolderPath(Boolean customDefaultFolderPath) {
		this.customDefaultFolderPath = customDefaultFolderPath;
	}

	/**
	 * @return the customReleaseURL
	 */
	public Boolean getCustomReleaseURL() {
		return customReleaseURL;
	}

	/**
	 * @param customReleaseURL the customReleaseURL to set
	 */
	public void setCustomReleaseURL(Boolean customReleaseURL) {
		this.customReleaseURL = customReleaseURL;
	}

	/**
	 * @return the customStunServers
	 */
	public Boolean getCustomStunServers() {
		return customStunServers;
	}

	/**
	 * @param customStunServers the customStunServers to set
	 */
	public void setCustomStunServers(Boolean customStunServers) {
		this.customStunServers = customStunServers;
	}

	/**
	 * @return the customTempIndexMinBlocks
	 */
	public Boolean getCustomTempIndexMinBlocks() {
		return customTempIndexMinBlocks;
	}

	/**
	 * @param customTempIndexMinBlocks the customTempIndexMinBlocks to set
	 */
	public void setCustomTempIndexMinBlocks(Boolean customTempIndexMinBlocks) {
		this.customTempIndexMinBlocks = customTempIndexMinBlocks;
	}

	/**
	 * @return the customTrafficClass
	 */
	public Boolean getCustomTrafficClass() {
		return customTrafficClass;
	}

	/**
	 * @param customTrafficClass the customTrafficClass to set
	 */
	public void setCustomTrafficClass(Boolean customTrafficClass) {
		this.customTrafficClass = customTrafficClass;
	}

	/**
	 * @return the deviceUses
	 */
	public DeviceUses getDeviceUses() {
		return deviceUses;
	}

	/**
	 * @param deviceUses the deviceUses to set
	 */
	public void setDeviceUses(DeviceUses deviceUses) {
		this.deviceUses = deviceUses;
	}

	/**
	 * @return the folderMaxFiles
	 */
	public Integer getFolderMaxFiles() {
		return folderMaxFiles;
	}

	/**
	 * @param folderMaxFiles the folderMaxFiles to set
	 */
	public void setFolderMaxFiles(Integer folderMaxFiles) {
		this.folderMaxFiles = folderMaxFiles;
	}

	/**
	 * @return the folderMaxMiB
	 */
	public Long getFolderMaxMiB() {
		return folderMaxMiB;
	}

	/**
	 * @param folderMaxMiB the folderMaxMiB to set
	 */
	public void setFolderMaxMiB(Long folderMaxMiB) {
		this.folderMaxMiB = folderMaxMiB;
	}

	/**
	 * @return the folderUses
	 */
	public FolderUses getFolderUses() {
		return folderUses;
	}

	/**
	 * @param folderUses the folderUses to set
	 */
	public void setFolderUses(FolderUses folderUses) {
		this.folderUses = folderUses;
	}

	/**
	 * @return the folderUsesV3
	 */
	public FolderUsesV3 getFolderUsesV3() {
		return folderUsesV3;
	}

	/**
	 * @param folderUsesV3 the folderUsesV3 to set
	 */
	public void setFolderUsesV3(FolderUsesV3 folderUsesV3) {
		this.folderUsesV3 = folderUsesV3;
	}

	/**
	 * @return the guiStats
	 */
	public GuiStats getGuiStats() {
		return guiStats;
	}

	/**
	 * @param guiStats the guiStats to set
	 */
	public void setGuiStats(GuiStats guiStats) {
		this.guiStats = guiStats;
	}

	/**
	 * @return the hashPerf
	 */
	public Double getHashPerf() {
		return hashPerf;
	}

	/**
	 * @param hashPerf the hashPerf to set
	 */
	public void setHashPerf(Double hashPerf) {
		this.hashPerf = hashPerf;
	}

	/**
	 * @return the ignoreStats
	 */
	public IgnoreStats getIgnoreStats() {
		return ignoreStats;
	}

	/**
	 * @param ignoreStats the ignoreStats to set
	 */
	public void setIgnoreStats(IgnoreStats ignoreStats) {
		this.ignoreStats = ignoreStats;
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
	 * @return the longVersion
	 */
	public String getLongVersion() {
		return longVersion;
	}

	/**
	 * @param longVersion the longVersion to set
	 */
	public void setLongVersion(String longVersion) {
		this.longVersion = longVersion;
	}

	/**
	 * @return the memorySize
	 */
	public Long getMemorySize() {
		return memorySize;
	}

	/**
	 * @param memorySize the memorySize to set
	 */
	public void setMemorySize(Long memorySize) {
		this.memorySize = memorySize;
	}

	/**
	 * @return the memoryUsageMiB
	 */
	public Long getMemoryUsageMiB() {
		return memoryUsageMiB;
	}

	/**
	 * @param memoryUsageMiB the memoryUsageMiB to set
	 */
	public void setMemoryUsageMiB(Long memoryUsageMiB) {
		this.memoryUsageMiB = memoryUsageMiB;
	}

	/**
	 * @return the natType
	 */
	public String getNatType() {
		return natType;
	}

	/**
	 * @param natType the natType to set
	 */
	public void setNatType(String natType) {
		this.natType = natType;
	}

	/**
	 * @return the numCPU
	 */
	public Integer getNumCPU() {
		return numCPU;
	}

	/**
	 * @param numCPU the numCPU to set
	 */
	public void setNumCPU(Integer numCPU) {
		this.numCPU = numCPU;
	}

	/**
	 * @return the numDevices
	 */
	public Integer getNumDevices() {
		return numDevices;
	}

	/**
	 * @param numDevices the numDevices to set
	 */
	public void setNumDevices(Integer numDevices) {
		this.numDevices = numDevices;
	}

	/**
	 * @return the numFolders
	 */
	public Integer getNumFolders() {
		return numFolders;
	}

	/**
	 * @param numFolders the numFolders to set
	 */
	public void setNumFolders(Integer numFolders) {
		this.numFolders = numFolders;
	}

	/**
	 * @return the overwriteRemoteDeviceNames
	 */
	public Boolean getOverwriteRemoteDeviceNames() {
		return overwriteRemoteDeviceNames;
	}

	/**
	 * @param overwriteRemoteDeviceNames the overwriteRemoteDeviceNames to set
	 */
	public void setOverwriteRemoteDeviceNames(Boolean overwriteRemoteDeviceNames) {
		this.overwriteRemoteDeviceNames = overwriteRemoteDeviceNames;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the progressEmitterEnabled
	 */
	public Boolean getProgressEmitterEnabled() {
		return progressEmitterEnabled;
	}

	/**
	 * @param progressEmitterEnabled the progressEmitterEnabled to set
	 */
	public void setProgressEmitterEnabled(Boolean progressEmitterEnabled) {
		this.progressEmitterEnabled = progressEmitterEnabled;
	}

	/**
	 * @return the relays
	 */
	public Relays getRelays() {
		return relays;
	}

	/**
	 * @param relays the relays to set
	 */
	public void setRelays(Relays relays) {
		this.relays = relays;
	}

	/**
	 * @return the rescanIntvs
	 */
	public Integer[] getRescanIntvs() {
		return rescanIntvs;
	}

	/**
	 * @param rescanIntvs the rescanIntvs to set
	 */
	public void setRescanIntvs(Integer[] rescanIntvs) {
		this.rescanIntvs = rescanIntvs;
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
	 * @return the sha256Perf
	 */
	public Double getSha256Perf() {
		return sha256Perf;
	}

	/**
	 * @param sha256Perf the sha256Perf to set
	 */
	public void setSha256Perf(Double sha256Perf) {
		this.sha256Perf = sha256Perf;
	}

	/**
	 * @return the temporariesCustom
	 */
	public Boolean getTemporariesCustom() {
		return temporariesCustom;
	}

	/**
	 * @param temporariesCustom the temporariesCustom to set
	 */
	public void setTemporariesCustom(Boolean temporariesCustom) {
		this.temporariesCustom = temporariesCustom;
	}

	/**
	 * @return the temporariesDisabled
	 */
	public Boolean getTemporariesDisabled() {
		return temporariesDisabled;
	}

	/**
	 * @param temporariesDisabled the temporariesDisabled to set
	 */
	public void setTemporariesDisabled(Boolean temporariesDisabled) {
		this.temporariesDisabled = temporariesDisabled;
	}

	/**
	 * @return the totFiles
	 */
	public Integer getTotFiles() {
		return totFiles;
	}

	/**
	 * @param totFiles the totFiles to set
	 */
	public void setTotFiles(Integer totFiles) {
		this.totFiles = totFiles;
	}

	/**
	 * @return the totMiB
	 */
	public Long getTotMiB() {
		return totMiB;
	}

	/**
	 * @param totMiB the totMiB to set
	 */
	public void setTotMiB(Long totMiB) {
		this.totMiB = totMiB;
	}

	/**
	 * @return the transportStats
	 */
	public TransportStats getTransportStats() {
		return transportStats;
	}

	/**
	 * @param transportStats the transportStats to set
	 */
	public void setTransportStats(TransportStats transportStats) {
		this.transportStats = transportStats;
	}

	/**
	 * @return the uniqueID
	 */
	public String getUniqueID() {
		return uniqueID;
	}

	/**
	 * @param uniqueID the uniqueID to set
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	/**
	 * @return the upgradeAllowedAuto
	 */
	public Boolean getUpgradeAllowedAuto() {
		return upgradeAllowedAuto;
	}

	/**
	 * @param upgradeAllowedAuto the upgradeAllowedAuto to set
	 */
	public void setUpgradeAllowedAuto(Boolean upgradeAllowedAuto) {
		this.upgradeAllowedAuto = upgradeAllowedAuto;
	}

	/**
	 * @return the upgradeAllowedManual
	 */
	public Boolean getUpgradeAllowedManual() {
		return upgradeAllowedManual;
	}

	/**
	 * @param upgradeAllowedManual the upgradeAllowedManual to set
	 */
	public void setUpgradeAllowedManual(Boolean upgradeAllowedManual) {
		this.upgradeAllowedManual = upgradeAllowedManual;
	}

	/**
	 * @return the upgradeAllowedPre
	 */
	public Boolean getUpgradeAllowedPre() {
		return upgradeAllowedPre;
	}

	/**
	 * @param upgradeAllowedPre the upgradeAllowedPre to set
	 */
	public void setUpgradeAllowedPre(Boolean upgradeAllowedPre) {
		this.upgradeAllowedPre = upgradeAllowedPre;
	}

	/**
	 * @return the uptime
	 */
	public Long getUptime() {
		return uptime;
	}

	/**
	 * @param uptime the uptime to set
	 */
	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}

	/**
	 * @return the urVersion
	 */
	public Integer getUrVersion() {
		return urVersion;
	}

	/**
	 * @param urVersion the urVersion to set
	 */
	public void setUrVersion(Integer urVersion) {
		this.urVersion = urVersion;
	}

	/**
	 * @return the usesRateLimit
	 */
	public Boolean getUsesRateLimit() {
		return usesRateLimit;
	}

	/**
	 * @param usesRateLimit the usesRateLimit to set
	 */
	public void setUsesRateLimit(Boolean usesRateLimit) {
		this.usesRateLimit = usesRateLimit;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the weakHashSelection
	 */
	public String getWeakHashSelection() {
		return weakHashSelection;
	}

	/**
	 * @param weakHashSelection the weakHashSelection to set
	 */
	public void setWeakHashSelection(String weakHashSelection) {
		this.weakHashSelection = weakHashSelection;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServicesReport [alwaysLocalNets=").append(alwaysLocalNets).append(", announce=").append(announce).append(", blockStats=").append(blockStats)
				.append(", cacheIgnoredFiles=").append(cacheIgnoredFiles).append(", customDefaultFolderPath=").append(customDefaultFolderPath).append(", customReleaseURL=")
				.append(customReleaseURL).append(", customStunServers=").append(customStunServers).append(", customTempIndexMinBlocks=").append(customTempIndexMinBlocks)
				.append(", customTrafficClass=").append(customTrafficClass).append(", deviceUses=").append(deviceUses).append(", folderMaxFiles=").append(folderMaxFiles)
				.append(", folderMaxMiB=").append(folderMaxMiB).append(", folderUses=").append(folderUses).append(", folderUsesV3=").append(folderUsesV3).append(", guiStats=")
				.append(guiStats).append(", hashPerf=").append(hashPerf).append(", ignoreStats=").append(ignoreStats).append(", limitBandwidthInLan=").append(limitBandwidthInLan)
				.append(", longVersion=").append(longVersion).append(", memorySize=").append(memorySize).append(", memoryUsageMiB=").append(memoryUsageMiB).append(", natType=")
				.append(natType).append(", numCPU=").append(numCPU).append(", numDevices=").append(numDevices).append(", numFolders=").append(numFolders)
				.append(", overwriteRemoteDeviceNames=").append(overwriteRemoteDeviceNames).append(", platform=").append(platform).append(", progressEmitterEnabled=")
				.append(progressEmitterEnabled).append(", relays=").append(relays).append(", rescanIntvs=").append(Arrays.toString(rescanIntvs)).append(", restartOnWakeup=")
				.append(restartOnWakeup).append(", sha256Perf=").append(sha256Perf).append(", temporariesCustom=").append(temporariesCustom).append(", temporariesDisabled=")
				.append(temporariesDisabled).append(", totFiles=").append(totFiles).append(", totMiB=").append(totMiB).append(", transportStats=").append(transportStats)
				.append(", uniqueID=").append(uniqueID).append(", upgradeAllowedAuto=").append(upgradeAllowedAuto).append(", upgradeAllowedManual=").append(upgradeAllowedManual)
				.append(", upgradeAllowedPre=").append(upgradeAllowedPre).append(", uptime=").append(uptime).append(", urVersion=").append(urVersion).append(", usesRateLimit=")
				.append(usesRateLimit).append(", version=").append(version).append(", weakHashSelection=").append(weakHashSelection).append("]");
		return builder.toString();
	}
    
    
}
