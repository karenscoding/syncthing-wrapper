package com.karens.coding.syncthing.api;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.karens.coding.syncthing.wrapper.api.SyncthingRestAPIHandler;
import com.karens.coding.syncthing.wrapper.api.json.Config;
import com.karens.coding.syncthing.wrapper.api.json.Device;
import com.karens.coding.syncthing.wrapper.api.json.DeviceFolder;
import com.karens.coding.syncthing.wrapper.api.json.FileFolderRequest;
import com.karens.coding.syncthing.wrapper.api.json.Folder;
import com.karens.coding.syncthing.wrapper.api.json.FolderRequest;
import com.karens.coding.syncthing.wrapper.api.json.PaginatedFolder;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseBrowseRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnoreRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnores;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseIgnoresRequest;
import com.karens.coding.syncthing.wrapper.api.json.database.DatabaseScanRequest;
import com.karens.coding.syncthing.wrapper.api.json.event.EventsRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemBrowseRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemDebugRequest;
import com.karens.coding.syncthing.wrapper.api.json.system.SystemDiscoveryRequest;
import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;

public class SyncthingRestAPIHandlerTest {
	//Basic rest configuration for each connection
	private static final String PROTOCOL = "http";
	private static final String SYNCTHING_IP_ADDRESS= "127.0.0.1";
	private static final int SYNCTHING_PORT_NUMBER = 8384;
	//Example API key
	private static final String API_KEY = "pGahcht56664QU5eoFQW6szbEG6Ec2Cr";
	private static final String USERNAME = null;
	private static final String PASSWORD = null;
	
	//Specific test values
	private static final String FILENAME = "README.txt";
	private static final String IGNORE_WINDOWS_EXE = "*.exe";
	private static final String IGNORE_MAC_DS_STORE_FOLDERS = "(?d).DS_Store";
	private static final String ROOT_FOLDER = "/";
	//Example device id
	private static final String DEVICE_ID = "MFZWI3D-BONSGYC-YLTMRWG-C43ENR5-QXGZDMM-FZWI3DP-BONSGYY-LTMRWAD";
	private static final String FOLDER_ID = "default";
	
	private int expectedHttpStatusCode = 200;
	
	private SyncthingRestAPIHandler syncthingRestAPIHandler = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		syncthingRestAPIHandler = new SyncthingRestAPIHandler();
		assumeTrue("true".equals(System.getProperty("run.rest.tests")) );
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetSystemBrowse() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemBrowse(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testGetSystemBrowseWithParams() {
		SystemBrowseRequest systemBrowseRequest = new SystemBrowseRequest();
		systemBrowseRequest.setCurrent(ROOT_FOLDER);
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemBrowseWithParams(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, 
				systemBrowseRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemConfig() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("SystemConfig " + systemConfig);
		}
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemConfigInsync() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfigInsync(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemConfig() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			List<String> ignoreFolders = systemConfig.getIgnoredFolders();
			if (ignoreFolders == null) {
				ignoreFolders = new ArrayList<String>();
			}
			ignoreFolders.add("test");
			systemConfig.setIgnoredFolders(ignoreFolders);
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	@Test
	public void testPostSystemConfig_AddDeviceToFolder() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("systemConfig " + systemConfig);
			String deviceId = DEVICE_ID;
			String newFolderId = "fps-template-scripts";
			systemConfig = syncthingRestAPIHandler.addDeviceToFolderViaConfig(systemConfig, deviceId, newFolderId);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	@Test
	public void testPostSystemConfig_AddExistingFolder() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("systemConfig " + systemConfig);
			String deviceId = "OQPIXG4-U5CIZU2-2QTA76C-QIG4SZF-NK7VS76-KUAN3VF-NNGZ7ER-LKOH3Q6";
			String newFolderId = "fps-template-scripts";
			systemConfig = syncthingRestAPIHandler.addDeviceToFolderViaConfig(systemConfig, deviceId, newFolderId);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	@Test
	public void testPostSystemConfig_AddNewFolder() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("systemConfig " + systemConfig);
			Folder newFolder = new Folder();
			newFolder.setId("folder1");
			newFolder.setLabel("folder1");
			newFolder.setPath("/Volumes/folder1");
			systemConfig.addFolder(newFolder);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
	}
	
	@Test
	public void testPostSystemConfig_AddNewFolderNotExisting() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("systemConfig " + systemConfig);
			Folder newFolder = new Folder();
			newFolder.setId("folder2");
			newFolder.setLabel("folder2");
			newFolder.setPath("/Users/karen/folder2");
			systemConfig.addFolder(newFolder);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	@Test
	public void testPostSystemConfig_RemoveFolder() {
		
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		
		if (response != null && response.getResponseObjects().containsKey("systemConfig")) {
			System.out.println("response " + response.getJson());
			Config systemConfig = (Config) response.getResponseObjects().get("systemConfig");
			System.out.println("systemConfig " + systemConfig);
			String newFolderId = "fps_schemas";
			systemConfig = syncthingRestAPIHandler.removeFolderViaConfig(systemConfig, newFolderId);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postSystemConfig(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemConfig);
			int actual = response2.getStatusCode();
			//System.out.println(response);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	
	@Test
	public void testGetSystemConnections() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemConnections(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemDebug() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemDebug(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemDebug() {
		SystemDebugRequest systemDebugRequest = new SystemDebugRequest();
		systemDebugRequest.setEnable("config,db");
		systemDebugRequest.setDisable("beacon");
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemDebug(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemDebugRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemDiscovery() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemDiscovery(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemDiscovery() {
		SystemDiscoveryRequest systemDiscoveryRequest = new SystemDiscoveryRequest();
		systemDiscoveryRequest.setDevice(DEVICE_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemDiscovery(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, systemDiscoveryRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemErrorClear() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemErrorClear(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemError() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemError(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemError() {
		String errorMessage = "There is a really big problem here";
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemError(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, errorMessage);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemLog() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemLog(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemPause() {
		String deviceId = DEVICE_ID;
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemPause(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, deviceId);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemPauseAll() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemPauseAll(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemPing() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemPing(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemPing() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemPing(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemReset() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemReset(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemRestart() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemRestart(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testPostSystemResume() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemResume(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemResumeWithParams() {
		String deviceID = DEVICE_ID;
		Device device = new Device();
		device.setDeviceID(deviceID);
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemResumeWithParams(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, device);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testPostSystemShutdown() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemShutdown(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemStatus() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemStatus(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemUpgrade() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemUpgrade(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostSystemUpgrade() {
		BaseHttpResponse response = syncthingRestAPIHandler.postSystemUpgrade(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetSystemVersion() {
		BaseHttpResponse response = syncthingRestAPIHandler.getSystemVersion(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetDatabaseBrowse() {
		DatabaseBrowseRequest databaseBrowseRequest = new DatabaseBrowseRequest();
		databaseBrowseRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseBrowse(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, databaseBrowseRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetDatabaseCompletion() {
		DeviceFolder databaseCompletionRequest = new DeviceFolder();
		databaseCompletionRequest.setDevice(DEVICE_ID);
		databaseCompletionRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseCompletion(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, databaseCompletionRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetDatabaseFile() {
		FileFolderRequest fileFolderRequest = new FileFolderRequest();
		fileFolderRequest.setFile(FILENAME);
		fileFolderRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseFile(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, fileFolderRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetDatabaseIgnores() {
		DatabaseIgnoresRequest databaseIgnoresRequest = new DatabaseIgnoresRequest();
		databaseIgnoresRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseIgnores(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, databaseIgnoresRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostDatabaseIgnores() {
		DatabaseIgnoresRequest databaseIgnoresRequest = new DatabaseIgnoresRequest();
		databaseIgnoresRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseIgnores(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, databaseIgnoresRequest);
		if (response != null && response.getResponseObjects().containsKey(SyncthingRestAPIHandler.DATABASE_IGNORES_RESPONSE_KEY)) {
			System.out.println("response " + response.getJson());
			DatabaseIgnores databaseIgnores = (DatabaseIgnores) response.getResponseObjects().get(SyncthingRestAPIHandler.DATABASE_IGNORES_RESPONSE_KEY);
			DatabaseIgnoreRequest databaseIgnoreRequest = new DatabaseIgnoreRequest();
			
			List<String> ignoreList = databaseIgnores.getIgnore();
			if (ignoreList == null) {
				ignoreList = new ArrayList<>();
			}
			ignoreList.add(IGNORE_WINDOWS_EXE);
			ignoreList.add(IGNORE_MAC_DS_STORE_FOLDERS);
			
			databaseIgnoreRequest.setIgnore(ignoreList);
			
			BaseHttpResponse response2 = syncthingRestAPIHandler.postDatabaseIgnores(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, FOLDER_ID, databaseIgnoreRequest);
			int actual = response2.getStatusCode();
			//System.out.println(response2);
			assertTrue(expectedHttpStatusCode == actual);
		}
		
	}
	
	@Test
	public void testGetDatabaseNeed() {
		PaginatedFolder paginatedFolder = new PaginatedFolder();
		paginatedFolder.setFolder(FOLDER_ID);
		//paginatedFolder.setPerpage(20);
		//paginatedFolder.setPage(1);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseNeed(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, paginatedFolder);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostDatabaseOverride() {
		FolderRequest folderRequest = new FolderRequest();
		folderRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.postDatabaseOverride(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, folderRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostDatabasePrio() {
		FileFolderRequest fileFolderRequest = new FileFolderRequest();
		fileFolderRequest.setFile(FILENAME);
		fileFolderRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.postDatabasePrio(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, fileFolderRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testPostDatabaseScan() {
		DatabaseScanRequest databaseScanRequest = new DatabaseScanRequest();
		databaseScanRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.postDatabaseScan(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, databaseScanRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetDatabaseStatus() {
		FolderRequest folderRequest = new FolderRequest();
		folderRequest.setFolder(FOLDER_ID);
		BaseHttpResponse response = syncthingRestAPIHandler.getDatabaseStatus(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, folderRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEvents() {
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setSince(0);
		//eventsRequest.setLimit(40);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = syncthingRestAPIHandler.getEvents(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_ConfigSaved() {
		String eventType = "ConfigSaved";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DeviceConnected() {
		String eventType = "DeviceConnected";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DeviceDisconnected() {
		String eventType = "DeviceDisconnected";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DeviceDiscovered() {
		String eventType = "DeviceDiscovered";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DevicePaused() {
		String eventType = "DevicePaused";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DeviceRejected() {
		String eventType = "DeviceRejected";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DeviceResumed() {
		String eventType = "DeviceResumed";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_DownloadProgress() {
		String eventType = "DownloadProgress";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_FolderCompletion() {
		String eventType = "FolderCompletion";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		eventsRequest.setSince(0);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_FolderErrors() {
		String eventType = "FolderErrors";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_FolderPaused() {
		String eventType = "FolderPaused";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testGetEventsByType_FolderRejected() {
		String eventType = "FolderRejected";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testGetEventsByType_FolderScanProgress() {
		String eventType = "FolderScanProgress";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_FolderSummary() {
		String eventType = "FolderSummary";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_ItemFinished() {
		String eventType = "ItemFinished";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_ItemStarted() {
		String eventType = "ItemStarted";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_ListenAddressesChanged() {
		String eventType = "ListenAddressesChanged";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setSince(0);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testGetEventsByType_LocalChangeDetected() {
		String eventType = "LocalChangeDetected";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
	@Test
	public void testGetEventsByType_LocalIndexUpdated() {
		String eventType = "LocalIndexUpdated";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_LoginAttempt() {
		String eventType = "LoginAttempt";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_RemoteChangeDetected() {
		String eventType = "RemoteChangeDetected";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_RemoteDownloadProgress() {
		String eventType = "RemoteDownloadProgress";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_RemoteIndexUpdated() {
		String eventType = "RemoteIndexUpdated";
		EventsRequest eventsRequest = new EventsRequest();
		//eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_Starting() {
		String eventType = "Starting";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_StartupComplete() {
		String eventType = "StartupComplete";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsByType_StateChanged() {
		String eventType = "StateChanged";
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = 
				syncthingRestAPIHandler.getEventsByType(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest, eventType);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetEventsDisk() {
		EventsRequest eventsRequest = new EventsRequest();
		eventsRequest.setLimit(10);
		eventsRequest.setTimeout(10);
		BaseHttpResponse response = syncthingRestAPIHandler.getEventsDisk(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, eventsRequest);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetStatsDevice() {
		BaseHttpResponse response = syncthingRestAPIHandler.getStatsDevice(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetStatsFolder() {
		BaseHttpResponse response = syncthingRestAPIHandler.getStatsFolder(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetServicesDeviceId() {
		String deviceId = DEVICE_ID;
		BaseHttpResponse response = syncthingRestAPIHandler.getServicesDeviceId(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD, deviceId);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetServicesLang() {
		BaseHttpResponse response = syncthingRestAPIHandler.getServicesLang(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetServicesRandomString() {
		BaseHttpResponse response = syncthingRestAPIHandler.getServicesRandomString(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetServicesReport() {
		BaseHttpResponse response = syncthingRestAPIHandler.getServicesReport(PROTOCOL, SYNCTHING_IP_ADDRESS, SYNCTHING_PORT_NUMBER, API_KEY, USERNAME, PASSWORD);
		int actual = response.getStatusCode();
		//System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	
}
