package com.medici.arang.board.exhibitions.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.exhibitions.command.FindExhibitionsCommand;

@Repository
public class ExhibitionDao {
	private JdbcTemplate jdbcTemplate;
	
	public ExhibitionDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<FindExhibitionsCommand> findContactExgibitions() {
		String sql = "SELECT a.exhibitionTitle, a.startDate, a.endDate, b.artworkImgPath "
				+ "FROM Contact a INNER JOIN Artwork b ON a.artistId = b.artistId "
				+ "WHERE a.sendingType = 'G' AND a.accept = 'Y' GROUP BY a.contactId";
		
		return jdbcTemplate.query(sql, new RowMapper<FindExhibitionsCommand>() {

			public FindExhibitionsCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				FindExhibitionsCommand exhibitions = new FindExhibitionsCommand(
						rs.getString("exhibitionTitle"), rs.getString("startDate"),
						rs.getString("endDate"), rs.getString("artworkImgPath"));
				return exhibitions;
			}
		});
	}
}
