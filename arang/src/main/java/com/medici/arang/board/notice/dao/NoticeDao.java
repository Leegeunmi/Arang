package com.medici.arang.board.notice.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.notice.command.NoticeCommand;
import com.medici.arang.board.notice.domain.NoticeRowMapper;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class NoticeDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NoticeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insertNotice(NoticeCommand command) {
		String sql = "INSERT INTO notice (title, writer, content, readCnt) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, command.getTitle(), command.getWriter(), 
				command.getContent(), command.getReadCnt());
	}
	public long updateNotice(NoticeCommand command, long num) {
		String sql = "UPDATE notice SET title = ?, content = ? WHERE num = ?";
		return jdbcTemplate.update(sql, command.getTitle(), command.getContent(), num);
	}
	public long deleteNotice(long num) {
		String sql = "DELETE FROM notice WHERE num = ?";
		return jdbcTemplate.update(sql ,num);
	}
	public List<NoticeCommand> findAllNotice(){
		String sql = "SELECT * FROM notice";
		return jdbcTemplate.query(sql, new NoticeRowMapper());
	}
	public List<NoticeCommand> findOneNotice(long num) {
		NoticeCount(num);
		String sql = "SELECT * FROM notice WHERE num =?";
		return jdbcTemplate.query(sql, new NoticeRowMapper(), num);
	}
	public long NoticeCount(long num) {
		String sql = "UPDATE notice SET readCnt = readCnt + 1 WHERE num = ?";
		return jdbcTemplate.update(sql, num);
	}
	
	public List<NoticeCommand> paging(long num){
		String sql = "SELECT * FROM (SELECT @rownum := @rownum + 1 as rownum,"
				+ " t.* from notice t, (select @rownum := 0) tmp "
				+ "order by num = ? desc) as rownum_table limit 1, 20";
		return jdbcTemplate.query(sql, new NoticeRowMapper(), num);
	}
	
	//COUNT
	public long getCount() {
		String sql = "SELECT COUNT(*) FROM notice";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	//페이지 보여줄 수, 페이지 전체 사이즈, Pageable(페이지를 나누는 기준)
	public Page<NoticeCommand> findAll(Pageable pageable){

		Order order = pageable.getSort().isEmpty()
				? Order.by("num")
				: pageable.getSort().toList().get(0);
		String sql = "SELECT num, title, writer, content, readCnt, regDate"					
				+ " FROM notice "
				+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
				//MY SQL
				+ " LIMIT " + pageable.getPageSize()
				+ " OFFSET " + pageable.getOffset();
			
		return new PageImpl<NoticeCommand>(
				jdbcTemplate.query(sql, new NoticeRowMapper()), pageable, getCount());	
	}
		
		//검색 기능(제목)
		public Page<NoticeCommand> findAllbyTitle(Pageable pageable, String title){
			Order order = pageable.getSort().isEmpty()
					? Order.by("num")
					: pageable.getSort().toList().get(0);
			String sql = "SELECT num, title, writer, content, readCnt, regDate"					
					+ " FROM notice"
					+ " WHERE title like ?"
					+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
					//MY SQL
					+ " LIMIT " + pageable.getPageSize()
					+ " OFFSET " + pageable.getOffset();
			String Keyword = "%" + title + "%";
			return new PageImpl<NoticeCommand>(
					jdbcTemplate.query(sql, new NoticeRowMapper(), Keyword),
					pageable,
					getCount());
			}
		
		//검색 기능(글쓴이)
			public Page<NoticeCommand> findAllbyWriter(Pageable pageable, String writer){
				Order order = pageable.getSort().isEmpty()
						? Order.by("num")
						: pageable.getSort().toList().get(0);
				String sql = "SELECT num, title, writer, content, readCnt, regDate"					
						+ " FROM notice"
						+ " WHERE writer like ?"
						+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
						//MY SQL
						+ " LIMIT " + pageable.getPageSize()
						+ " OFFSET " + pageable.getOffset();
				String Keyword = "%" + writer + "%";
				return new PageImpl<NoticeCommand>(
						jdbcTemplate.query(sql, new NoticeRowMapper(), Keyword),
						pageable,
						getCount());
				}
}
