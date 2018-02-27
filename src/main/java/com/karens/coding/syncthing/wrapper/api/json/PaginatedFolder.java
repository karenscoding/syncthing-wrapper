package com.karens.coding.syncthing.wrapper.api.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginatedFolder extends FolderRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1514706593164970411L;

	private Integer page = null;
	
	private Integer perpage = null;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaginatedFolder [page=").append(page).append(", perpage=").append(perpage).append("]");
		return builder.toString();
	}

	
}
