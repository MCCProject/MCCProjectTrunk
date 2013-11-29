package com.custom;

import java.util.List;

/**
 * This class represents the response of the Yelp API call
 *
 */
public class SearchResult {

	private List<Business> businesses;
	private String total;
	
	
	/**
	 * 
	 */
	public SearchResult() {
		super();
	}
	/**
	 * @return the businesses
	 */
	public List<Business> getBusinesses() {
		return businesses;
	}
	/**
	 * @param businesses the businesses to set
	 */
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
