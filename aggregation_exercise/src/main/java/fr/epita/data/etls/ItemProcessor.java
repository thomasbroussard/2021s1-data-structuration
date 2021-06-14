package fr.epita.data.etls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemProcessor {


	public List<EnrichedFireIncidents> transform(List<Weather> weatherList, List<FireIncident> fireIncidentList) throws ParseException {
		List<EnrichedFireIncidents> refinedFireIncidents = new ArrayList<>();

		for (Weather weather : weatherList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String weatherDate = weather.getRawDate();
			sdf.parse(weatherDate);
			for (FireIncident fire : fireIncidentList) {
				String fireDate = sdf.format(fire.getDate());
				if (fireDate.equals(weatherDate)) {
					refinedFireIncidents.add(new EnrichedFireIncidents(fire, weather));
					System.out.println("match!");
				}
			}
		}

		System.out.println(refinedFireIncidents);


		return refinedFireIncidents;

	}
}
