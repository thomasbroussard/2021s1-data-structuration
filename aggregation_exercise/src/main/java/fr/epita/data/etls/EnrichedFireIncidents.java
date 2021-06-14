package fr.epita.data.etls;

public class EnrichedFireIncidents {

	FireIncident fireIncident;
	Weather weather;

	public EnrichedFireIncidents(FireIncident fireIncident, Weather weather) {
		this.fireIncident = fireIncident;
		this.weather = weather;
	}

	public FireIncident getFireIncident() {
		return fireIncident;
	}

	public void setFireIncident(FireIncident fireIncident) {
		this.fireIncident = fireIncident;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
}
