package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class IndirizziDao implements Model<IndirizziBean, DataSource> {

	 	private static final String TABLE_NAME = "indirizzo";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public IndirizziBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			IndirizziBean bean = new IndirizziBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + IndirizziDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	            	bean.setIdIndirizzo(rs.getInt("idIndirizzo"));
	            	bean.setAddress(rs.getString("address"));
	            	bean.setStatus(rs.getBoolean("status"));
	            	bean.setCity(rs.getString("city"));
	            	bean.setProvince(rs.getString("province"));
	            	bean.setCap(rs.getInt("cap"));
	            	bean.setEmail(rs.getString("email"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<IndirizziBean> doRetrieveAll(String order) throws SQLException {
			Collection<IndirizziBean> indirizzi = new ArrayList<IndirizziBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idIndirizzo FROM " + IndirizziDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				IndirizziBean bean = new IndirizziBean();
				bean.setIdIndirizzo(rs.getInt("idIndirizzo"));
				
				indirizzi.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return indirizzi;
		}
		
		public void doUpdate(IndirizziBean indirizzo) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE indirizzo SET idIndirizzo=?, address=?, status=?, city=?, province=?, cap=?, email=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, indirizzo.getIdIndirizzo());
				prep.setString(2, indirizzo.getAddress());
				prep.setBoolean(3, indirizzo.getStatus());
				prep.setString(4, indirizzo.getCity());
				prep.setString(5, indirizzo.getProvince());
				prep.setInt(6, indirizzo.getCap());
				prep.setString(7, indirizzo.getEmail());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(IndirizziBean indirizzo) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + IndirizziDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, indirizzo.getIdIndirizzo());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(IndirizziBean indirizzo) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + IndirizziDao.TABLE_NAME
					+ " (idIndirizzo, address, status, city, province, cap, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, indirizzo.getIdIndirizzo());
				prep.setString(2, indirizzo.getAddress());
				prep.setBoolean(3, indirizzo.getStatus());
				prep.setString(4, indirizzo.getCity());
				prep.setString(5, indirizzo.getProvince());
				prep.setInt(6, indirizzo.getCap());
				prep.setString(7, indirizzo.getEmail());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }