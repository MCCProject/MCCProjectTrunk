package com.custom;

import java.util.List;

/**
 * Represents an result entry inside the json response from Yelp API
 *
 */
public class Business {
	
	private String id;
	private String name;
	private List<String[]> categories;
	private String rating;
	private String review_count;
	private String snippet_image_url;
	private String snippet_text;
	
	private boolean is_claimed;
	private String mobile_url;
	private String rating_img_url;
	private String url;
	private String image_url;
	private double distance;
	private Location location; 
	private String display_phone;

	/**
	 * @param id
	 */
	public Business(String id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return the id
	 */
	public String getDisplay_phone() {
		return display_phone;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the categories
	 */
	public List<String[]> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<String[]> categories) {
		this.categories = categories;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @return the rating
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	public double getDistance() {
		return this.distance;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the review_count
	 */
	public String getReview_count() {
		return review_count;
	}

	/**
	 * @param review_count the review_count to set
	 */
	public void setReview_count(String review_count) {
		this.review_count = review_count;
	}

	/**
	 * @return the snippet_image_url
	 */
	public String getSnippet_image_url() {
		return snippet_image_url;
	}

	/**
	 * @param snippet_image_url the snippet_image_url to set
	 */
	public void setSnippet_image_url(String snippet_image_url) {
		this.snippet_image_url = snippet_image_url;
	}

	/**
	 * @return the snippet_text
	 */
	public String getSnippet_text() {
		return snippet_text;
	}

	/**
	 * @param snippet_text the snippet_text to set
	 */
	public void setSnippet_text(String snippet_text) {
		this.snippet_text = snippet_text;
	}

	/**
	 * @return the is_claimed
	 */
	public boolean isIs_claimed() {
		return is_claimed;
	}

	/**
	 * @param is_claimed the is_claimed to set
	 */
	public void setIs_claimed(boolean is_claimed) {
		this.is_claimed = is_claimed;
	}

	/**
	 * @return the mobile_url
	 */
	public String getMobile_url() {
		return mobile_url;
	}

	/**
	 * @param mobile_url the mobile_url to set
	 */
	public void setMobile_url(String mobile_url) {
		this.mobile_url = mobile_url;
	}

	/**
	 * @return the rating_img_url
	 */
	public String getRating_img_url() {
		return rating_img_url;
	}

	/**
	 * @param rating_img_url the rating_img_url to set
	 */
	public void setRating_img_url(String rating_img_url) {
		this.rating_img_url = rating_img_url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the image_url
	 */
	public String getImage_url() {
		return image_url;
	}

	/**
	 * @param image_url the image_url to set
	 */
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
