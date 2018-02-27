package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemDebugFacilities implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4318884325538297009L;

	private String beacon = null;
	
	private String config = null;
	
	private String connections = null;
	
	private String db = null;
	
	private String dialer = null;
	
	private String discover = null;
	
	private String events = null;
	
	private String filesystem = null;
	
	private String http = null;
	
	private String main = null;
	
	private String model = null;
	
	private String nat = null;
	
	private String pmp = null;
	
	private String protocol = null;
	
	private String relay = null;
	
	private String scanner = null;
	
	private String sha256 = null;
	
	private String stats = null;
	
	private String sync = null;
	
	private String upgrade = null;
	
	private String upnp = null;
	
	private String versioner = null;
	
	private String watchaggregator = null;

	/**
	 * @return the beacon
	 */
	public String getBeacon() {
		return beacon;
	}

	/**
	 * @param beacon the beacon to set
	 */
	public void setBeacon(String beacon) {
		this.beacon = beacon;
	}

	/**
	 * @return the config
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(String config) {
		this.config = config;
	}

	/**
	 * @return the connections
	 */
	public String getConnections() {
		return connections;
	}

	/**
	 * @param connections the connections to set
	 */
	public void setConnections(String connections) {
		this.connections = connections;
	}

	/**
	 * @return the db
	 */
	public String getDb() {
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(String db) {
		this.db = db;
	}

	/**
	 * @return the dialer
	 */
	public String getDialer() {
		return dialer;
	}

	/**
	 * @param dialer the dialer to set
	 */
	public void setDialer(String dialer) {
		this.dialer = dialer;
	}

	/**
	 * @return the discover
	 */
	public String getDiscover() {
		return discover;
	}

	/**
	 * @param discover the discover to set
	 */
	public void setDiscover(String discover) {
		this.discover = discover;
	}

	/**
	 * @return the events
	 */
	public String getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}

	/**
	 * @return the filesystem
	 */
	public String getFilesystem() {
		return filesystem;
	}

	/**
	 * @param filesystem the filesystem to set
	 */
	public void setFilesystem(String filesystem) {
		this.filesystem = filesystem;
	}

	/**
	 * @return the http
	 */
	public String getHttp() {
		return http;
	}

	/**
	 * @param http the http to set
	 */
	public void setHttp(String http) {
		this.http = http;
	}

	/**
	 * @return the main
	 */
	public String getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the nat
	 */
	public String getNat() {
		return nat;
	}

	/**
	 * @param nat the nat to set
	 */
	public void setNat(String nat) {
		this.nat = nat;
	}

	/**
	 * @return the pmp
	 */
	public String getPmp() {
		return pmp;
	}

	/**
	 * @param pmp the pmp to set
	 */
	public void setPmp(String pmp) {
		this.pmp = pmp;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the relay
	 */
	public String getRelay() {
		return relay;
	}

	/**
	 * @param relay the relay to set
	 */
	public void setRelay(String relay) {
		this.relay = relay;
	}

	/**
	 * @return the scanner
	 */
	public String getScanner() {
		return scanner;
	}

	/**
	 * @param scanner the scanner to set
	 */
	public void setScanner(String scanner) {
		this.scanner = scanner;
	}

	/**
	 * @return the sha256
	 */
	public String getSha256() {
		return sha256;
	}

	/**
	 * @param sha256 the sha256 to set
	 */
	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	/**
	 * @return the stats
	 */
	public String getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(String stats) {
		this.stats = stats;
	}

	/**
	 * @return the sync
	 */
	public String getSync() {
		return sync;
	}

	/**
	 * @param sync the sync to set
	 */
	public void setSync(String sync) {
		this.sync = sync;
	}

	/**
	 * @return the upgrade
	 */
	public String getUpgrade() {
		return upgrade;
	}

	/**
	 * @param upgrade the upgrade to set
	 */
	public void setUpgrade(String upgrade) {
		this.upgrade = upgrade;
	}

	/**
	 * @return the upnp
	 */
	public String getUpnp() {
		return upnp;
	}

	/**
	 * @param upnp the upnp to set
	 */
	public void setUpnp(String upnp) {
		this.upnp = upnp;
	}

	/**
	 * @return the versioner
	 */
	public String getVersioner() {
		return versioner;
	}

	/**
	 * @param versioner the versioner to set
	 */
	public void setVersioner(String versioner) {
		this.versioner = versioner;
	}

	/**
	 * @return the watchaggregator
	 */
	public String getWatchaggregator() {
		return watchaggregator;
	}

	/**
	 * @param watchaggregator the watchaggregator to set
	 */
	public void setWatchaggregator(String watchaggregator) {
		this.watchaggregator = watchaggregator;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemDebugFacilities [beacon=").append(beacon).append(", config=").append(config).append(", connections=").append(connections).append(", db=").append(db)
				.append(", dialer=").append(dialer).append(", discover=").append(discover).append(", events=").append(events).append(", filesystem=").append(filesystem)
				.append(", http=").append(http).append(", main=").append(main).append(", model=").append(model).append(", nat=").append(nat).append(", pmp=").append(pmp)
				.append(", protocol=").append(protocol).append(", relay=").append(relay).append(", scanner=").append(scanner).append(", sha256=").append(sha256).append(", stats=")
				.append(stats).append(", sync=").append(sync).append(", upgrade=").append(upgrade).append(", upnp=").append(upnp).append(", versioner=").append(versioner)
				.append(", watchaggregator=").append(watchaggregator).append("]");
		return builder.toString();
	}

	
}
