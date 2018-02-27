package com.karens.coding.syncthing.wrapper.api.json.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author karen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoreStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1066370635662574557L;

	private Integer deletable = null;
	
    private Integer doubleStars = null;
    
    private Integer escapedIncludes = null;
    
    private Integer folded = null;
    
    private Integer includes = null;
    
    private Integer inverts = null;
    
    private Integer lines = null;
    
    private Integer rooted = null;
    
    private Integer stars = null;

	/**
	 * @return the deletable
	 */
	public Integer getDeletable() {
		return deletable;
	}

	/**
	 * @param deletable the deletable to set
	 */
	public void setDeletable(Integer deletable) {
		this.deletable = deletable;
	}

	/**
	 * @return the doubleStars
	 */
	public Integer getDoubleStars() {
		return doubleStars;
	}

	/**
	 * @param doubleStars the doubleStars to set
	 */
	public void setDoubleStars(Integer doubleStars) {
		this.doubleStars = doubleStars;
	}

	/**
	 * @return the escapedIncludes
	 */
	public Integer getEscapedIncludes() {
		return escapedIncludes;
	}

	/**
	 * @param escapedIncludes the escapedIncludes to set
	 */
	public void setEscapedIncludes(Integer escapedIncludes) {
		this.escapedIncludes = escapedIncludes;
	}

	/**
	 * @return the folded
	 */
	public Integer getFolded() {
		return folded;
	}

	/**
	 * @param folded the folded to set
	 */
	public void setFolded(Integer folded) {
		this.folded = folded;
	}

	/**
	 * @return the includes
	 */
	public Integer getIncludes() {
		return includes;
	}

	/**
	 * @param includes the includes to set
	 */
	public void setIncludes(Integer includes) {
		this.includes = includes;
	}

	/**
	 * @return the inverts
	 */
	public Integer getInverts() {
		return inverts;
	}

	/**
	 * @param inverts the inverts to set
	 */
	public void setInverts(Integer inverts) {
		this.inverts = inverts;
	}

	/**
	 * @return the lines
	 */
	public Integer getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(Integer lines) {
		this.lines = lines;
	}

	/**
	 * @return the rooted
	 */
	public Integer getRooted() {
		return rooted;
	}

	/**
	 * @param rooted the rooted to set
	 */
	public void setRooted(Integer rooted) {
		this.rooted = rooted;
	}

	/**
	 * @return the stars
	 */
	public Integer getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(Integer stars) {
		this.stars = stars;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IgnoreStats [deletable=").append(deletable).append(", doubleStars=").append(doubleStars).append(", escapedIncludes=").append(escapedIncludes)
				.append(", folded=").append(folded).append(", includes=").append(includes).append(", inverts=").append(inverts).append(", lines=").append(lines).append(", rooted=")
				.append(rooted).append(", stars=").append(stars).append("]");
		return builder.toString();
	}
    
	
}
