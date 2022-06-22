package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class TipologiaSpedizioneDao implements Model<TipologiaSpedizioneBean, DataSource> {

	 	private static final String TABLE_NAME = "tipologiaSpedizione";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public TipologiaSpedizioneBean doRetrieveByKey(String... key) throws SQLException {
			TipologiaSpedizioneBean bean = new TipologiaSpedizioneBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + TipologiaSpedizioneDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, key[0]);
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdShipmentType(rs.getInt("idShipmentType"));
	            	bean.setShipmentName(rs.getString("shipmentName"));
	            	bean.setShipmentCost(rs.getInt("shipmentCost"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<TipologiaSpedizioneBean> doRetrieveAll(String order) throws SQLException {
			Collection<TipologiaSpedizioneBean> tipologiaSpedizione = new ArrayList<TipologiaSpedizioneBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idShipmentType FROM " + TipologiaSpedizioneDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				TipologiaSpedizioneBean bean = new TipologiaSpedizioneBean();
				bean.setIdShipmentType(rs.getInt("idShipmentType"));
				bean.setShipmentName(rs.getString("shipmentName"));
				bean.setShipmentCost(rs.getInt("shipmentCost"));

				tipologiaSpedizione.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return tipologiaSpedizione;
		}
		
		public void doUpdate(TipologiaSpedizioneBean tipologiaSpedizione) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE tipologiaSpedizione SET idShipment=?, shipmentName=?, shipmentCost=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, tipologiaSpedizione.getIdShipmentType());
				prep.setString(2, tipologiaSpedizione.getShipmentName());
				prep.setInt(3, tipologiaSpedizione.getShipmentCost());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(TipologiaSpedizioneBean bean) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + TipologiaSpedizioneDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, bean.getIdShipmentType());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(TipologiaSpedizioneBean tipologiaSpedizione) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + TipologiaSpedizioneDao.TABLE_NAME
					+ " (idShipmentType, shipmentName, shipmentCost) VALUES (?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, tipologiaSpedizione.getIdShipmentType());
				prep.setString(2, tipologiaSpedizione.getShipmentName());
				prep.setInt(3, tipologiaSpedizione.getShipmentCost());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }
