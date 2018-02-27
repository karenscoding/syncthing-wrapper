package com.karens.coding.syncthing.wrapper.api.json;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Empty request for scenarios that need an empty json attribute
 * @author karen
 *
 */
@JsonSerialize
public class EmptyRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1296467699285300427L;

}
