package com.karens.coding.syncthing.wrapper.api.json.event;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karens.coding.syncthing.wrapper.api.json.event.type.AbstractEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.ConfigSavedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DeviceConnectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DeviceDisconnectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DeviceDiscoveredEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DevicePausedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DeviceRejectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DeviceResumedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.DownloadProgressEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderCompletionEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderErrorsEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderPausedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderRejectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderScanProgressEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.FolderSummaryEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.ItemFinishedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.ItemStartedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.ListenAddressesChangedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.LocalChangeDetectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.LocalIndexUpdatedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.LoginAttemptEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.RemoteChangeDetectedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.RemoteDownloadProgressEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.RemoteIndexUpdatedEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.StartingEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.StartupCompleteEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.StateChangedEvent;

/**
 * 
 * @author karen
 *
 */
public class EventFactory {
	/** Logger */
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(EventFactory.class);
	
	
	public static AbstractEvent[] getEventsByType(String json, String eventType) throws JsonParseException, JsonMappingException, IOException {
		AbstractEvent[] abstractEvent = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		if (eventType.equalsIgnoreCase("ConfigSaved")) {
			// Convert the json string to ConfigSavedEvent[] object
			abstractEvent = objectMapper.readValue(json, ConfigSavedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DeviceConnected")) {
			// Convert the json string to DeviceConnectedEvent[] object
			abstractEvent = objectMapper.readValue(json, DeviceConnectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DeviceDisconnected")) {
			// Convert the json string to DeviceDisconnectedEvent[] object
			abstractEvent = objectMapper.readValue(json, DeviceDisconnectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DeviceDiscovered")) {
			// Convert the json string to DeviceDiscoveredEvent[] object
			abstractEvent = objectMapper.readValue(json, DeviceDiscoveredEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DevicePaused")) {
			// Convert the json string to DevicePausedEvent[] object
			abstractEvent = objectMapper.readValue(json, DevicePausedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DeviceRejected")) {
			// Convert the json string to DeviceRejectedEvent[] object
			abstractEvent = objectMapper.readValue(json, DeviceRejectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DeviceResumed")) {
			// Convert the json string to DeviceResumedEvent[] object
			abstractEvent = objectMapper.readValue(json, DeviceResumedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("DownloadProgress")) {
			// Convert the json string to DownloadProgressEvent[] object
			abstractEvent = objectMapper.readValue(json, DownloadProgressEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderCompletion")) {
			// Convert the json string to FolderCompletionEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderCompletionEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderErrors")) {
			// Convert the json string to FolderErrorsEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderErrorsEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderPaused")) {
			// Convert the json string to FolderPausedEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderPausedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderRejected")) {
			// Convert the json string to FolderRejectedEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderRejectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderScanProgress")) {
			// Convert the json string to FolderScanProgressEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderScanProgressEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("FolderSummary")) {
			// Convert the json string to FolderSummaryEvent[] object
			abstractEvent = objectMapper.readValue(json, FolderSummaryEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("ItemFinished")) {
			// Convert the json string to ItemFinishedEvent[] object
			abstractEvent = objectMapper.readValue(json, ItemFinishedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("ItemStarted")) {
			// Convert the json string to ItemStartedEvent[] object
			abstractEvent = objectMapper.readValue(json, ItemStartedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("ListenAddressesChanged")) {
			// Convert the json string to ListenAddressesChangedEvent[] object
			abstractEvent = objectMapper.readValue(json, ListenAddressesChangedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("LocalChangeDetected")) {
			// Convert the json string to LocalChangeDetectedEvent[] object
			abstractEvent = objectMapper.readValue(json, LocalChangeDetectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("LocalIndexUpdated")) {
			// Convert the json string to LocalIndexUpdatedEvent[] object
			abstractEvent = objectMapper.readValue(json, LocalIndexUpdatedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("LoginAttempt")) {
			// Convert the json string to LoginAttemptEvent[] object
			abstractEvent = objectMapper.readValue(json, LoginAttemptEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("RemoteChangeDetected")) {
			// Convert the json string to RemoteChangeDetectedEvent[] object
			abstractEvent = objectMapper.readValue(json, RemoteChangeDetectedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("RemoteDownloadProgress")) {
			// Convert the json string to RemoteDownloadProgressEvent[] object
			abstractEvent = objectMapper.readValue(json, RemoteDownloadProgressEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("RemoteIndexUpdated")) {
			// Convert the json string to RemoteIndexUpdatedEvent[] object
			abstractEvent = objectMapper.readValue(json, RemoteIndexUpdatedEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("Starting")) {
			// Convert the json string to StartingEvent[] object
			abstractEvent = objectMapper.readValue(json, StartingEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("StartupComplete")) {
			// Convert the json string to StartupCompleteEvent[] object
			abstractEvent = objectMapper.readValue(json, StartupCompleteEvent[].class);
			
		} else if (eventType.equalsIgnoreCase("StateChanged")) {
			// Convert the json string to StateChangedEvent[] object
			abstractEvent = objectMapper.readValue(json, StateChangedEvent[].class);
			
		}
		
		
		return abstractEvent;
	}
}
