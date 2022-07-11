package dao;

import java.sql.Connection;
import java.util.Date;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import model.*;



	 public class OrdineDao {

	 	private static final String TABLE_NAME = "ordine";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}
		public void doSave(OrdineBean ordine) throws SQLException {
			OrdineBean bean = new OrdineBean();
			Connection con = null;
			PreparedStatement prep = null;
			
			String query =
					"INSERT INTO " +
					TABLE_NAME +
					" (idOrdine, email, data, stato)" +
					" VALUES (?,?,CURRENT_TIMESTAMP(),?)";

			try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(query);
				prep.setString(1, ordine.getIdOrder().toString());
				prep.setString(2, ordine.getEmail());
				prep.setString(3, ordine.getStato());
				prep.executeUpdate();
				
				
	 			

	 		} finally {
				try {
					if (prep != null)
						prep.close();
				} finally {
					if (con != null)
						con.close();
				}
			}
	 	
		}
		
		public OrdineBean doRetrieveByKey(UUID idOrdine) throws SQLException {
			OrdineBean bean = new OrdineBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + OrdineDao.TABLE_NAME + " WHERE idOrdine = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, idOrdine.toString());
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	 				bean.setIdOrder(UUID.fromString(rs.getString(1)));
	 				bean.setDate(new Date(rs.getTimestamp(3).getTime()));
	 				bean.setEmail(rs.getString(2));
	 				bean.setStato(rs.getString(4));
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
			String sql = "SELECT idOrdine FROM " + OrdineDao.TABLE_NAME;
			if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setIdOrder(UUID.fromString(rs.getString(1)));
				bean.setEmail(rs.getString(2));
				bean.setDate(new Date(rs.getTimestamp(3).getTime()));
				bean.setStato(rs.getString(4));
			
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
			String sql = "UPDATE ordine SET idOrder=?,  email=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setString(1, ordine.getIdOrder().toString());
				prep.setString(2, ordine.getEmail());
			
				prep.executeUpdate();
				con.commit();

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

				prep.setString(1, ordine.getIdOrder().toString());

				prep.executeUpdate();
				con.commit();

			} finally {
				prep.close();
				con.close();
			}
		}

		public ArrayList<OrdineBean> doRetriveByUser(UtenteBean user, String order) throws SQLException {
				
				ArrayList<OrdineBean> ordine = new ArrayList<OrdineBean>();
				Connection con = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				String query = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";
				if (order != null) {
					query += " ORDER BY " + order;
				}
				try {
					con = ds.getConnection();
					prep = con.prepareStatement(query);
					prep.setString(1, user.getEmail());
					rs = prep.executeQuery();
					while (rs.next()) {
						OrdineBean bean = new OrdineBean();
						bean.setIdOrder(UUID.fromString(rs.getString(1)));
						bean.setEmail(rs.getString(3));
						bean.setDate(new Date(rs.getTimestamp(2).getTime()));
						bean.setStato(rs.getString(4));
					
						ordine.add(bean);
					}
					
				} finally {
					prep.close();
					con.close();
				}
	
				return ordine;
			}
		
		public ArrayList<OrdineBean> doRetriveByDate(Date init, Date end, int skip, int limit)
				throws SQLException {
				ArrayList<OrdineBean> ordine = new ArrayList<OrdineBean>();
				Connection con = null;
				PreparedStatement prep = null;
				ResultSet rs = null;
				String query =
					"SELECT * FROM " +
					TABLE_NAME +
					" WHERE _data >= ? AND _data <= ? ORDER BY _data DESC LIMIT ?, ?"; // LIMIT skip, limit
				try {
					con = ds.getConnection();
					prep = con.prepareStatement(query);
					prep.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(init));
					prep.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(end) + " 23:59:59");
					prep.setInt(3, skip);
					prep.setInt(4, limit);
					rs = prep.executeQuery();
					while (rs.next()) {
						OrdineBean bean = new OrdineBean();
						bean.setIdOrder(UUID.fromString(rs.getString(1)));
						bean.setEmail(rs.getString(3));
						bean.setDate(new Date(rs.getTimestamp(2).getTime()));
						bean.setStato(rs.getString(4));
					
						ordine.add(bean);
					}
					
				} finally {
					prep.close();
					con.close();
				}
	
				return ordine;
				

			}

		
		
		
		
	 }