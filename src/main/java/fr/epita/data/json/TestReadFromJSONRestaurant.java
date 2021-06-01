package fr.epita.data.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestReadFromJSONRestaurant {

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(new File("src/main/resources/file1.json"));

		double total = 0.0;
		int count = 0;
		for (JsonNode apiCall : jsonNode) {
			JsonNode restaurants = apiCall.get("restaurants");
			if (restaurants == null) {
				continue;
			}
			for (JsonNode entry : restaurants) {
				String s = entry.get("restaurant").get("user_rating").get("aggregate_rating").asText();
				double rating = Double.parseDouble(s);
				total += rating;
				count++;
			}
		}
		System.out.println(total/count);
	}


}
