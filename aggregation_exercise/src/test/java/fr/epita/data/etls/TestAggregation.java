package fr.epita.data.etls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestAggregation {


	public static void main(String[] args) throws IOException {

		//extract from california_fire_incidents.csv
		//extract :
		// latitude 	=> column 22
		// longitude 	=> column 24
		// date & time  => column 32


		File file = new File("S:\\Work\\ae\\Epita\\workspaces\\2021-s1-data-strucuration-transportation\\aggregation_exercise\\src\\main\\resources\\California_Fire_Incidents.csv");
		List<String> lines = Files.readAllLines(file.toPath());
		List<String> linesInError = new ArrayList<>();
		List<String> linesInSuccess = new ArrayList<>();
		List<FireIncident> fireIncidents = new ArrayList<>();
		lines.remove(0);

		for (String line : lines){
			String[] parts = line.split(",\\\"");
			if (parts.length > 31){
				String latitude = parts[21];
				String longitude = parts[23];
				String rawDate = parts[31];

				//2013-08-17T15:25:00Z
				try {
					Date date = Date.from(LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(rawDate)).toInstant(ZoneOffset.UTC));
					fireIncidents.add(new FireIncident(latitude, longitude, date));
				}catch(Exception e){
					linesInError.add(line);
				}
				linesInSuccess.add(line);
			}else{
				linesInError.add(line);
			}
		}

		System.out.println(fireIncidents);
		System.out.println(fireIncidents.size());

		System.out.println(linesInError.get(0));







	}
}
