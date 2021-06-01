package fr.epita.data.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

public class TestReadFromJSON {

	public static void main(String[] args) throws IOException {
		File file = new File("./src/main/resources/fr.json");
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(file);
		JsonNodeType nodeType = jsonNode.getNodeType();
		System.out.println(nodeType);
		int total = 0;
		int totalSize = jsonNode.size();
		for (JsonNode elem : jsonNode){
			String populationAsString = elem.get("population").asText();
			int population = 0;
			if (populationAsString!=null && !populationAsString.isEmpty()){
				population = Integer.parseInt(populationAsString);
			}
			total += population;
		}
		System.out.println("total population = " + total);
		System.out.println("average population per city = " + total/totalSize);
	}
}
