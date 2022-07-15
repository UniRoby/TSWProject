package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class PrezzoDao implements Model<PrezzoBean, DataSource> {

	 	private static final String TABLE_NAME = "prezzo";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public PrezzoBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			PrezzoBean bean = new PrezzoBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + PrezzoDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdPrezzo(rs.getInt("idPrezzo"));
	            	bean.setPrezzo(rs.getInt("prezzo"));
	            	bean.setIva(rs.getInt("iva"));
	            	bean.setIdOcchiale(rs.getString("idOcchiale"));
	            	bean.setData(rs.getDate("idOcchiale"));
	            	bean.setTotalPrice(rs.getFloat("prezzoTotale"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<PrezzoBean> doRetrieveAll(String order) throws SQLException {
			Collection<PrezzoBean> Prezzo = new ArrayList<PrezzoBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idShipmentType FROM " + PrezzoDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				PrezzoBean bean = new PrezzoBean();
				bean.setIdPrezzo(rs.getInt("idPrezzo"));
            	bean.setPrezzo(rs.getInt("prezzo"));
            	bean.setIva(rs.getInt("iva"));
            	bean.setIdOcchiale(rs.getString("idOcchiale"));
            	bean.setData(rs.getDate("idOcchiale"));
            	bean.setTotalPrice(rs.getFloat("prezzoTotale"));

				Prezzo.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return Prezzo;
		}
		
		public void doUpdate(PrezzoBean Prezzo) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE Prezzo SET idPrezzo=?, prezzo=?, iva=?, idOcchiale=?, data=?, totalPrice=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, Prezzo.getIdPrezzo());
				prep.setInt(2, Prezzo.getPrezzo());
				prep.setInt(3, Prezzo.getIva());
				prep.setString(4, Prezzo.getIdOcchiale());
				prep.setDate(5, Prezzo.getData());
				prep.setFloat(6, Prezzo.getTotalPrice());

				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(PrezzoBean bean) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + PrezzoDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, bean.getIdPrezzo());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(PrezzoBean Prezzo) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + PrezzoDao.TABLE_NAME
					+ " (idPrezzo, prezzo, iva, idOcchiale, data, totalPrice) VALUES (?, ?, ?, ?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, Prezzo.getIdPrezzo());
				prep.setInt(2, Prezzo.getPrezzo());
				prep.setInt(3, Prezzo.getIva());
				prep.setString(4, Prezzo.getIdOcchiale());
				prep.setDate(5, Prezzo.getData());
				prep.setFloat(6, Prezzo.getTotalPrice());
				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }