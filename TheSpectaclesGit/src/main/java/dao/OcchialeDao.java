package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class OcchialeDao {

	 	private static final String TABLE_NAME = "occhiale";

	 	private DataSource ds;

		public void setDB(DataSource obj) {

			this.ds=obj;
			
		}

		public Collection<OcchialeBean> doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			OcchialeBean bean = new OcchialeBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			Collection<OcchialeBean> occhiali = new ArrayList<OcchialeBean>();
	 		String sql = "SELECT * FROM " + OcchialeDao.TABLE_NAME + " WHERE categoria = ?";
	 		

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1,keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	            	bean.setIdGlasses(rs.getString("idOcchiale"));
	            	bean.setNameGlasses(rs.getString("nomeOcchiale"));
	            	bean.setBrand(rs.getString("marca"));
	            	bean.setPrice(rs.getInt("prezzo"));
	            	bean.setAvailability(rs.getInt("disponibilita"));
	            	bean.setType(rs.getString("tipo").charAt(0));
	            	bean.setColor(rs.getString("colore"));
	            	bean.setCategory(rs.getString("categoria"));
	            	bean.setImage(rs.getString("img"));
	            	bean.setDescription(rs.getString("descrizione"));
	            	System.out.println("\nSono nel while: "+ bean);
	            	occhiali.add(bean);
	 			}

	 		} 
		    catch(Exception e){
			  e.printStackTrace();
			} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return occhiali;
		}
		
		public OcchialeBean singleProduct (ArrayList<String> keys) throws SQLException {
			OcchialeBean bean = new OcchialeBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			
	 		String sql = "SELECT * FROM " + OcchialeDao.TABLE_NAME + " WHERE idOcchiale = ?";
	 		
	 		System.out.println("Sono nel metodo del dao: "+ keys.get(0));
	 		

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1,keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	            	bean.setIdGlasses(rs.getString("idOcchiale"));
	            	bean.setNameGlasses(rs.getString("nomeOcchiale"));
	            	bean.setBrand(rs.getString("marca"));
	            	bean.setPrice(rs.getInt("prezzo"));
	            	bean.setAvailability(rs.getInt("disponibilita"));
	            	bean.setType(rs.getString("tipo").charAt(0));
	            	bean.setColor(rs.getString("colore"));
	            	bean.setCategory(rs.getString("categoria"));
	            	bean.setImage(rs.getString("img"));
	            	bean.setDescription(rs.getString("descrizione"));
	            	System.out.println("\nSono nel while: "+ bean);
	 			}

	 		} 
		    catch(Exception e){
			  e.printStackTrace();
			} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		System.out.println("OCchiale: \n "+ bean+ "\n");
	 		return bean;
		}
		

	
		public Collection<OcchialeBean> doRetrieveAll(String order) throws SQLException {
			Collection<OcchialeBean> occhiali = new ArrayList<OcchialeBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM " + OcchialeDao.TABLE_NAME;
			if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				OcchialeBean bean = new OcchialeBean();

            	bean.setIdGlasses(rs.getString("idOcchiale"));
            	bean.setNameGlasses(rs.getString("nomeOcchiale"));
            	bean.setBrand(rs.getString("marca"));
            	bean.setPrice(rs.getInt("prezzo"));
            	bean.setAvailability(rs.getInt("disponibilita"));
            	bean.setType(rs.getString("tipo").charAt(0));
            	bean.setColor(rs.getString("colore"));
            	bean.setCategory(rs.getString("categoria"));
            	bean.setImage(rs.getString("img"));
            	bean.setDescription(rs.getString("descrizione"));

				occhiali.add(bean);
		}
		 }
			catch(Exception e){
			  e.printStackTrace();
			}
				finally {
			
			 
				rs.close();
				prep.close();
				con.close();
			}
			return occhiali;
		}
		
		public void doUpdate(OcchialeBean occhiale) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE occhiale SET idOcchiale=?, nomeOcchiale=?, marca=?,prezzo=?, disponibilità=?, "
					+ "tipo=?, colore=?, idCategoria=? ,img=? ,descrizione=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setString(1, occhiale.getIdGlasses());
				prep.setString(2, occhiale.getNameGlasses());
				prep.setString(3, occhiale.getBrand());
				prep.setInt(4, occhiale.getPrice());
				prep.setInt(5, occhiale.getAvailability());
				prep.setLong(6, occhiale.getType());
				prep.setString(7, occhiale.getColor());
				prep.setString(8, occhiale.getCategory());
				prep.setString(9, occhiale.getImage());
				prep.setString(10, occhiale.getDescription());
				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(OcchialeBean occhiale) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + OcchialeDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setString(1, occhiale.getIdGlasses());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

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
				prep.setString(8, occhiale.getCategory());
				prep.setString(9, occhiale.getImage());
				prep.setString(10, occhiale.getDescription());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }