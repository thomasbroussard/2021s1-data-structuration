package fr.epita.data.etls.itemreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.data.etls.Weather;

public class WeatherItemReader {


	public List<Weather> extract(String path) throws IOException {
		List<String> lines = Files.readAllLines(new File(path).toPath());
		lines.remove(0); //header
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
		return weatherInfo;
	}
}
