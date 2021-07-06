package fr.epita.batches.marketing;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact> {


	@Override
	public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
		return null;
	}
}
