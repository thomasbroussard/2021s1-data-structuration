package fr.epita.data.etls;

import java.util.Date;

public class FireIncident {

	private String latitude;
	private String longitude;
	private Date date;

	public FireIncident(String latitude, String longitude, Date date) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
	}

	@Override
	public String toString() {
		return "FireIncident{" +
				"latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", date=" + date +
				'}';
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
