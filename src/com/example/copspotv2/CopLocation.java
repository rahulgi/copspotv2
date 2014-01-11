package com.example.copspotv2;

public class CopLocation {

	/**
	 * Cop latitude
	 */
	@com.google.gson.annotations.SerializedName("latitude")
	private Double latitude;
	
	@com.google.gson.annotations.SerializedName("longitude")
	private Double longitude;

	/**
	 * Cop Id
	 */
	@com.google.gson.annotations.SerializedName("id")
	private String mId;

	/**
	 * CopLocation constructor
	 */
	public CopLocation() {

	}

	@Override
	public String toString() {
		return getLocation();
	}

	/**
	 * Initializes a new CopLocation
	 * 
	 * @param text
	 *            The item text
	 * @param id
	 *            The item id
	 */
	public CopLocation(double lat, double lng, String id) {
		this.setLocation(lat, lng);
		this.setId(id);
	}

	/**
	 * Returns the cop location
	 */
	public String getLocation() {
		return latitude.toString() + ", " + longitude.toString();
	}

	/**
	 * Sets the cop location
	 * 
	 * @param text
	 *            text to set
	 */
	public final void setLocation(double lat, double lng) {
		latitude = lat;
		longitude = lng;
	}

	/**
	 * Returns the CopLocation id
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the CopLocation id
	 * 
	 * @param id
	 *            id to set
	 */
	public final void setId(String id) {
		mId = id;
	}
}
