package com.karens.coding.syncthing.api;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

//import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.karens.coding.syncthing.wrapper.api.SyncthingRestAPIConnector;
import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;

public class SyncthingRestAPIConnectorTest {

	private String baseUrl = "http://127.0.0.1:8384/";
	private int expectedHttpStatusCode = 200;
	
	private String apiKey = "abcdefg";
	private String username = null;
	private String password = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		assumeTrue("true".equals(System.getProperty("run.rest.tests")) );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRequestSystemVersion() {
		String url = this.baseUrl + "rest/system/version";
		SyncthingRestAPIConnector apiHandler = new SyncthingRestAPIConnector();
		BaseHttpResponse response = apiHandler.getRequest(url, apiKey, username, password);
		int actual = response.getStatusCode();
		System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetRequestSystemBrowse() {
		String url = this.baseUrl + "/rest/system/browse";
		SyncthingRestAPIConnector apiHandler = new SyncthingRestAPIConnector();
		BaseHttpResponse response = apiHandler.getRequest(url, apiKey, username, password);
		int actual = response.getStatusCode();
		System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
	@Test
	public void testGetRequestSystemConfig() {
		String url = this.baseUrl + "/rest/system/config";
		SyncthingRestAPIConnector apiHandler = new SyncthingRestAPIConnector();
		BaseHttpResponse response = apiHandler.getRequest(url, apiKey, username, password);
		int actual = response.getStatusCode();
		System.out.println(response);
		assertTrue(expectedHttpStatusCode == actual);
	}
	
}
