package com.karens.coding.syncthing.wrapper.api.json.event.type.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Event data which is specific to each event type
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface EventData {

}
