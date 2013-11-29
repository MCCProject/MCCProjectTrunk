package com.custom;

import java.util.List;

/**
 * This class represents the location of a business
 *
 */
public class Location {

	private String city;
	private List<String> display_address;
	private String country_code;
	private String state_code;
	private List<String> neighborhoods;
	
	
	
	
	/**
	 * default constructor
	 */
	public Location() {
		super();
	}


	/**
	 * @param city
	 * @param display_address
	 * @param country_code
	 * @param state_code
	 * @param neighborhoods
	 */
	public Location(String city, List<String> display_address,
			String country_code, String state_code, List<String> neighborhoods) {
		super();
		this.city = city;
		this.display_address = display_address;
		this.country_code = country_code;
		this.state_code = state_code;
		this.neighborhoods = neighborhoods;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the display_address
	 */
	public List<String> getDisplay_address() {
		return display_address;
	}


	/**
	 * @param display_address the display_address to set
	 */
	public void setDisplay_address(List<String> display_address) {
		this.display_address = display_address;
	}


	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}


	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}


	/**
	 * @return the state_code
	 */
	public String getState_code() {
		return state_code;
	}


	/**
	 * @param state_code the state_code to set
	 */
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}


	/**
	 * @return the neighborhoods
	 */
	public List<String> getNeighborhoods() {
		return neighborhoods;
	}


	/**
	 * @param neighborhoods the neighborhoods to set
	 */
	public void setNeighborhoods(List<String> neighborhoods) {
		this.neighborhoods = neighborhoods;
	}
	
	
	public String GetFullAddress()
	{
		String add = this.display_address.toString();
		return add;
	}
	
}
