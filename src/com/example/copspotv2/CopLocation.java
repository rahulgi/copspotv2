package com.example.copspotv2;

public class CopLocation {

	/**
	 * Item text
	 */
	@com.google.gson.annotations.SerializedName("location")
	private String mLocation;

	/**
	 * Item Id
	 */
	@com.google.gson.annotations.SerializedName("id")
	private String mId;

	/**
	 * ToDoItem constructor
	 */
	public CopLocation() {

	}

	@Override
	public String toString() {
		return getLocation();
	}

	/**
	 * Initializes a new ToDoItem
	 * 
	 * @param text
	 *            The item text
	 * @param id
	 *            The item id
	 */
	public CopLocation(String location, String id) {
		this.setLocation(location);
		this.setId(id);
	}

	/**
	 * Returns the item text
	 */
	public String getLocation() {
		return mLocation;
	}

	/**
	 * Sets the item text
	 * 
	 * @param text
	 *            text to set
	 */
	public final void setLocation(String location) {
		mLocation = location;
	}

	/**
	 * Returns the item id
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the item id
	 * 
	 * @param id
	 *            id to set
	 */
	public final void setId(String id) {
		mId = id;
	}
}
