package com.karens.coding.syncthing.wrapper.api.json.database;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilesDownloading implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4798484866129583099L;

	private Integer page = null;
	
	private Integer perpage = null;
	
	/** Files currently being downloaded */
	private List<FileProgress> progress = null;
	
	private List<FileProgress> queued = null;
	
	private List<FileProgress> rest = null;
	
	private Integer total = 0;

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the perpage
	 */
	public Integer getPerpage() {
		return perpage;
	}

	/**
	 * @param perpage the perpage to set
	 */
	public void setPerpage(Integer perpage) {
		this.perpage = perpage;
	}

	/**
	 * @return the progress
	 */
	public List<FileProgress> getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(List<FileProgress> progress) {
		this.progress = progress;
	}

	/**
	 * @return the queued
	 */
	public List<FileProgress> getQueued() {
		return queued;
	}

	/**
	 * @param queued the queued to set
	 */
	public void setQueued(List<FileProgress> queued) {
		this.queued = queued;
	}

	/**
	 * @return the rest
	 */
	public List<FileProgress> getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(List<FileProgress> rest) {
		this.rest = rest;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilesDownloading [page=").append(page).append(", perpage=").append(perpage).append(", progress=").append(progress).append(", queued=").append(queued)
				.append(", rest=").append(rest).append(", total=").append(total).append("]");
		return builder.toString();
	}

	
}
