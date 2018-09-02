package com.karens.coding.syncthing.wrapper.api.convertor;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.karens.coding.syncthing.wrapper.api.SyncthingErrorLogger;
import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;

public interface SyncthingApiConverter {
	public BaseHttpResponse convertJsonToBaseHttpResponseResult(String json, 
			BaseHttpResponse response, SyncthingErrorLogger syncthingErrorLogger) 
					throws IOException, JsonParseException, JsonMappingException;

}
