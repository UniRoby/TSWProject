package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;
import pacchetto.model.ConnectionPool;


	 public class OrdineDao {

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
		
		
		
		
		public void effettuaPagamento (String email,int metodoPagamento, Date data, int tipoSpedizione) throws SQLException {
			
			Connection con= null;
			PreparedStatement prep1= null;
			PreparedStatement prep2= null;
			PreparedStatement prep3= null;
			PreparedStatement prep4= null;
			PreparedStatement prep5= null;
			PreparedStatement prep6= null;
			String query1= "SELECT id_ordine_effettua FROM effettua WHERE id_cliente_effettua=?";
			String query2= "SELECT id_ordine_pagamento FROM pagamento";
			String query3= "SELECT prezzo_totale FROM ordine WHERE id_ordine=?";
			String query4= "SELECT iva_inserito, quantita_inserito FROM inserito WHERE id_ordine_inserito=?";
			String query5= "INSERT INTO pagamento (iva_prodotto_pagamento, info_metodo, data_pagmento, importo, quantita_pagamento, id_ordine_pagamento) VALUES (?, ?, ?, ?, ?, ?)";
			String query6= "INSERT INTO spedizione (data_spedizione, spese, info_metodo, id_ordine_spedizione) VALUES (?, ?, ?, ?)";
			ArrayList<Integer> idOrdineEffettua= new ArrayList<Integer>();
			ArrayList<Integer> idOrdinePagamento= new ArrayList<Integer>();
			ArrayList<Float> prezzoTotaleOrdine= new ArrayList<Float>();
			ArrayList<Float> ivaInserito= new ArrayList<Float>();
			ArrayList<Integer> quantitaInserito= new ArrayList<Integer>();
			ArrayList<Integer> idOrdineTemporaneo= new ArrayList<Integer>();
			
			try {
				con= ds.getConnection();
				prep1= con.prepareStatement(query1);
				prep1.setInt(1, email);
				ResultSet residOrdineEffettua= prep1.executeQuery();
				
				while (residOrdineEffettua.next()) {
					idOrdineEffettua.add(residOrdineEffettua.getInt("id_ordine_effettua"));
				}
				
				prep2= con.prepareStatement(query2);
				ResultSet residOrdinePagamento= prep2.executeQuery();
				
				while (residOrdinePagamento.next()) {
					idOrdinePagamento.add(residOrdinePagamento.getInt("id_ordine_pagamento"));
				}
				
				
				if(idOrdinePagamento.size()==0) {
					for (int i= 0; i < idOrdineEffettua.size(); i++) {
						prep3= con.prepareStatement(query3);
						prep3.setInt(1, idOrdineEffettua.get(i));
						ResultSet resPrezzoTotale= prep3.executeQuery();
						
						while (resPrezzoTotale.next()) {
							prezzoTotaleOrdine.add(resPrezzoTotale.getFloat("prezzo_totale"));
						}
						
						prep4= con.prepareStatement(query4);
						prep4.setInt(1, idOrdineEffettua.get(i));
						ResultSet resIvaQuantit= prep4.executeQuery();
						
						while (resIvaQuantit.next()) {
							ivaInserito.add(resIvaQuantit.getFloat("iva_inserito"));
							quantitaInserito.add(resIvaQuantit.getInt("quantita_inserito"));
						}
					}
					
					for (int j= 0; j < ivaInserito.size(); j++) {
						prep5= con.prepareStatement(query5);
						prep5.setFloat(1, ivaInserito.get(j));
						prep5.setString(2, "Il pagamento è avvenuto tramite carta prepagata");
						prep5.setDate(3, data);
						prep5.setFloat(4, prezzoTotaleOrdine.get(j));
						prep5.setInt(5, quantitaInserito.get(j));
						prep5.setInt(6, idOrdineEffettua.get(j));
						
						prep5.executeUpdate();
						con.commit();
						
						prep6= con.prepareStatement(query6);
						prep6.setDate(1, data);
						prep6.setFloat(2, 0);
						prep6.setString(3, "La spedizione è gratuita poichè è un servizio offerto dall'attività");
						prep6.setInt(4, idOrdineEffettua.get(j));
						
						prep6.executeUpdate();
						con.commit();
					}
				}
				
				else {
					
					for(int i= 0; i < idOrdineEffettua.size(); i++) {
						boolean trovato= false;
							for (int j= 0; j < idOrdinePagamento.size(); j++) {
							if (idOrdineEffettua.get(i) == idOrdinePagamento.get(j)) {
								trovato= true;
							}
					}
						if(trovato==false) {
							idOrdineTemporaneo.add(idOrdineEffettua.get(i));
						}
						
					}
					
					
				for (int i= 0; i < idOrdineTemporaneo.size(); i++) {
						prep3= con.prepareStatement(query3);
						prep3.setInt(1, idOrdineTemporaneo.get(i));
						ResultSet resPrezzoTotale= prep3.executeQuery();
						
						while (resPrezzoTotale.next()) {
							prezzoTotaleOrdine.add(resPrezzoTotale.getFloat("prezzo_totale"));
						}
						
						prep4= con.prepareStatement(query4);
						prep4.setInt(1, idOrdineTemporaneo.get(i));
						ResultSet resIvaQuantit= prep4.executeQuery();
						
						while (resIvaQuantit.next()) {
							ivaInserito.add(resIvaQuantit.getFloat("iva_inserito"));
							quantitaInserito.add(resIvaQuantit.getInt("quantita_inserito"));
						}
					}
					
					for (int j= 0; j < ivaInserito.size(); j++) {
						prep5= con.prepareStatement(query5);
						prep5.setFloat(1, ivaInserito.get(j));
						prep5.setString(2, "Il pagamento è avvenuto tramite carta prepagata");
						prep5.setDate(3, data);
						prep5.setFloat(4, prezzoTotaleOrdine.get(j));
						prep5.setInt(5, quantitaInserito.get(j));
						prep5.setInt(6, idOrdineTemporaneo.get(j));
						
						prep5.executeUpdate();
						con.commit();
						
						prep6= con.prepareStatement(query6);
						prep6.setDate(1, data);
						prep6.setFloat(2, 0);
						prep6.setString(3, "La spedizione è gratuita poichè è un servizio offerto dall'attività");
						prep6.setInt(4, idOrdineTemporaneo.get(j));
						
						prep6.executeUpdate();
						con.commit();
					}
					
				}
			}
			finally {
				
					if ((prep1 != null) && (prep2 != null) && (prep3 != null) && (prep4 != null) && (prep5 != null) && (prep6 != null)) {
						prep1.close();
						prep2.close();
						prep3.close();
						prep4.close();
						prep5.close();
						prep6.close();
					}
				
			}
		}
	 }