package fr.epita.data.etls;

import java.util.Date;

public class Weather {

	private String rawDate;
	private String rawTime;
	private String precip;
	private String airMax;
	private Date date;


	public Weather(String rawDate, String rawTime, String precip, String airMax) {
		this.rawDate = rawDate;
		this.rawTime = rawTime;
		this.precip = precip;
		this.airMax = airMax;
	}

	public String getRawDate() {
		return rawDate;
	}

	public void setRawDate(String rawDate) {
		this.rawDate = rawDate;
	}

	public String getRawTime() {
		return rawTime;
	}

	public void setRawTime(String rawTime) {
		this.rawTime = rawTime;
	}

	public String getPrecip() {
		return precip;
	}

	public void setPrecip(String precip) {
		this.precip = precip;
	}

	public String getAirMax() {
		return airMax;
	}

	public void setAirMax(String airMax) {
		this.airMax = airMax;
	}
}
