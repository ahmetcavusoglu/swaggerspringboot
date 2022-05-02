package com.ahmetcavusoglu.swaggerspringboot.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.ahmetcavusoglu.swaggerspringboot.config.DatabaseCongfiguration;
import com.ahmetcavusoglu.swaggerspringboot.model.Books;

@Component
public class BookRepository {
	
	private DatabaseCongfiguration pd ;

	public BookRepository(DatabaseCongfiguration pd) {
		this.pd = pd;
	}

	public Books getBook(String id) throws SQLException {
		
		Books book = new Books();
		
		String query = "SELECT * FROM Books WHERE id='" + id + "'";

		try (Connection conn = pd.db(); 
			 Statement st = conn.createStatement(); 
			 ResultSet rs = st.executeQuery(query)) {

			while (rs.next()) {
				book.setId(rs.getString("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setStockNumber(rs.getString("stockNumber"));
				book.setPrice(rs.getDouble("price"));
				book.setEdition(rs.getString("edition"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	public Books addBook(String id, String name, String author, String publisher, String stockNumber, double price,
			String edition) throws SQLException {

		
		Connection conn = null;
		PreparedStatement pr = null;
		try {
			conn = pd.db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO Books (id,name,author,publisher,stockNumber,price,edition) "
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setString(2, name);
			pr.setString(3, author);
			pr.setString(4, publisher);
			pr.setString(5, stockNumber);
			pr.setDouble(6, price);
			pr.setString(7, edition);
			pr.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pr != null || conn != null) {
				pr.close();
				conn.close();
			}
		}
		return getBook(id);
	}

	public Books updateStockRecords(String id, String stockNumber) throws SQLException {

		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "update Books set stockNumber = ? where id = ?";

		try {

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, stockNumber);
			preparedStmt.setString(2, id);
			preparedStmt.executeUpdate();

		} catch (SQLException excep) {
			excep.printStackTrace();
		} finally {
			if (preparedStmt != null || conn != null) {
				preparedStmt.close();
				conn.close();
			}
		}
		return getBook(id);
	}

}
