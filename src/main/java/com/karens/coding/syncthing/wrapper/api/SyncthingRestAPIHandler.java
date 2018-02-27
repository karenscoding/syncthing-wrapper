package com.karens.coding.syncthing.wrapper.api;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karens.coding.syncthing.wrapper.api.json.Addresses;
import com.karens.coding.syncthing.wrapper.api.json.Config;
import com.karens.coding.syncthing.wrapper.api.json.Device;
import com.karens.coding.syncthing.wrapper.api.json.DeviceFolder;
import com.karens.coding.syncthing.wrapper.api.json.EmptyRequest;
import com.karens.coding.syncthing.wrapper.api.json.FileFolderRequest;
import com.karens.coding.syncthing.wrapper.api.json.Folder;
import com.karens.coding.syncthing.wrapper.api.json.FolderRequest;
import com.karens.coding.syncthing.wrapper.api.json.FolderStatus;
import com.karens.coding.syncthing.wrapper.api.json.PaginatedFolder;
import com.karens.coding.syncthing.wrapper.api.json.Version;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseBrowseRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseCompletionResponse;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseFileResponse;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnoreRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnores;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnoresRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseScanRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.FilesDownloading;
import com.karens.coding.syncthing.wrapper.api.json.event.EventFactory;
import com.karens.coding.syncthing.wrapper.api.json.event.EventsRequest;
import com.karens.coding.syncthing.wrapper.api.json.event.type.AbstractEvent;
import com.karens.coding.syncthing.wrapper.api.json.event.type.GeneralEvent;
import com.karens.coding.syncthing.wrapper.api.json.other.DeviceError;
import com.karens.coding.syncthing.wrapper.api.json.other.RandomString;
import com.karens.coding.syncthing.wrapper.api.json.other.ServicesReport;
import com.karens.coding.syncthing.wrapper.api.json.statistics.StatisticsDevice;
import com.karens.coding.syncthing.wrapper.api.json.statistics.StatisticsFolder;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemBrowseRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemConfigInSync;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemConnections;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemDebugRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemDebugResponse;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemDiscoveryRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemErrors;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemLog;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemOk;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemPingPong;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemStatus;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemUpgrade;
import com.karens.coding.syncthing.wrapper.errors.ErrorMessages;
import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;
import com.karens.coding.syncthing.wrapper.messages.MessageSourceKeys;
import com.karens.coding.syncthing.wrapper.utils.MessageSourceUtils;


/**
 * 
 * @author karen
 *
 */
@Configuration("SyncthingRestAPIHandler")
public class SyncthingRestAPIHandler {
	
	private static final String JSON_OUTPUT = "json ";

	public static final String SERVICES_REPORT_KEY = "servicesReport";

	public static final String RANDOM_STRING_KEY = "randomString";

	public static final String LANGUAGES_KEY = "languages";

	public static final String DEVICE_ERROR_KEY = "deviceError";

	public static final String STATISTICS_FOLDERS_KEY = "statisticsFolders";

	public static final String STATISTICS_DEVICES_KEY = "statisticsDevices";

	public static final String DISK_EVENT_KEY = "diskEvent";

	public static final String CUSTOM_EVENT_KEY = "customEvent";

	public static final String GENERAL_EVENT_KEY = "generalEvent";

	public static final String EVENTS_KEY = "events";

	public static final String LIMIT_KEY = "limit";

	public static final String TIMEOUT_KEY = "timeout";

	public static final String SINCE_KEY = "since";

	public static final String FOLDER_STATUS_KEY = "folderStatus";

	public static final String NEXT_KEY = "next";

	public static final String SUB_KEY = "sub";

	public static final String FILES_DOWNLOADING_KEY = "filesDownloading";

	public static final String PERPAGE_KEY = "perpage";

	public static final String PAGE_KEY = "page";

	public static final String DATABASE_IGNORES_RESPONSE_KEY = "databaseIgnoresResponse";

	public static final String EXPANDED_KEY = "expanded";

	public static final String DATABASE_FILE_RESPONSE_KEY = "databaseFileResponse";

	public static final String DATABASE_COMPLETION_RESPONSE_KEY = "databaseCompletionResponse";

	public static final String DATABASE_BROWSE_RESPONSE_KEY = "databaseBrowseResponse";

	public static final String PREFIX_KEY = "prefix";

	public static final String VERSION_KEY = "version";

	public static final String SYSTEM_UPGRADE_KEY = "systemUpgrade";

	public static final String SYSTEM_STATUS_KEY = "systemStatus";

	public static final String SYSTEM_RESET_KEY = "systemReset";

	public static final String SYSTEM_PING_PONG_KEY = "systemPingPong";

	public static final String SYSTEM_LOG_KEY = "systemLog";

	public static final String SYSTEM_ERRORS_KEY = "systemErrors";

	public static final String ADDRESS_KEY = "address";

	public static final String DEVICE_KEY = "device";

	public static final String SYSTEM_DISCOVERY_KEY = "systemDiscovery";

	public static final String SYSTEM_DEBUG_KEY = "systemDebug";

	public static final String SYSTEM_CONNECTIONS_KEY = "systemConnections";

	public static final String CONFIG_IN_SYNC_KEY = "configInSync";

	public static final String SYSTEM_CONFIG_KEY = "systemConfig";

	public static final String DIRECTORIES_KEY = "directories";

	public static final String FILE_KEY = "file";

	public static final String FOLDER_KEY = "folder";
	
	public static final String URL_SPACE_SUBSTITUTION = "%20";

	public static final String SINGLE_SPACE = " ";
	
	public static final String DEFAULT_PROTOCOL = "http";
	
	/** Logger */
	private static final Logger logger = LogManager.getLogger(SyncthingRestAPIHandler.class);
	
	private Locale locale = LocaleContextHolder.getLocale();
	
	private MessageSource messageSource = null;
	
	private SyncthingRestAPIConnector syncthingRestAPIConnector = new SyncthingRestAPIConnector();
	
	
	/** 
	 * GET /rest/system/browse
	 * Returns a list of directories matching the path given by the optional parameter current. 
	 * The path can use patterns as described in Go’s filepath package. A ‘*’ will always be appended 
	 * to the given path (e.g. /tmp/ matches all its subdirectories). If the option current is not 
	 * given, filesystem root paths are returned. 
	 */
	public BaseHttpResponse getSystemBrowse(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_BROWSE_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			// Convert the json string to String[] object
    			String[] directories = objectMapper.readValue(json, String[].class);
    			// Check the  is set
    			if (directories != null) {
    				//logger.debug("directories " + Arrays.toString(directories));
    				
    				// Add the Directories to the response
    				response.addResponseObjects(DIRECTORIES_KEY, directories);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/browse?current=/var/
	 * Returns a list of directories matching the path given by the optional parameter current. 
	 * The path can use patterns as described in Go’s filepath package. A ‘*’ will always be appended 
	 * to the given path (e.g. /tmp/ matches all its subdirectories). If the option current is not 
	 * given, filesystem root paths are returned. 
	 */
	public BaseHttpResponse getSystemBrowseWithParams(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, 
			SystemBrowseRequest systemBrowseRequest) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    		
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		queryParams.add("current", systemBrowseRequest.getCurrent());
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_BROWSE_URL);
        	
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to String[] object
    			String[] directories = objectMapper.readValue(json, String[].class);
    			// Check the  is set
    			if (directories != null) {
    				//logger.debug("directories " + Arrays.toString(directories));
    				
    				// Add the Directories to the response
    				response.addResponseObjects(DIRECTORIES_KEY, directories);
    				
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	
	/** 
	 * GET /rest/system/config
	 * Returns the current configuration 
	 */
	public BaseHttpResponse getSystemConfig(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_CONFIG_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug("getSystemConfig " + JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemConfig object
    			Config systemConfig = objectMapper.readValue(json, Config.class);
    			
    			// Check the  is set
    			if (systemConfig != null) {
    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(systemConfig));
        			
    				// Add the SystemConfig to the response
    				response.addResponseObjects(SYSTEM_CONFIG_KEY, systemConfig);
    				
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/config/insync
	 * Returns whether the config is in sync, i.e. whether the running configuration is the same as that on disk. 
	 */
	public BaseHttpResponse getSystemConfigInsync(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_CONFIG_INSYNC_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to ConfigInSync object
    			SystemConfigInSync configInSync = objectMapper.readValue(json, SystemConfigInSync.class);
    			
    			// Check the  is set
    			if (configInSync != null) {
    				
    				// Add the ConfigInSync to the response
    				response.addResponseObjects(CONFIG_IN_SYNC_KEY, configInSync);
    				
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/config
	 * Post the full contents of the configuration, in the same format as returned by the 
	 * corresponding GET request. The configuration will be saved to disk and the configInSync 
	 * flag set to false. Restart Syncthing to activate. 
	 */
	public BaseHttpResponse postSystemConfig(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, Config systemConfig) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_CONFIG_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, systemConfig, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/connections
	 * Returns the list of configured devices and some metadata associated with them. 
	 * The list also contains the local device itself as not connected.
	 * The connection types are TCP (Client), TCP (Server), Relay (Client) and Relay (Server). 
	 */
	public BaseHttpResponse getSystemConnections(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_CONNECTIONS_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			// Convert the json string to SystemConnections object
    			SystemConnections systemConnections = objectMapper.readValue(json, SystemConnections.class);
    			
    			// Check the  is set
    			if (systemConnections != null) {
    				
    				// Add the SystemConnections to the response
    				response.addResponseObjects(SYSTEM_CONNECTIONS_KEY, systemConnections);
    				
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/debug
	 * Returns the set of debug facilities and which of them are currently enabled. 
	 */
	public BaseHttpResponse getSystemDebug(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_DEBUG_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			// Convert the json string to SystemDebugResponse object
    			SystemDebugResponse systemDebug = objectMapper.readValue(json, SystemDebugResponse.class);
    			
    			// Check the  is set
    			if (systemDebug != null) {
    				
    				// Add the systemDebug to the response
    				response.addResponseObjects(SYSTEM_DEBUG_KEY, systemDebug);
    				//logger.debug("systemDebug " + systemDebug);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}

	protected void initialiseErrorMessaging() {
		syncthingRestAPIConnector.setLocale(locale);
		syncthingRestAPIConnector.setMessageSource(messageSource);
	}
	
	/** 
	 * POST /rest/system/debug
	 * Enables or disables debugging for specified facilities. Give one or both of enable 
	 * and disable query parameters, with comma separated facility names. 
	 * To disable debugging of the beacon and discovery packages, and enable it for config and db.
	 */
	public BaseHttpResponse postSystemDebug(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, SystemDebugRequest systemDebugRequest) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		queryParams.add("enable", systemDebugRequest.getEnable());
    		queryParams.add("disable", systemDebugRequest.getDisable());
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_DEBUG_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, systemDebugRequest, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json == null) {
    				logger.error("Json response is null");
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/discovery
	 * Returns the contents of the local discovery cache. 
	 */
	public BaseHttpResponse getSystemDiscovery(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_DISCOVERY_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to systemDiscovery object
    			Map<String, Addresses> systemDiscovery = objectMapper.readValue(json, new TypeReference<Map<String, Addresses>>(){});
    			
    			// Check the systemDiscovery is set
    			if (systemDiscovery != null) {
    				// Add the systemDiscovery to the response
    				response.addResponseObjects(SYSTEM_DISCOVERY_KEY, systemDiscovery);
    				//logger.debug("systemDiscovery " + systemDiscovery);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/discovery
	 * Post with the query parameters device and addr to add entries to the discovery cache 
	 */
	public BaseHttpResponse postSystemDiscovery(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, 
			SystemDiscoveryRequest systemDiscoveryRequest) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (systemDiscoveryRequest.getDevice() != null) {
    			queryParams.add(DEVICE_KEY, systemDiscoveryRequest.getDevice());
    		}
    		if (systemDiscoveryRequest.getAddr() != null ) {
    			queryParams.add(ADDRESS_KEY, systemDiscoveryRequest.getAddr());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_DISCOVERY_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, systemDiscoveryRequest, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/error/clear
	 * Post with empty to body to remove all recent errors. 
	 */
	public BaseHttpResponse postSystemErrorClear(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_ERROR_CLEAR_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/error
	 * Returns the list of recent errors. 
	 */
	public BaseHttpResponse getSystemError(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_ERROR_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemErrors object
    			SystemErrors systemErrors = objectMapper.readValue(json, SystemErrors.class);
    			
    			// Check the systemErrors is set
    			if (systemErrors != null) {
    				
    				// Add the systemErrors to the response
    				response.addResponseObjects(SYSTEM_ERRORS_KEY, systemErrors);
    				//logger.debug("systemErrors " + systemErrors);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/error
	 * Post with an error message in the body (plain text) to register a new error. 
	 * The new error will be displayed on any active GUI clients. 
	 */
	public BaseHttpResponse postSystemError(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, 
			String errorMessage) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_ERROR_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, errorMessage, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/log
	 * Returns the list of recent log entries. 
	 */
	public BaseHttpResponse getSystemLog(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_LOG_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemLog object
    			SystemLog systemLog = objectMapper.readValue(json, SystemLog.class);
    			
    			// Check the  is set
    			if (systemLog != null) {
    				// Add the systemLog to the response
    				response.addResponseObjects(SYSTEM_LOG_KEY, systemLog);
    				//logger.debug("systemLog " + systemLog);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/pause
	 * Pause the given device or all devices. 
	 * Takes the optional parameter device (device ID). When omitted, pauses all devices. 
	 * Returns status 200 and no content upon success, or status 500 and a plain text 
	 * error on failure. 
	 */
	public BaseHttpResponse postSystemPause(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, String deviceId) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_PAUSE_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, deviceId, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/pause
	 * Pause the given device or all devices. 
	 * Takes the optional parameter device (device ID). When omitted, pauses all devices. 
	 * Returns status 200 and no content upon success, or status 500 and a plain text 
	 * error on failure. 
	 */
	public BaseHttpResponse postSystemPauseAll(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_PAUSE_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/ping
	 * Returns a {"ping": "pong"} object. 
	 */
	public BaseHttpResponse getSystemPing(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_PING_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemPingPong object
    			SystemPingPong systemPingPong = objectMapper.readValue(json, SystemPingPong.class);
    			
    			// Check the  is set
    			if (systemPingPong != null) {
    				// Add the systemPingPong to the response
    				response.addResponseObjects(SYSTEM_PING_PONG_KEY, systemPingPong);
    				//logger.debug("systemPingPong " + systemPingPong);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/ping
	 * Returns a {"ping": "pong"} object. 
	 */
	public BaseHttpResponse postSystemPing(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_PING_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemPingPong object
    			SystemPingPong systemPingPong = objectMapper.readValue(json, SystemPingPong.class);
    			
    			// Check the systemPingPong is set
    			if (systemPingPong != null) {
    				// Add the systemPingPong to the response
    				response.addResponseObjects(SYSTEM_PING_PONG_KEY, systemPingPong);
    				//logger.debug("systemPingPong " + systemPingPong);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/reset
	 * Post with empty body to erase the current index database and restart Syncthing. 
	 * With no query parameters, the entire database is erased from disk. By 
	 * specifying the folder parameter with a valid folder ID, only information 
	 * for that folder will be erased 
	 */
	public BaseHttpResponse postSystemReset(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_RESET_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemReset object
    			SystemOk systemReset = objectMapper.readValue(json, SystemOk.class);
    			
    			// Check the systemReset is set
    			if (systemReset != null) {
    				// Add the systemReset to the response
    				response.addResponseObjects(SYSTEM_RESET_KEY, systemReset);
    				//logger.debug("systemReset " + systemReset);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/restart
	 * Post with empty body to immediately restart Syncthing. 
	 */
	public BaseHttpResponse postSystemRestart(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_RESTART_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemReset object
    			SystemOk systemReset = objectMapper.readValue(json, SystemOk.class);
    			
    			// Check the systemReset is set
    			if (systemReset != null) {
    				// Add the systemReset to the response
    				response.addResponseObjects(SYSTEM_RESET_KEY, systemReset);
    				//logger.debug("systemReset " + systemReset);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/resume
	 * Resume the given device or all devices.
	 * Takes the optional parameter device (device ID). When omitted, 
	 * resumes all devices. Returns status 200 and no content upon success, 
	 * or status 500 and a plain text error on failure. 
	 */
	public BaseHttpResponse postSystemResume(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_RESUME_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	/** 
	 * POST /rest/system/resume
	 * Resume the given device or all devices.
	 * Takes the optional parameter device (device ID). When omitted, 
	 * resumes all devices. Returns status 200 and no content upon success, 
	 * or status 500 and a plain text error on failure. 
	 */
	public BaseHttpResponse postSystemResumeWithParams(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password, 
			Device device) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_RESUME_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, device, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * POST /rest/system/shutdown
	 * Post with empty body to cause Syncthing to exit and not restart. 
	 */
	public BaseHttpResponse postSystemShutdown(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_SHUTDOWN_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
		return response;
	}
	
	/** 
	 * GET /rest/system/status
	 * Returns information about current system status and resource usage. 
	 */
	public BaseHttpResponse getSystemStatus(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_STATUS_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemStatus object
    			SystemStatus systemStatus = objectMapper.readValue(json, SystemStatus.class);
    			
    			// Check the  is set
    			if (systemStatus != null) {
    				// Add the SystemStatus to the response
    				response.addResponseObjects(SYSTEM_STATUS_KEY, systemStatus);
    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(systemStatus));
        			
    				//logger.debug("systemStatus " + systemStatus);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
    	return response;
	}
	
	/** 
	 * GET /rest/system/upgrade
	 * Checks for a possible upgrade and returns an object describing the 
	 * newest version and upgrade possibility. 
	 */
	public BaseHttpResponse getSystemUpgrade(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_UPGRADE_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to SystemUpgrade object
    			SystemUpgrade systemUpgrade = objectMapper.readValue(json, SystemUpgrade.class);
    			
    			// Check the  is set
    			if (systemUpgrade != null) {
    				// Add the SystemUpgrade to the response
    				response.addResponseObjects(SYSTEM_UPGRADE_KEY, systemUpgrade);
    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(systemUpgrade));
        			
    				//logger.debug("systemUpgrade " + systemUpgrade);
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
    	return response;
	}
	
	/** 
	 * POST /rest/system/upgrade
	 * Perform an upgrade to the newest released version and restart. 
	 * Does nothing if there is no newer version than currently running. 
	 */
	public BaseHttpResponse postSystemUpgrade(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null;
		String restUrl = null;
    	try {
    		
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_SYSTEM_UPGRADE_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, new EmptyRequest(), apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
    	return response;
	}
	
	/** 
	 * GET /rest/system/version
	 * Returns the current Syncthing version information. 
	 */
	public BaseHttpResponse getSystemVersion(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SYSTEM_VERSION_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			
    			// Convert the json string to Version object
    			Version version = objectMapper.readValue(json, Version.class);
    			
    			// Check the  is set
    			if (version != null) {
    				
    				// Add the Version to the response
    				response.addResponseObjects(VERSION_KEY, version);
    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(version));
        			
    			} else {
    				logAPIJsonConversionError(response);
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}

	
	//Database Endpoints
	/** 
	 * GET /rest/db/browse
	 * Returns the directory tree of the global model. Directories are always 
	 * JSON objects (map/dictionary), and files are always arrays of modification 
	 * time and size. The first integer is the files modification time, and the 
	 * second integer is the file size.
	 * The call takes one mandatory folder parameter and two optional parameters. 
	 * Optional parameter levels defines how deep within the tree we want to dwell 
	 * down (0 based, defaults to unlimited depth) Optional parameter prefix 
	 * defines a prefix within the tree where to start building the structure. 
	 */
	public BaseHttpResponse getDatabaseBrowse(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			DatabaseBrowseRequest databaseBrowseRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (databaseBrowseRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, databaseBrowseRequest.getFolder());
    		}
    		if (databaseBrowseRequest.getPrefix() != null) {
    			queryParams.add(PREFIX_KEY, databaseBrowseRequest.getPrefix());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_BROWSE_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string
    				Map<String, Object[]> databaseBrowseResponse = 
    						objectMapper.readValue(json, new TypeReference<Map<String, Object[]>>(){});
	    			
	    			// Check the databaseBrowseResponse is set
	    			if (databaseBrowseResponse != null) {
	    				// Add the databaseBrowseResponse to the response
	    				response.addResponseObjects(DATABASE_BROWSE_RESPONSE_KEY, databaseBrowseResponse);
	    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(databaseBrowseResponse));
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/db/completion
	 * Returns the completion percentage (0 to 100) for a given device and 
	 * folder. Takes device and folder parameters. 
	 */
	public BaseHttpResponse getDatabaseCompletion(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			DeviceFolder databaseCompletionRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (databaseCompletionRequest.getDevice() != null) {
    			queryParams.add(DEVICE_KEY, databaseCompletionRequest.getDevice());
    		}
    		if (databaseCompletionRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, databaseCompletionRequest.getFolder());
    		}
    		
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_COMPLETION_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to DatabaseCompletionResponse object
	    			DatabaseCompletionResponse databaseCompletionResponse = objectMapper.readValue(json, DatabaseCompletionResponse.class);
	    			
	    			// Check the DatabaseCompletionResponse is set
	    			if (databaseCompletionResponse != null) {
	    				
	    				// Add the DatabaseCompletionResponse to the response
	    				response.addResponseObjects(DATABASE_COMPLETION_RESPONSE_KEY, databaseCompletionResponse);
	    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(databaseCompletionResponse));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/db/file
	 * Returns most data available about a given file, including version 
	 * and availability. Takes folder and file parameters. 
	 */
	public BaseHttpResponse getDatabaseFile(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			FileFolderRequest fileFolderRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (fileFolderRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, fileFolderRequest.getFolder());
    		}
    		if (fileFolderRequest.getFile() != null) {
    			queryParams.add(FILE_KEY, fileFolderRequest.getFile());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_FILE_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to DatabaseFileResponse object
	    			DatabaseFileResponse databaseFileResponse = objectMapper.readValue(json, DatabaseFileResponse.class);
	    			
	    			// Check the DatabaseFileResponse is set
	    			if (databaseFileResponse != null) {
	    				// Add the databaseFileResponse to the response
	    				response.addResponseObjects(DATABASE_FILE_RESPONSE_KEY, databaseFileResponse);
	    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(databaseFileResponse));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/db/ignores
	 * Takes one parameter, folder, and returns the content of the .stignore 
	 * as the ignore field. A second field, expanded, provides a list of strings 
	 * which represent globbing patterns described by gobwas/glob (based on 
	 * standard wildcards) that match the patterns in .stignore and all the includes. 
	 * If appropriate these globs are prepended by the following modifiers: ! to 
	 * negate the glob, (?i) to do case insensitive matching and (?d) to enable 
	 * removing of ignored files in an otherwise empty directory. 
	 */
	public BaseHttpResponse getDatabaseIgnores(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			DatabaseIgnoresRequest databaseIgnoresRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (databaseIgnoresRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, databaseIgnoresRequest.getFolder());
    		}
    		if (databaseIgnoresRequest.getExpanded() != null) {
    			List<String> expanded = databaseIgnoresRequest.getExpanded();
    			for (String exp : expanded) {
    				queryParams.add(EXPANDED_KEY, exp);
    			}
    		}

        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_IGNORES_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to DatabaseIgnoresResponse object
	    			DatabaseIgnores databaseIgnoresResponse = objectMapper.readValue(json, DatabaseIgnores.class);
	    			
	    			// Check the DatabaseIgnoresResponse is set
	    			if (databaseIgnoresResponse != null) {
	    				// Add the databaseIgnoresResponse to the response
	    				response.addResponseObjects(DATABASE_IGNORES_RESPONSE_KEY, databaseIgnoresResponse);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(databaseIgnoresResponse));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * POST /rest/db/ignores
	 * Expects a format similar to the output of GET call, but only containing 
	 * the ignore field (expanded field should be omitted). It takes one parameter, 
	 * folder, and either updates the content of the .stignore echoing it back as 
	 * a response, or returns an error. 
	 */
	public BaseHttpResponse postDatabaseIgnores(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			String folderId, DatabaseIgnoreRequest databaseIgnoreRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (folderId != null) {
    			queryParams.add(FOLDER_KEY, folderId);
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_DATABASE_IGNORES_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, databaseIgnoreRequest, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to DatabaseIgnoresResponse object
	    			DatabaseIgnores databaseIgnoresResponse = objectMapper.readValue(json, DatabaseIgnores.class);
	    			
	    			// Check the DatabaseIgnoresResponse is set
	    			if (databaseIgnoresResponse != null) {
	    				// Add the databaseIgnoresResponse to the response
	    				response.addResponseObjects(DATABASE_IGNORES_RESPONSE_KEY, databaseIgnoresResponse);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(databaseIgnoresResponse));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/db/need
	 * Takes one mandatory parameter, folder, and returns lists of files which 
	 * are needed by this device in order for it to become in sync.
	 * Furthermore takes an optional page and perpage arguments for pagination. 
	 * Pagination happens, across the union of all needed files, that is - 
	 * across all 3 sections of the response. For example, given the current 
	 * need state is as follows:
	 * progress has 15 items
	 * queued has 3 items
	 * rest has 12 items
	 * If you issue a query with page=1 and perpage=10, only the progress section 
	 * in the response will have 10 items. If you issue a request query with page=2 
	 * and perpage=10, progress section will have the last 5 items, queued section 
	 * will have all 3 items, and rest section will have first 2 items. If you issue 
	 * a query for page=3 and perpage=10, you will only have the last 10 items of the 
	 * rest section.
	 * In all these calls, total will be 30 to indicate the total number of available items 
	 */
	public BaseHttpResponse getDatabaseNeed(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			PaginatedFolder paginatedFolder) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (paginatedFolder.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, paginatedFolder.getFolder());
    		}
    		if (paginatedFolder.getPage() != null) {
    			queryParams.add(PAGE_KEY, String.valueOf(paginatedFolder.getPage()));
    		}
    		if (paginatedFolder.getPerpage() != null) {
    			queryParams.add(PERPAGE_KEY, String.valueOf(paginatedFolder.getPerpage()));
    		}
    		

        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_NEED_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			//logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to FilesDownloading object
	    			FilesDownloading filesDownloading = objectMapper.readValue(json, FilesDownloading.class);
	    			
	    			// Check the FilesDownloading is set
	    			if (filesDownloading != null) {
	    				// Add the filesDownloading to the response
	    				response.addResponseObjects(FILES_DOWNLOADING_KEY, filesDownloading);
	    				//logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filesDownloading));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * POST /rest/db/override
	 * Request override of a send-only folder. Takes the mandatory parameter folder (folder ID). 
	 */
	public BaseHttpResponse postDatabaseOverride(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			FolderRequest folderRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (folderRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, folderRequest.getFolder());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_DATABASE_OVERRIDE_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, folderRequest, apiKey, username, password, queryParams);
            
            if (response == null) {
            	
			} else if(response.getStatusCode() != HttpStatus.SC_OK) {
				
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * POST /rest/db/prio
	 * Moves the file to the top of the download queue. 
	 */
	public BaseHttpResponse postDatabasePrio(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			FileFolderRequest fileFolderRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (fileFolderRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, fileFolderRequest.getFolder());
    		}
    		if (fileFolderRequest.getFile() != null) {
    			queryParams.add(FILE_KEY, fileFolderRequest.getFile());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_DATABASE_PRIO_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, fileFolderRequest, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to FilesDownloading object
	    			FilesDownloading filesDownloading = objectMapper.readValue(json, FilesDownloading.class);
	    			
	    			// Check the FilesDownloading is set
	    			if (filesDownloading != null) {
	    				
	    				// Add the filesDownloading to the response
	    				response.addResponseObjects(FILES_DOWNLOADING_KEY, filesDownloading);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filesDownloading));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * POST /rest/db/scan
	 * Request immediate scan. Takes the optional parameters folder 
	 * (folder ID), sub (path relative to the folder root) and next 
	 * (time in seconds). If folder is omitted or empty all folders 
	 * are scanned. If sub is given, only this path (and children, 
	 * in case it’s a directory) is scanned. The next argument delays 
	 * Syncthing’s automated rescan interval for a given amount of seconds.
	 * Requesting scan of a path that no longer exists, but previously 
	 * did, is valid and will result in Syncthing noticing the 
	 * deletion of the path in question.
	 * Returns status 200 and no content upon success, or status 
	 * 500 and a plain text error if an error occurred during 
	 * scanning. 
	 */
	public BaseHttpResponse postDatabaseScan(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			DatabaseScanRequest databaseScanRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (databaseScanRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, databaseScanRequest.getFolder());
    		}
    		if (databaseScanRequest.getSub() != null) {
    			queryParams.add(SUB_KEY, databaseScanRequest.getSub());
    		}
    		if (databaseScanRequest.getNext() != null) {
    			queryParams.add(NEXT_KEY, String.valueOf(databaseScanRequest.getNext()));
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.POST_DATABASE_SCAN_URL);
            response = syncthingRestAPIConnector.postRequestGenerateJson(restUrl, databaseScanRequest, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/db/status
	 * Returns information about the current status of a folder.
	 * Parameters: folder, the ID of a folder. 
	 */
	public BaseHttpResponse getDatabaseStatus(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			FolderRequest folderRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (folderRequest.getFolder() != null) {
    			queryParams.add(FOLDER_KEY, folderRequest.getFolder());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_DATABASE_STATUS_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to FolderStatus object
	    			FolderStatus folderStatus = objectMapper.readValue(json, FolderStatus.class);
	    			
	    			// Check the FolderStatus is set
	    			if (folderStatus != null) {
	    				
	    				// Add the folderStatus to the response
	    				response.addResponseObjects(FOLDER_STATUS_KEY, folderStatus);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(folderStatus));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	//Event Endpoints
	/** 
	 * GET /rest/events
	 * Syncthing provides a simple long polling interface for 
	 * exposing events from the core utility towards a GUI.
	 * To receive events, perform a HTTP GET of /rest/events 
	 * or /rest/events/disk. The latter returns only 
	 * LocalChangeDetected and RemoteChangeDetected events, 
	 * the former all other events unless filtered.
	 * To filter the event list, in effect creating a specific 
	 * subscription for only the desired event types, add a 
	 * parameter events=EventTypeA,EventTypeB,... where the 
	 * event types are any from the list below.
	 * The optional parameter since=<lastSeenID> sets the ID 
	 * of the last event you’ve already seen. Syncthing 
	 * returns a JSON encoded array of event objects, 
	 * starting at the event just after the one with this 
	 * last seen ID. The default value is 0, which returns 
	 * all events. There is a limit to the number of events 
	 * buffered, so if the rate of events is high or the 
	 * time between polling calls is long some events might 
	 * be missed. This can be detected by noting a 
	 * discontinuity in the event IDs.
	 * If no new events are produced since <lastSeenID>, 
	 * the HTTP call blocks and waits for new events to 
	 * happen before returning. By default it times out 
	 * after 60 seconds returning an empty array. The time 
	 * out duration can be customized with the optional 
	 * parameter timeout=seconds.
	 * To receive only a limited number of events, add the limit=n 
	 * parameter with a suitable value for n and only the last n 
	 * events will be returned. This can be used to catch up with 
	 * the latest event ID after a disconnection for 
	 * example: /rest/events?since=0&limit=1.
	 */
	public BaseHttpResponse getEvents(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			EventsRequest eventsRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (eventsRequest.getSince() != null) {
    			queryParams.add(SINCE_KEY, String.valueOf(eventsRequest.getSince()));
    		}
    		if (eventsRequest.getTimeout() != null) {
    			queryParams.add(TIMEOUT_KEY, String.valueOf(eventsRequest.getTimeout()));
    		}
    		if (eventsRequest.getLimit() != null) {
    			queryParams.add(LIMIT_KEY, String.valueOf(eventsRequest.getLimit()));
    		}
    		if (eventsRequest.getEvents() != null) {
    			queryParams.add(EVENTS_KEY, eventsRequest.getEvents());
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_EVENTS_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to GeneralEvent object
	    			GeneralEvent[] generalEvent = objectMapper.readValue(json, GeneralEvent[].class);
	    			
	    			// Check the GeneralEvent is set
	    			if (generalEvent != null) {
	    				
	    				// Add the generalEvent to the response
	    				response.addResponseObjects(GENERAL_EVENT_KEY, generalEvent);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(generalEvent));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/events
	 * Syncthing provides a simple long polling interface for 
	 * exposing events from the core utility towards a GUI.
	 * To receive events, perform a HTTP GET of /rest/events 
	 * or /rest/events/disk. The latter returns only 
	 * LocalChangeDetected and RemoteChangeDetected events, 
	 * the former all other events unless filtered.
	 * To filter the event list, in effect creating a specific 
	 * subscription for only the desired event types, add a 
	 * parameter events=EventTypeA,EventTypeB,... where the 
	 * event types are any from the list below.
	 * The optional parameter since=<lastSeenID> sets the ID 
	 * of the last event you’ve already seen. Syncthing 
	 * returns a JSON encoded array of event objects, 
	 * starting at the event just after the one with this 
	 * last seen ID. The default value is 0, which returns 
	 * all events. There is a limit to the number of events 
	 * buffered, so if the rate of events is high or the 
	 * time between polling calls is long some events might 
	 * be missed. This can be detected by noting a 
	 * discontinuity in the event IDs.
	 * If no new events are produced since <lastSeenID>, 
	 * the HTTP call blocks and waits for new events to 
	 * happen before returning. By default it times out 
	 * after 60 seconds returning an empty array. The time 
	 * out duration can be customized with the optional 
	 * parameter timeout=seconds.
	 * To receive only a limited number of events, add the limit=n 
	 * parameter with a suitable value for n and only the last n 
	 * events will be returned. This can be used to catch up with 
	 * the latest event ID after a disconnection for 
	 * example: /rest/events?since=0&limit=1.
	 */
	public BaseHttpResponse getEventsByType(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			EventsRequest eventsRequest, String eventType) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (eventsRequest.getSince() != null) {
    			queryParams.add(SINCE_KEY, String.valueOf(eventsRequest.getSince()));
    		}
    		if (eventsRequest.getTimeout() != null) {
    			queryParams.add(TIMEOUT_KEY, String.valueOf(eventsRequest.getTimeout()));
    		}
    		if (eventsRequest.getLimit() != null) {
    			queryParams.add(LIMIT_KEY, String.valueOf(eventsRequest.getLimit()));
    		}
    		if (eventType != null) {
    			queryParams.add(EVENTS_KEY, eventType);
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_EVENTS_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to Custom event object
	    			AbstractEvent[] customEvent = EventFactory.getEventsByType(json, eventType);
	    			
	    			// Check the customEvent is set
	    			if (customEvent != null) {
	    				
	    				// Add the customEvent to the response
	    				response.addResponseObjects(CUSTOM_EVENT_KEY, customEvent);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customEvent));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/events/disk
	 * Returns local disk events that occur when the scanner detects 
	 * local file system changes (LocalChangeDetected) or when files 
	 * are pulled from a remote device (RemoteChangeDetected).
	 * Optional GET parameters:
	 * since (events starting after the given ID)
	 * timeout (fail after given seconds if no event is available, 2s by default)
	 * limit (return last x number of events) 
	 */
	public BaseHttpResponse getEventsDisk(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			EventsRequest diskEventsRequest) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (diskEventsRequest.getSince() != null) {
    			queryParams.add(SINCE_KEY, String.valueOf(diskEventsRequest.getSince()));
    		}
    		if (diskEventsRequest.getTimeout() != null) {
    			queryParams.add(TIMEOUT_KEY, String.valueOf(diskEventsRequest.getTimeout()));
    		}
    		if (diskEventsRequest.getLimit() != null) {
    			queryParams.add(LIMIT_KEY, String.valueOf(diskEventsRequest.getLimit()));
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_EVENTS_DISK_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to DiskEvent object
	    			GeneralEvent[] diskEvent = objectMapper.readValue(json, GeneralEvent[].class);
	    			
	    			// Check the DiskEvent is set
	    			if (diskEvent != null) {
	    				
	    				// Add the diskEvent to the response
	    				response.addResponseObjects(DISK_EVENT_KEY, diskEvent);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diskEvent));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	//Statistics Endpoints
	/** 
	 * GET /rest/stats/device
	 * Returns general statistics about devices. 
	 * Currently, only contains the time the device was last seen. 
	 */
	public BaseHttpResponse getStatsDevice(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_STATS_DEVICE_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to statisticsDevice object
    				Map<String, StatisticsDevice> statisticsDevices = objectMapper.readValue(json, new TypeReference<Map<String, StatisticsDevice>>(){});
        			
	    			// Check the StatisticsDevice is set
	    			if (statisticsDevices != null) {
	    				
	    				// Add the statisticsDevices to the response
	    				response.addResponseObjects(STATISTICS_DEVICES_KEY, statisticsDevices);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(statisticsDevices));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/stats/folder
	 * Returns general statistics about folders. 
	 * Currently contains the last scan time and the last synced file. 
	 */
	public BaseHttpResponse getStatsFolder(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_STATS_FOLDER_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
	    			// Convert the json string to statisticsFolders object
    				Map<String, StatisticsFolder> statisticsFolders = 
    						objectMapper.readValue(json, new TypeReference<Map<String, StatisticsFolder>>(){});
        			
	    			// Check the statisticsFolders is set
	    			if (statisticsFolders != null) {
	    				
	    				// Add the statisticsFolders to the response
	    				response.addResponseObjects(STATISTICS_FOLDERS_KEY, statisticsFolders);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(statisticsFolders));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	//Misc Services Endpoints
	/** 
	 * GET /rest/svc/deviceid
	 * Verifies and formats a device ID. Accepts all currently valid formats 
	 * (52 or 56 characters with or without separators, upper or lower case, 
	 * with trivial substitutions). Takes one parameter, id, and returns 
	 * either a valid device ID in modern format, or an error. 
	 */
	public BaseHttpResponse getServicesDeviceId(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password,
			String deviceId) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
    		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    		if (deviceId != null) {
    			queryParams.add("id", deviceId);
    		}
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SERVICES_DEVICEID_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password, queryParams);
            
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
    				// Convert the json string to DeviceError object
	    			DeviceError deviceError = objectMapper.readValue(json, DeviceError.class);
	    			
	    			// Check the DeviceError is set
	    			if (deviceError != null) {
	    				
	    				// Add the deviceError to the response
	    				response.addResponseObjects(DEVICE_ERROR_KEY, deviceError);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deviceError));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/svc/lang
	 * Returns a list of canonicalized localization codes, 
	 * as picked up from the Accept-Language header sent by the browser.
	 */
	public BaseHttpResponse getServicesLang(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SERVICES_LANG_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
    				// Convert the json string to languages object
	    			String[] languages = objectMapper.readValue(json, String[].class);
	    			
	    			// Check the languages is set
	    			if (languages != null) {
	    				
	    				// Add the languages to the response
	    				response.addResponseObjects(LANGUAGES_KEY, languages);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(languages));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/svc/random/string
	 * Returns a strong random generated string (alphanumeric) 
	 * of the specified length. Takes the length parameter. 
	 */
	public BaseHttpResponse getServicesRandomString(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SERVICES_RANDOM_STRING_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
    				// Convert the json string to RandomString 
    				RandomString randomString = objectMapper.readValue(json, RandomString.class);
	    			
	    			// Check the RandomString is set
	    			if (randomString != null) {
	    				
	    				// Add the randomString to the response
	    				response.addResponseObjects(RANDOM_STRING_KEY, randomString);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(randomString));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	/** 
	 * GET /rest/svc/report
	 * Returns the data sent in the anonymous usage report. 
	 */
	public BaseHttpResponse getServicesReport(String protocol, String syncthingIpAddress, int syncthingPortNumber, String apiKey, String username, String password) {
		BaseHttpResponse response = null; 
    	String restUrl = null;
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
        	
    		initialiseErrorMessaging();
    		
        	restUrl = getSyncThingUrl(protocol, syncthingIpAddress, syncthingPortNumber, RestURLEndpoints.GET_SERVICES_REPORT_URL);
            response = syncthingRestAPIConnector.getRequest(restUrl, apiKey, username, password);
            
            if (response != null && response.getStatusCode() == HttpStatus.SC_OK) {
    			// Get the json response
    			String json = response.getJson();
    			logger.debug(JSON_OUTPUT + json);
    			if (json != null) {
    				// Convert the json string to ServicesReport 
    				ServicesReport servicesReport = objectMapper.readValue(json, ServicesReport.class);
	    			
	    			// Check the ServicesReport is set
	    			if (servicesReport != null) {
	    				
	    				// Add the servicesReport to the response
	    				response.addResponseObjects(SERVICES_REPORT_KEY, servicesReport);
	    				logger.debug(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(servicesReport));
	        			
	    			} else {
	    				logAPIJsonConversionError(response);
	    			}
    			}
			}
            
        } catch (Exception ex) {
            logAPIException(response, restUrl, ex);
        }
        return response;
	}
	
	
	public Config addDeviceToFolderViaConfig(Config systemConfig, String deviceId, String newFolderId) {
		Device newDevice = new Device();
		newDevice.setDeviceID(deviceId);
		boolean foundDevice = false;
		for (Folder folder : systemConfig.getFolders()) {
			String folderId = folder.getId();
			if (folderId.equals(newFolderId)) {
				logger.debug("folderId " + folderId);
				for (Device device: folder.getDevices()) {
					String currentDeviceId = device.getDeviceID();
					logger.debug("currentDeviceId " + currentDeviceId);
					if (currentDeviceId.equals(deviceId)) {
						foundDevice = true;
						break;
					}
				}
				logger.debug("foundDevice " + foundDevice);
				if (!foundDevice) {
					folder.addDevice(newDevice);
					
				}
			}
		}
		return systemConfig;
	}
	
	public Config removeDeviceFromFolderViaConfig(Config systemConfig, String deviceId, String selectedFolderId) {
		Device newDevice = new Device();
		newDevice.setDeviceID(deviceId);
		for (Folder folder : systemConfig.getFolders()) {
			String folderId = folder.getId();
			if (folderId.equals(selectedFolderId)) {
				logger.debug("folderId " + folderId);
				for (Device device: folder.getDevices()) {
					String currentDeviceId = device.getDeviceID();
					logger.debug("currentDeviceId " + currentDeviceId);
					if (currentDeviceId.equals(deviceId)) {
						folder.getDevices().remove(device);
						break;
					}
				}
				
			}
		}
		return systemConfig;
	}
	
	public Config removeFolderViaConfig(Config systemConfig, String selectedFolderId) {
		for (Folder folder : systemConfig.getFolders()) {
			String folderId = folder.getId();
			if (folderId.equals(selectedFolderId)) {
				systemConfig.removeFolder(folder);
				logger.debug("removed folder id " + selectedFolderId);
				logger.debug("removed folder  " + systemConfig.getFolders());
				
				break;
			}
		}
		return systemConfig;
	}
	
	
	/**
	 * 
	 * @param syncthingIpAddress
	 * @param syncthingPortNumber
	 * @param path
	 * @return
	 */
	protected String getSyncThingUrl(String syncthingIpAddress, int syncthingPortNumber, String path) {
		return getSyncThingUrl(DEFAULT_PROTOCOL, syncthingIpAddress, syncthingPortNumber, path);
	}
	
	/**
	 * 
	 * @param syncthingIpAddress
	 * @param syncthingPortNumber
	 * @param path
	 * @param protocol
	 * @return
	 */
	protected String getSyncThingUrl(String protocol, String syncthingIpAddress, int syncthingPortNumber, String path) {
		return String.format("%s://%s:%d/%s", protocol, syncthingIpAddress, syncthingPortNumber, path)
				.replaceAll(SINGLE_SPACE, URL_SPACE_SUBSTITUTION);
	}
	
	protected void logAPIJsonConversionError(BaseHttpResponse response) {
		logger.error("Unable to retrieve syncthing data");
		String userErrorMessage = MessageSourceUtils.getMessage(
				messageSource, locale, MessageSourceKeys.API_ERROR_COMMUNICATION_FAILED_KEY, 
				ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
		response.addUserErrorMessage(userErrorMessage);
	}
	
	protected void logAPIError(BaseHttpResponse response, String restUrl, String error) {
		if (error != null){
			logger.error(error);
		}
		if (response != null) { 
			String userErrorMessage = MessageSourceUtils.getMessage(
					messageSource, locale, MessageSourceKeys.API_ERROR_COMMUNICATION_FAILED_KEY, 
					ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
			
			response.addUserErrorMessage(userErrorMessage);
			logger.error(userErrorMessage);
			logger.error("Unable to retrieve syncthing data " + restUrl);
		}
		
	}

	protected void logAPIException(BaseHttpResponse response, String restUrl, Exception ex) {
		if (ex != null){
			logger.error(ex.getMessage(), ex);
		}
		if (response != null) { 
			String userErrorMessage = MessageSourceUtils.getMessage(
					messageSource, locale, MessageSourceKeys.API_ERROR_COMMUNICATION_FAILED_KEY, 
					ErrorMessages.UNABLE_TO_COMMUNICATE_WITH_SERVER, null);
			
			response.addUserErrorMessage(userErrorMessage);
			logger.error(userErrorMessage);
			logger.error("Unable to retrieve syncthing data " + restUrl);
		}
		
	}
	
	
}
