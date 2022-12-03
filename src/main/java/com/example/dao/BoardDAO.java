package com.example.dao;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class BoardDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;



	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (title, writer, nickname, number, major, department, content, category) values ("
				+ "'" +vo.getTitle() + "',"
				+ "'" +vo.getWriter() + "',"
				+ "'" +vo.getNickname() + "',"
				+ "'" +vo.getNumber() + "',"
				+ "'" +vo.getMajor() + "',"
				+ "'" +vo.getDepartment() + "',"
				+ "'" +vo.getContent() + "',"
				+ "'" +vo.getCategory() + "')";
		return jdbcTemplate.update(sql);
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq = " + seq;
		return jdbcTemplate.update(sql);
	}
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set "
				+ " title='" + vo.getTitle() + "',"
				+ " writer='" + vo.getWriter() + "',"
				+ " nickname='" + vo.getNickname() + "',"
				+ " number='" + vo.getNumber() + "',"
				+ " major='" + vo.getMajor() + "',"
				+ " department='" + vo.getDepartment() + "',"
				+ " content='" + vo.getContent() + "',"
				+ " category='" + vo.getCategory() + "' where seq=" + vo.getSeq();
		return jdbcTemplate.update(sql);
	}

	class BoardRowMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setWriter(rs.getString("writer"));
			vo.setNickname(rs.getString("nickname"));
			vo.setNumber(rs.getInt("number"));
			vo.setMajor(rs.getString("major"));
			vo.setDepartment(rs.getString("department"));
			vo.setCategory(rs.getString("category"));
			vo.setRegdate(rs.getDate("regdate"));
			return vo;
		}
	}

	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq=" + seq;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		System.out.println("getboardlist 시작~");
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}

