package com.karens.coding.syncthing.wrapper.api.json.system;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.karens.coding.syncthing.wrapper.api.json.TotalConnectionDetails;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemConnections implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3110350255640177687L;

	private TotalConnectionDetails total = null;
	
	private Map<String, SystemConnection> connections = new HashMap<String, SystemConnection>();

	/**
	 * @return the total
	 */
	public TotalConnectionDetails getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(TotalConnectionDetails total) {
		this.total = total;
	}

	/**
	 * @return the connections
	 */
	public Map<String, SystemConnection> getConnections() {
		return connections;
	}

	/**
	 * @param connections the connections to set
	 */
	public void setConnections(Map<String, SystemConnection> connections) {
		this.connections = connections;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemConnections [total=").append(total).append(", connections=").append(connections).append("]");
		return builder.toString();
	}

	
}
