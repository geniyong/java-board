package com.jsp.ex.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;
import java.sql.Date;

import com.jsp.ex.dto.BDto;

public class BDao {
	private DataSource dataSource;
	private static BDao dao = new BDao();
	
	private BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mariaCon");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BDao getInstance() {
		return dao;
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from mvc_board ORDER BY bGroup ASC, bIndent ASC, bStep ASC");
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Date bDate = rs.getDate("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public boolean write(String bName, String bTitle, String bContent, java.util.Date bDate, int bGroup, int bStep, int bIndent){
		boolean result = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			Date sqlBDate = new Date(bDate.getTime());
			String sql = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bGroup, bStep, bIndent) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setDate(4, sqlBDate);
			pstmt.setInt(5, bGroup);
			pstmt.setInt(6, bStep);
			pstmt.setInt(7, bIndent);
			pstmt.executeUpdate();
		} catch(Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public BDto content(int _bId) {
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = null;
			
			// UPDATE 게시글 조회수 1 증가
			sql = "UPDATE mvc_board SET bHit=bHit + 1 WHERE bId=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, _bId);
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) pstmt.close();
			}
			
			// SELECT 게시글 상세 정보 가져오기
			sql = "SELECT * FROM mvc_board WHERE bId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, _bId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Date bDate = rs.getDate("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public boolean modify(int bId, String bTitle, String bContent) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE mvc_board SET bTitle=?, bContent=? WHERE bId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
			result = true;
		} catch(Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean delete(int bId) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "DELETE FROM mvc_board WHERE bId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
			result = true;
		} catch(Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getMaxGroup(){
		int result = -1;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT MAX(bGroup) AS 'max' FROM mvc_board");
			
			while(rs.next()) {
				result = rs.getInt("max");
			}
			
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getRecentStep(int _bGroup, int _bIndent) {
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT MAX(bStep) AS 'max' FROM mvc_board Where bGroup=? and bIndent=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, _bGroup);
			pstmt.setInt(2, _bIndent);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("max");
			}
			
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
