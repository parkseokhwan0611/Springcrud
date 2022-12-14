package com.example.dao;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;
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
	SqlSession sqlSession;



	public int insertBoard(BoardVO vo) {
		int count = sqlSession.insert("Board.insertBoard", vo);
		return count;
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		int count = sqlSession.delete("Board.deleteBoard", seq);
		return count;
	}
	public int updateBoard(BoardVO vo) {
		int count = sqlSession.update("Board.updateBoard", vo);
		return count;
	}
	public BoardVO getBoard(int seq) {
		BoardVO one = sqlSession.selectOne("Board.getBoard", seq);
		return one;
	}

	public List<BoardVO> getBoardList(){
		List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
		return list;
	}
}

