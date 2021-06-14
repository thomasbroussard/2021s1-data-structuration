package fr.epita.data.etls.itemreader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.epita.data.etls.FireIncident;

public class FireIncidentItemReader {

	public List<FireIncident> extract(String path) throws IOException {
		File file = new File(path);
		List<String> lines = Files.readAllLines(file.toPath());
		List<String> linesInError = new ArrayList<>();
		List<String> linesInSuccess = new ArrayList<>();
		List<FireIncident> fireIncidents = new ArrayList<>();
		lines.remove(0);

		for (String line : lines){
			String[] parts = line.split(",");
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
		return fireIncidents;

	}
}
