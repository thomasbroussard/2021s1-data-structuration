package fr.epita.data.etls;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import fr.epita.data.etls.itemreader.FireIncidentItemReader;
import fr.epita.data.etls.itemreader.WeatherItemReader;

public class TestItemReaders {

	public static void main(String[] args) throws IOException, ParseException {
		FireIncidentItemReader fireIncidentItemReader = new FireIncidentItemReader();
		WeatherItemReader weatherItemReader = new WeatherItemReader();
		List<FireIncident> fireIncidents = fireIncidentItemReader.extract("S:\\Work\\ae\\Epita\\workspaces\\2021-s1-data-strucuration-transportation\\aggregation_exercise\\src\\main\\resources\\California_Fire_Incidents.csv");
		List<Weather> weartherInfo = weatherItemReader.extract("S:\\Work\\ae\\Epita\\workspaces\\2021-s1-data-strucuration-transportation\\aggregation_exercise\\src\\main\\resources\\weather-sf.csv");
		ItemProcessor itemProcessor = new ItemProcessor();

		itemProcessor.transform(weartherInfo,fireIncidents);


	}
}
