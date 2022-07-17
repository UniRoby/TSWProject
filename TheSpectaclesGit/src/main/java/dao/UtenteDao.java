package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.sql.DataSource;
import java.sql.Date;
import model.*;



	 public class UtenteDao implements Model<UtenteBean, DataSource> {

	 	private static final String TABLE_NAME = "utente";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public UtenteBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			UtenteBean bean = new UtenteBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			
			String selectSQL = "SELECT * FROM " + UtenteDao.TABLE_NAME + " WHERE email = ? AND pass= ? ";


	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				prep.setString(2, keys.get(1));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	            	bean.setPass(rs.getString("pass"));
	            	bean.setRole(rs.getInt("role"));
	            	bean.setEmail(rs.getString("email"));
	            	bean.setFirstName(rs.getString("firstName"));
	            	bean.setLastName(rs.getString("lastName"));
	            	bean.setBirthday(rs.getDate("birthday"));
	 			}

	 		} 
	 		catch(Exception e) {
	 			e.printStackTrace();
	 		}
	 		finally {
	 			
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
		public UtenteBean doRetrieveByMail(String email) throws SQLException {
			UtenteBean bean = new UtenteBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			
			String selectSQL = "SELECT * FROM " + UtenteDao.TABLE_NAME + " WHERE email = ? ";


	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, email);
				
				rs = prep.executeQuery();
				
				System.out.println("Sono nel metodo doRetrieveByMail "+prep);
				
	 			while (rs.next()) {
	 				
	            	bean.setPass(rs.getString("pass"));
	            	bean.setRole(rs.getInt("role"));
	            	bean.setEmail(rs.getString("email"));
	            	bean.setFirstName(rs.getString("firstName"));
	            	bean.setLastName(rs.getString("lastName"));
	            	bean.setBirthday(rs.getDate("birthday"));
	 			}

	 		} 
	 		catch(Exception e) {
	 			e.printStackTrace();
	 		}
	 		finally {
	 			
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
		
		public IndirizziBean cercaIndirizzo(String email) throws SQLException{
			IndirizziBean indirizzo = new IndirizziBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			
			String selectSQL = "SELECT * FROM  indirizzi   WHERE email = ?";


	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, email);
				
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 				
	 				indirizzo.setEmail(rs.getString("email"));
	 				indirizzo.setAddress(rs.getString("indirizzo"));
	 				indirizzo.setCity(rs.getString("citta"));
	 				indirizzo.setCap(rs.getInt("cap"));
	 				indirizzo.setProvince(rs.getString("provincia"));
	 				
	 			}

	 		} 
	 		catch(Exception e) {
	 			e.printStackTrace();
	 		}
	 		finally {
	 			
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return indirizzo;
		}
		
		

		public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
			Collection<UtenteBean> occhiali = new ArrayList<UtenteBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT email FROM" + UtenteDao.TABLE_NAME;
		    if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				UtenteBean bean = new UtenteBean();
				bean.setEmail(rs.getString("email"));

				occhiali.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return occhiali;
		}

		public void doUpdate(UtenteBean bean) throws SQLException {
		
		}

		public void doDelete(UtenteBean bean) throws SQLException {
		
		}

		public void doSave(UtenteBean utente) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + UtenteDao.TABLE_NAME
					+ " (firstName, lastName, birthday, email,pass, role) VALUES (?, ?, ?, ?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setString(1, utente.getFirstName());
				prep.setString(2, utente.getLastName());
				prep.setDate(3, utente.getBirthday(), Calendar.getInstance());
				prep.setString(4, utente.getEmail());
				prep.setString(5, utente.getPass());
				prep.setInt(6, utente.getRole());
				
			
				
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }