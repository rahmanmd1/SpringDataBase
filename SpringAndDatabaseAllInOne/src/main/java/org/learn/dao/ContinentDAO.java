package org.learn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.learn.beans.Continent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("continentDAO")
public class ContinentDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	//===== Query 
	public List<Continent> getAllContinents() {

		return jdbcTemplate.query("select * from continent", new RowMapper<Continent>() {

			@Override
			public Continent mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

				Continent continent = new Continent();
				continent.setId(resultSet.getInt("id"));
				continent.setName(resultSet.getString("name"));
				return continent;
			}

		}

		);

	}

	/***
	 * 
	 * Query for single continent using ID ( Named param example)
	 * 
	 * @param id
	 * @return
	 */
	public Continent getContinent(int id) {

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbcTemplate.queryForObject("select * from continent where id=:id", parameters,
				new RowMapper<Continent>() {

					@Override
					public Continent mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

						Continent continent = new Continent();
						continent.setId(resultSet.getInt("id"));
						continent.setName(resultSet.getString("name"));
						return continent;
					}

				}

		);

	}

	// ====== DELETE =====

	/***
	 * 
	 * delete using id
	 * 
	 * @param id
	 * @return : number of row affected.
	 * 
	 */
	public int delete(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbcTemplate.update("delete from continent where id= :id", parameters);

	}

	// ====== CREATE =====

	public boolean create(Continent continent) {

		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(continent);

		return jdbcTemplate.update("insert into continent (name) values (:name)", parameterSource) == 1;

	}

	public int[] createBatch(List<Continent> continents) {

		SqlParameterSource[] createBatchParameterSource = SqlParameterSourceUtils.createBatch(continents.toArray());
		return jdbcTemplate.batchUpdate("insert into continent (name) values (:name)", createBatchParameterSource);

	}
	
	@Transactional() //== Please play with different parameters
	public int[] createBatchWithTransaction(List<Continent> continents) {

		SqlParameterSource[] createBatchParameterSource = SqlParameterSourceUtils.createBatch(continents.toArray());
		return jdbcTemplate.batchUpdate("insert into continent (id,name) values (:id,:name)", createBatchParameterSource);

	}

	// ===== UPDATE Single row =====

	public boolean update(Continent continent) {

		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(continent);

		return jdbcTemplate.update("update continent set name=:name where id=:id", parameterSource) == 1;

	}

}
