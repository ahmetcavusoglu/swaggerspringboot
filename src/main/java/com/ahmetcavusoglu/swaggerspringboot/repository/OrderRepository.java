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
import com.ahmetcavusoglu.swaggerspringboot.model.Orders;

@Component
public class OrderRepository {

//	@Autowired
//	private DataSource datasource;

	private DatabaseCongfiguration pd;

	public OrderRepository(DatabaseCongfiguration pd) {
		this.pd = pd;
	}

	public Orders getOrderDetails(String orderid) throws SQLException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Orders order = null;
		try {
			// conn = datasource.getConnection();
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM Orders WHERE id='" + orderid + "'";

		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(query);
			order = new Orders();
			while (rs.next()) {
				order.setId(rs.getString("id"));
				order.setCustomerTcknNo(rs.getString("customerTcknNo"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setSalesTax(rs.getDouble("salesTax"));
				order.setTotal(rs.getDouble("total"));
				order.setBookId(rs.getString("bookId"));
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
		return order;
	}

	public Orders addOrder(String id, String customerTcknNo, double total, String bookId) throws SQLException {

		Connection conn = null;
		PreparedStatement pr = null;
		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO Orders (id,orderDate,customerTcknNo,salesTax,total,bookId) " + "VALUES (?,?,?,?,?,?)";

		try {

			pr = conn.prepareStatement(sql);

			pr.setString(1, id);
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pr.setDate(2, sqlDate);
			pr.setString(3, customerTcknNo);
			pr.setDouble(4, calculateSalesTax(total));
			pr.setDouble(5, total);
			pr.setString(6, bookId);

			pr.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pr != null || conn != null) {
				conn.close();
			}
		}
		return getOrder(id);
	}

	public double calculateSalesTax(double total) {

		double salesTax = (total * 8) / 100;
		System.out.println(salesTax);
		return salesTax;
	}

	public Orders getOrder(String id) throws SQLException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Orders order = null;

		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM Orders WHERE id='" + id + "'";

		try {
			// create the java statement
			st = conn.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);
			order = new Orders();
			while (rs.next()) {
				order.setId(rs.getString("id"));
				order.setCustomerTcknNo(rs.getString("customerTcknNo"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setSalesTax(rs.getDouble("salesTax"));
				order.setTotal(rs.getDouble("total"));
				order.setBookId(rs.getString("bookId"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (st != null || conn != null || rs != null) {
				st.close();
				rs.close();
				conn.close();
			}
		}
		return order;
	}

	public List<Orders> getOrderOfCustomer(String customerTcknNo) throws SQLException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Orders> list = new ArrayList<Orders>();

		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM Orders WHERE customerTcknNo='" + customerTcknNo + "'";

		try {
			// create the java statement
			st = conn.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);
			// iterate through the java resultset

			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getString("id"));
				order.setCustomerTcknNo(rs.getString("customerTcknNo"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setSalesTax(rs.getDouble("salesTax"));
				order.setTotal(rs.getDouble("total"));
				order.setBookId(rs.getString("bookId"));

				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null || conn != null || rs != null) {
				st.close();
				rs.close();
				conn.close();
			}
		}
		return list;
	}

	public List<Orders> getOrderList() throws SQLException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		List<Orders> list = new ArrayList<Orders>();
		try {
			conn = pd.db();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * FROM Orders ";

		try {
			// create the java statement
			st = conn.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);
			// iterate through the java resultset

			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getString("id"));
				order.setCustomerTcknNo(rs.getString("customerTcknNo"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setSalesTax(rs.getDouble("salesTax"));
				order.setTotal(rs.getDouble("total"));
				order.setBookId(rs.getString("bookId"));

				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null || conn != null || rs != null) {
				st.close();
				rs.close();
				conn.close();
			}
		}
		return list;
	}

}
