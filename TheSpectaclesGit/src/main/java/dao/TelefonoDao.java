package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class TelefonoDao implements Model<TelefonoBean, DataSource> {

	 	private static final String TABLE_NAME = "telefono";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public TelefonoBean doRetrieveByKey(String... key) throws SQLException {
			TelefonoBean bean = new TelefonoBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + TelefonoDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, key[0]);
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setNumPhone(rs.getLong("numPhone"));
	            	bean.setEmail(rs.getString("email"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<TelefonoBean> doRetrieveAll(String order) throws SQLException {
			Collection<TelefonoBean> telefono = new ArrayList<TelefonoBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT numPhone FROM " + TelefonoDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				TelefonoBean bean = new TelefonoBean();
				bean.setNumPhone(rs.getLong("numPhone"));
				bean.setEmail(rs.getString("email"));

				telefono.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return telefono;
		}
		
		public void doUpdate(TelefonoBean telefono) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE telefono SET numPhone=?, email=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setLong(1, telefono.getNumPhone());
				prep.setString(2, telefono.getEmail());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(TelefonoBean telefono) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE numPhone FROM " + TelefonoDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setLong(1, telefono.getNumPhone());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(TelefonoBean telefono) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + TelefonoDao.TABLE_NAME + "(numPhone, email) VALUES (?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setLong(1, telefono.getNumPhone());
				prep.setString(2, telefono.getEmail());
			

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }