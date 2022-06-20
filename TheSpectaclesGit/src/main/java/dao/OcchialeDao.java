package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class OcchialeDao implements Model<OcchialeBean, DataSource> {

	 	private static final String TABLE_NAME = "occhiale";

	 	private DataSource ds;

		@Override
		public void setDB(DataSource obj) {
			// TODO Auto-generated method stub
			this.ds=obj;
		}

		@Override
		public OcchialeBean doRetrieveByKey(String... key) throws SQLException {
			OcchialeBean bean = new OcchialeBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			
	 		String selectSQL = "SELECT * FROM " + OcchialeDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, key[0]);
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	            	bean.setIdGlasses(rs.getString("idOcchiale"));
	            	bean.setNameGlasses(rs.getString("nomeOcchiale"));
	            	bean.setBrand(rs.getString("marca"));
	            	bean.setPrice(rs.getInt("prezzo"));
	            	bean.setAvailability(rs.getInt("disponibilita"));
	            	bean.setType(rs.getString("tipo").charAt(0));
	            	bean.setColor(rs.getString("colore"));
	            	bean.setIdCategory(rs.getInt("idCategoria"));
	            	bean.setImage(rs.getString("image"));
	            	bean.setDescription(rs.getString("descrizione"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}

		@Override
		public Collection<OcchialeBean> doRetrieveAll(String order, String... key) throws SQLException {
			Collection<OcchialeBean> occhiali = new ArrayList<OcchialeBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT nomeOcchiale, prezzo, img FROM " + OcchialeDao.TABLE_NAME;
			if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				OcchialeBean bean = new OcchialeBean();
				bean.setNameGlasses(rs.getString("nomeOcchiale"));
				bean.setPrice(rs.getInt("prezzo"));
				bean.setImage(rs.getString("img"));

				occhiali.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}

			return occhiali;
		}

		@Override
		public void doUpdate(OcchialeBean bean) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE occchiali SET idOcchiale=?, nomeOcchiale=?, marca=?,prezzo=?, disponibilità=?, "
					+ "tipo=?, colore=?, idCategoria=? ,img=? ,descrizione=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setString(1, bean.getIdGlasses());
				prep.setString(2, bean.getNameGlasses());
				prep.setString(3, bean.getBrand());
				prep.setInt(4, bean.getPrice());
				prep.setInt(5, bean.getAvailability());
				prep.setLong(6, bean.getType());
				prep.setString(7, bean.getColor());
				prep.setInt(8, bean.getIdCategory());
				prep.setString(9, bean.getImage());
				prep.setString(10, bean.getDescription());
				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
			
		}

		@Override
		public void doDelete(OcchialeBean bean) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + OcchialeDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setString(1, bean.getIdGlasses());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		@Override
		public void doSave(OcchialeBean occhiale) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + OcchialeDao.TABLE_NAME
					+ " (idOcchiale, nomeOcchiale, marca, prezzo,disponibilità,tipo,colore,idCategoria,img,descrizione) VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setString(1, occhiale.getIdGlasses());
				prep.setString(2, occhiale.getNameGlasses());
				prep.setString(3, occhiale.getBrand());
				prep.setInt(4, occhiale.getPrice());
				prep.setInt(5, occhiale.getAvailability() );
				//prep.setString(6, occhiale.getType());
				prep.setString(7, occhiale.getColor());
				prep.setInt(8, occhiale.getIdCategory());
				prep.setString(9, occhiale.getImage());
				prep.setString(10, occhiale.getDescription());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

	 }