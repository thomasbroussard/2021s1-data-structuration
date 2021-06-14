package fr.epita.data.etls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TestWeatherReader {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(new File("S:\\Work\\ae\\Epita\\workspaces\\2021-s1-data-strucuration-transportation\\aggregation_exercise\\src\\main\\resources\\weather-sf.csv").toPath());
		List<Weather> weatherInfo = new ArrayList<>();
		for (String line : lines){
			String[] parts = line.split(",");
			String rawDate = parts[0];
			String rawTime = parts[1];
			String precip = parts[2];
			String airMax = parts[3];

			Weather weather = new Weather(rawDate,rawTime,precip,airMax);
			weatherInfo.add(weather);
		}

		System.out.println(weatherInfo.size());



	}
}
