package com.karens.coding.syncthing.wrapper.api;

import com.karens.coding.syncthing.wrapper.http.BaseHttpResponse;

public interface SyncthingErrorLogger {
	public void logAPIJsonConversionError(BaseHttpResponse response);
}
