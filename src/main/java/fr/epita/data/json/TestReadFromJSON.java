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
		for (JsonNode elem : jsonNode){
			System.out.println(elem.get("admin_name"));
		}

	}
}
