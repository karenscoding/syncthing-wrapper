package com.karens.coding.syncthing.wrapper.api;

/**
 * 
 * @author karen
 *
 */
public class RestURLEndpoints {

	//System Endpoints
	/** 
	 * GET /rest/system/browse
	 * Returns a list of directories matching the path given by the optional parameter current. 
	 * The path can use patterns as described in Go’s filepath package. A ‘*’ will always be appended 
	 * to the given path (e.g. /tmp/ matches all its subdirectories). If the option current is not 
	 * given, filesystem root paths are returned. 
	 */
	public static final String GET_SYSTEM_BROWSE_URL = "/rest/system/browse";
	
	
	/** 
	 * GET /rest/system/config
	 * Returns the current configuration 
	 */
	public static final String GET_SYSTEM_CONFIG_URL = "/rest/system/config";
	
	
	/** 
	 * GET /rest/system/config/insync
	 * Returns whether the config is in sync, i.e. whether the running configuration 
	 * is the same as that on disk. 
	 */
	public static final String GET_SYSTEM_CONFIG_INSYNC_URL = "/rest/system/config/insync";
	
	
	/** 
	 * POST /rest/system/config
	 * Post the full contents of the configuration, in the same format as returned by the 
	 * corresponding GET request. The configuration will be saved to disk and the configInSync 
	 * flag set to false. Restart Syncthing to activate. 
	 */
	public static final String POST_SYSTEM_CONFIG_URL = "/rest/system/config";
	
	
	/** 
	 * GET /rest/system/connections
	 * Returns the list of configured devices and some metadata associated with them. 
	 * The list also contains the local device itself as not connected.
	 * The connection types are TCP (Client), TCP (Server), Relay (Client) and Relay (Server). 
	 */
	public static final String GET_SYSTEM_CONNECTIONS_URL = "/rest/system/connections";
	
	
	/** 
	 * GET /rest/system/debug
	 * Returns the set of debug facilities and which of them are currently enabled. 
	 */
	public static final String GET_SYSTEM_DEBUG_URL = "/rest/system/debug";
	
	
	/** 
	 * POST /rest/system/debug
	 * Enables or disables debugging for specified facilities. Give one or both of enable 
	 * and disable query parameters, with comma separated facility names. 
	 * To disable debugging of the beacon and discovery packages, and enable it for config and db.
	 */
	public static final String POST_SYSTEM_DEBUG_URL = "/rest/system/debug";
	
	
	/** 
	 * GET /rest/system/discovery
	 * Returns the contents of the local discovery cache. 
	 */
	public static final String GET_SYSTEM_DISCOVERY_URL = "/rest/system/discovery";
	
	
	/** 
	 * POST /rest/system/discovery
	 * Post with the query parameters device and addr to add entries to the discovery cache 
	 */
	public static final String POST_SYSTEM_DISCOVERY_URL = "/rest/system/discovery";
	
	
	/** 
	 * POST /rest/system/error/clear
	 * Post with empty to body to remove all recent errors. 
	 */
	public static final String POST_SYSTEM_ERROR_CLEAR_URL = "/rest/system/error/clear";
	
	
	/** 
	 * GET /rest/system/error
	 * Returns the list of recent errors. 
	 */
	public static final String GET_SYSTEM_ERROR_URL = "/rest/system/error";
	
	
	/** 
	 * POST /rest/system/error
	 * Post with an error message in the body (plain text) to register a new error. 
	 * The new error will be displayed on any active GUI clients. 
	 */
	public static final String POST_SYSTEM_ERROR_URL = "/rest/system/error";
	
	
	/** 
	 * GET /rest/system/log
	 * Returns the list of recent log entries. 
	 */
	public static final String GET_SYSTEM_LOG_URL = "/rest/system/log";
	
	
	/** 
	 * POST /rest/system/pause
	 * Pause the given device or all devices. 
	 * Takes the optional parameter device (device ID). When omitted, pauses all devices. 
	 * Returns status 200 and no content upon success, or status 500 and a plain text 
	 * error on failure. 
	 */
	public static final String POST_SYSTEM_PAUSE_URL = "/rest/system/pause";
	
	
	/** 
	 * GET /rest/system/ping
	 * Returns a {"ping": "pong"} object. 
	 */
	public static final String GET_SYSTEM_PING_URL = "/rest/system/ping";
	
	
	/** 
	 * POST /rest/system/ping
	 * Returns a {"ping": "pong"} object. 
	 */
	public static final String POST_SYSTEM_PING_URL = "/rest/system/ping";
	
	
	/** 
	 * POST /rest/system/reset
	 * Post with empty body to erase the current index database and restart Syncthing. 
	 * With no query parameters, the entire database is erased from disk. By 
	 * specifying the folder parameter with a valid folder ID, only information 
	 * for that folder will be erased 
	 */
	public static final String POST_SYSTEM_RESET_URL = "/rest/system/reset";
	
	
	/** 
	 * POST /rest/system/restart
	 * Post with empty body to immediately restart Syncthing. 
	 */
	public static final String POST_SYSTEM_RESTART_URL = "/rest/system/restart";
	
	
	/** 
	 * POST /rest/system/resume
	 * Resume the given device or all devices.
	 * Takes the optional parameter device (device ID). When omitted, 
	 * resumes all devices. Returns status 200 and no content upon success, 
	 * or status 500 and a plain text error on failure. 
	 */
	public static final String POST_SYSTEM_RESUME_URL = "/rest/system/resume";
	
	
	/** 
	 * POST /rest/system/shutdown
	 * Post with empty body to cause Syncthing to exit and not restart. 
	 */
	public static final String POST_SYSTEM_SHUTDOWN_URL = "/rest/system/shutdown";
	
	
	/** 
	 * GET /rest/system/status
	 * Returns information about current system status and resource usage. 
	 */
	public static final String GET_SYSTEM_STATUS_URL = "/rest/system/status";
	
	
	/** 
	 * GET /rest/system/upgrade
	 * Checks for a possible upgrade and returns an object describing the 
	 * newest version and upgrade possibility. 
	 */
	public static final String GET_SYSTEM_UPGRADE_URL = "/rest/system/upgrade";
	
	
	/** 
	 * POST /rest/system/upgrade
	 * Perform an upgrade to the newest released version and restart. 
	 * Does nothing if there is no newer version than currently running. 
	 */
	public static final String POST_SYSTEM_UPGRADE_URL = "/rest/system/upgrade";
	
	
	/** 
	 * GET /rest/system/version
	 * Returns the current Syncthing version information. 
	 */
	public static final String GET_SYSTEM_VERSION_URL = "/rest/system/version";
	
	
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
	public static final String GET_DATABASE_BROWSE_URL = "/rest/db/browse";
	
	
	/** 
	 * GET /rest/db/completion
	 * Returns the completion percentage (0 to 100) for a given device and 
	 * folder. Takes device and folder parameters. 
	 */
	public static final String GET_DATABASE_COMPLETION_URL = "/rest/db/completion";
	
	
	/** 
	 * GET /rest/db/file
	 * Returns most data available about a given file, including version 
	 * and availability. Takes folder and file parameters. 
	 */
	public static final String GET_DATABASE_FILE_URL = "/rest/db/file";
	
	
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
	public static final String GET_DATABASE_IGNORES_URL = "/rest/db/ignores";
	
	
	/** 
	 * POST /rest/db/ignores
	 * Expects a format similar to the output of GET call, but only containing 
	 * the ignore field (expanded field should be omitted). It takes one parameter, 
	 * folder, and either updates the content of the .stignore echoing it back as 
	 * a response, or returns an error. 
	 */
	public static final String POST_DATABASE_IGNORES_URL = "/rest/db/ignores";
	
	
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
	public static final String GET_DATABASE_NEED_URL = "/rest/db/need";
	
	
	/** 
	 * POST /rest/db/override
	 * Request override of a send-only folder. Takes the mandatory parameter folder (folder ID). 
	 */
	public static final String POST_DATABASE_OVERRIDE_URL = "/rest/db/override";
	
	
	/** 
	 * POST /rest/db/prio
	 * Moves the file to the top of the download queue. 
	 */
	public static final String POST_DATABASE_PRIO_URL = "/rest/db/prio";
	
	
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
	public static final String POST_DATABASE_SCAN_URL = "/rest/db/scan";
	
	
	/** 
	 * GET /rest/db/status
	 * Returns information about the current status of a folder.
	 * Parameters: folder, the ID of a folder. 
	 */
	public static final String GET_DATABASE_STATUS_URL = "/rest/db/status";
	
	
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
	public static final String GET_EVENTS_URL = "/rest/events";
	
	
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
	public static final String GET_EVENTS_DISK_URL = "/rest/events/disk";
	
	
	//Statistics Endpoints
	/** 
	 * GET /rest/stats/device
	 * Returns general statistics about devices. 
	 * Currently, only contains the time the device was last seen. 
	 */
	public static final String GET_STATS_DEVICE_URL = "/rest/stats/device";
	
	
	/** 
	 * GET /rest/stats/folder
	 * Returns general statistics about folders. 
	 * Currently contains the last scan time and the last synced file. 
	 */
	public static final String GET_STATS_FOLDER_URL = "/rest/stats/folder";
	
	
	//Misc Services Endpoints
	/** 
	 * GET /rest/svc/deviceid
	 * Verifies and formats a device ID. Accepts all currently valid formats 
	 * (52 or 56 characters with or without separators, upper or lower case, 
	 * with trivial substitutions). Takes one parameter, id, and returns 
	 * either a valid device ID in modern format, or an error. 
	 */
	public static final String GET_SERVICES_DEVICEID_URL = "/rest/svc/deviceid";
	
	
	/** 
	 * GET /rest/svc/lang
	 * Returns a list of canonicalized localization codes, 
	 * as picked up from the Accept-Language header sent by the browser.
	 */
	public static final String GET_SERVICES_LANG_URL = "/rest/svc/lang";
	
	
	/** 
	 * GET /rest/svc/random/string
	 * Returns a strong random generated string (alphanumeric) 
	 * of the specified length. Takes the length parameter. 
	 */
	public static final String GET_SERVICES_RANDOM_STRING_URL = "/rest/svc/random/string";
	
	
	/** 
	 * GET /rest/svc/report
	 * Returns the data sent in the anonymous usage report. 
	 */
	public static final String GET_SERVICES_REPORT_URL = "/rest/svc/report";
		
		
}
