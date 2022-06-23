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


	 public class ContieneDao implements Model<ContieneBean, DataSource> {

	 	private static final String TABLE_NAME = "contiene";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public ContieneBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			ContieneBean bean = new ContieneBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + ContieneDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdOrder(rs.getInt("idOrder"));
	            	bean.setIdGlasses(rs.getString("idGlasses"));
	            	bean.setQuantity(rs.getInt("quantity"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<ContieneBean> doRetrieveAll(String order) throws SQLException {
			Collection<ContieneBean> contiene = new ArrayList<ContieneBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idOrder FROM " + ContieneDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				
				rs = prep.executeQuery();
			
			while (rs.next()) {
				ContieneBean bean = new ContieneBean();
				bean.setIdOrder(rs.getInt("idOrder"));
            	bean.setIdGlasses(rs.getString("idGlasses"));
            	bean.setQuantity(rs.getInt("quantity"));
			
				contiene.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return contiene;
		}
		
		public void doUpdate(ContieneBean contiene) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE contiene SET idOrder=?, idGlasses=?, quantity=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, contiene.getIdOrder());
				prep.setString(2, contiene.getIdGlasses());
				prep.setInt(3, contiene.getQuantity());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(ContieneBean contiene) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + ContieneDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, contiene.getIdOrder());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(ContieneBean contiene) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + ContieneDao.TABLE_NAME + "(idOrder, idGlasses, quantity) VALUES (?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, contiene.getIdOrder());
				prep.setString(2, contiene.getIdGlasses());
				prep.setInt(3, contiene.getQuantity());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }