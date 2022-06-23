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


	 public class SpedizioneDao implements Model<SpedizioneBean, DataSource> {

	 	private static final String TABLE_NAME = "spedizione";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public SpedizioneBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			SpedizioneBean bean = new SpedizioneBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + SpedizioneDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdShipment(rs.getInt("idShipment"));
	            	bean.setDateShipment(rs.getDate("dateShipment"));
	            	bean.setIdOrder(rs.getInt("idOrder"));
	            	bean.setShipmentType(rs.getInt("shipmentType"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<SpedizioneBean> doRetrieveAll(String order) throws SQLException {
			Collection<SpedizioneBean> spedizione = new ArrayList<SpedizioneBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idShipmentType FROM " + SpedizioneDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				SpedizioneBean bean = new SpedizioneBean();
				bean.setIdShipment(rs.getInt("idShipment"));
				bean.setDateShipment(rs.getDate("DateShipment"));
				bean.setIdOrder(rs.getInt("idOrder"));
				bean.setShipmentType(rs.getInt("shipmentType"));

				spedizione.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return spedizione;
		}
		
		public void doUpdate(SpedizioneBean spedizione) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE spedizione SET idShipment=?, dateShipment=?, idOrder=?, shipmentType=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, spedizione.getIdShipment());
				prep.setDate(2, spedizione.getDateShipment(), Calendar.getInstance());
				prep.setInt(3, spedizione.getIdOrder());
				prep.setInt(4, spedizione.getShipmentType());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(SpedizioneBean bean) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + SpedizioneDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, bean.getIdShipment());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(SpedizioneBean spedizione) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + SpedizioneDao.TABLE_NAME + " (idShipment, dateShipment, idOrder, shipmentType) VALUES (?, ?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, spedizione.getIdShipment());
				prep.setDate(2, spedizione.getDateShipment(), Calendar.getInstance());
				prep.setInt(3, spedizione.getIdOrder());
				prep.setInt(4, spedizione.getShipmentType());
				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }
