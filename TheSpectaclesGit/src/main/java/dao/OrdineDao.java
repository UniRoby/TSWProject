package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class OrdineDao implements Model<OrdineBean, DataSource> {

	 	private static final String TABLE_NAME = "ordine";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public OrdineBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			OrdineBean bean = new OrdineBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + OrdineDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdOrder(rs.getInt("idOrder"));
	            	bean.setDate(rs.getDate("date"));
	            	bean.setEmail(rs.getString("email"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<OrdineBean> doRetrieveAll(String order) throws SQLException {
			Collection<OrdineBean> ordine = new ArrayList<OrdineBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idOrder FROM " + OrdineDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setIdOrder(rs.getInt("idOrder"));
            	bean.setDate(rs.getDate("date"));
            	bean.setEmail(rs.getString("email"));
			
				ordine.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return ordine;
		}
		
		public void doUpdate(OrdineBean ordine) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE ordine SET idOrder=?, date=?, email=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, ordine.getIdOrder());
				prep.setDate(2, ordine.getDate(), Calendar.getInstance());
				prep.setString(3, ordine.getEmail());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(OrdineBean ordine) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + OrdineDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, ordine.getIdOrder());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(OrdineBean ordine) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + OrdineDao.TABLE_NAME + "(idOrder, date, email) VALUES (?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, ordine.getIdOrder());
				prep.setDate(2, ordine.getDate(), Calendar.getInstance());
				prep.setString(3, ordine.getEmail());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }