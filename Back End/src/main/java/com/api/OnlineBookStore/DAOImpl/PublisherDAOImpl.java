package com.api.OnlineBookStore.DAOImpl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.api.OnlineBookStore.DAO.CategoryDAO;
import com.api.OnlineBookStore.DAO.PublisherDAO;
import com.api.OnlineBookStore.DAO.UsersDAO;
import com.api.OnlineBookStore.Model.Users;


@Repository
public class PublisherDAOImpl implements PublisherDAO {

	//@Qualifier("simpleJdbcCall1")
	
	@Autowired
	private JdbcTemplate template;
	
	private SimpleJdbcCall jdbcCall;
	
	@Override
	public Object insertPublisher(String publisherName) throws Exception {
		jdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("bookmybook").withProcedureName("insertPublisher");

		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("publisherName", publisherName);
		
		Map<String, Object> result = jdbcCall.execute(params);
		
		return result.get("#result-set-1");
	}

	@Override
	public Object updatePublisher(String publisherName, Integer id) throws Exception {
		jdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("bookmybook").withProcedureName("updatePublisher");

		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("publisherName", publisherName)
				.addValue("id", id);
		
		Map<String, Object> result = jdbcCall.execute(params);
		
		return result.get("#result-set-1");
	}

	@Override
	public Object deletePublisher(Integer id) throws Exception {
		jdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("bookmybook").withProcedureName("deletePublisher");

		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", id);
		
		Map<String, Object> result = jdbcCall.execute(params);
		
		return result.get("#result-set-1");
	}

	@Override
	public Object getPublishers() throws Exception {
		jdbcCall = new SimpleJdbcCall(template)
				.withSchemaName("bookmybook").withProcedureName("getPublishers");
		
		Map<String, Object> result = jdbcCall.execute();
		
		return result.get("#result-set-1");
	}


}
