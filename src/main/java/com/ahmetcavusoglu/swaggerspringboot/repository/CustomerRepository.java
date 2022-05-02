package com.ahmetcavusoglu.swaggerspringboot.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ahmetcavusoglu.swaggerspringboot.config.DatabaseCongfiguration;
import com.ahmetcavusoglu.swaggerspringboot.model.Customers;

@Component
public class CustomerRepository {
	
	private DatabaseCongfiguration pd ;

	public CustomerRepository(DatabaseCongfiguration pd) {
		this.pd = pd;
	}

	public List<Customers> getCustomerList() throws SQLException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		List<Customers> list = new ArrayList<Customers>();

		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM Customer ";

		try {
			st = conn.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);
			// iterate through the java resultset
			while (rs.next()) {
				Customers cs = new Customers();
				cs.setTcNo(rs.getString("tckno"));
				cs.setName(rs.getString("name"));
				cs.setSurname(rs.getString("surname"));
				cs.setPhoneNumber(rs.getString("phonenumber"));
				cs.setAddress(rs.getString("address"));
				cs.setCreatedDate(rs.getDate("createdDate"));

				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (st != null || conn != null) {
				st.close();
				rs.close();
				conn.close();
			}
		}
		return list;
	}

	public Customers getCustomer(String tckno) throws SQLException {

		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Customers cs = null;

		try {
			conn = pd.db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM Customer WHERE tckno='" + tckno + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			cs = new Customers();
			while (rs.next()) {
				cs.setTcNo(rs.getString("tckno"));
				cs.setName(rs.getString("name"));
				cs.setSurname(rs.getString("surname"));
				cs.setPhoneNumber(rs.getString("phonenumber"));
				cs.setAddress(rs.getString("address"));
				cs.setCreatedDate(rs.getDate("createdDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (st != null || conn != null || rs !=null) {
				st.close();
				rs.close();
				conn.close();
			}
		}
		return cs;
	}

	public Customers addCustomer(String tckno, String name, String surname, String phonenumber, String address)
			throws SQLException {

		
		Connection conn = null;
		PreparedStatement pr = null;
		try {
			conn = pd.db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO Customer (tckno,name,surname,phonenumber,address,createdDate) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			pr = conn.prepareStatement(sql);
			pr.setString(1, tckno);
			pr.setString(2, name);
			pr.setString(3, surname);
			pr.setString(4, phonenumber);
			pr.setString(5, address);
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pr.setDate(6, sqlDate);
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pr != null || conn != null) {
				pr.close();
				conn.close();
			}
		}
		return getCustomer(tckno);
	}
}
