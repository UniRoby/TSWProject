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


	 public class PagamentoDao implements Model<PagamentoBean, DataSource> {

	 	private static final String TABLE_NAME = "pagamento";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public PagamentoBean doRetrieveByKey(String... key) throws SQLException {
			PagamentoBean bean = new PagamentoBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + PagamentoDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, key[0]);
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdPayment(rs.getInt("idPayment"));
	            	bean.setDate(rs.getDate("date"));
	            	bean.setIdPaymentType(rs.getInt("idPaymentType"));
	            	bean.setIdOrder(rs.getInt("idOrder"));
	            	bean.setAmount(rs.getInt("amount"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<PagamentoBean> doRetrieveAll(String order) throws SQLException {
			Collection<PagamentoBean> pagamento = new ArrayList<PagamentoBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idPayment FROM " + PagamentoDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				PagamentoBean bean = new PagamentoBean();
				bean.setIdPayment(rs.getInt("idPayment"));
				bean.setDate(rs.getDate("date"));
				bean.setIdPaymentType(rs.getInt("idPaymentType"));
				bean.setIdOrder(rs.getInt("idOrder"));
				bean.setAmount(rs.getInt("amount"));
			
				pagamento.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return pagamento;
		}
		
		public void doUpdate(PagamentoBean pagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE pagamento SET idPayment=?, date=?, idPaymentType=?, idOrder=?, amount=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, pagamento.getIdPayment());
				prep.setDate(2, pagamento.getDate(), Calendar.getInstance());
				prep.setInt(3, pagamento.getIdPaymentType());
				prep.setInt(4, pagamento.getIdOrder());
			    prep.setInt(5, pagamento.getAmount());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(PagamentoBean pagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + PagamentoDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, pagamento.getIdPayment());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(PagamentoBean pagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + PagamentoDao.TABLE_NAME + " (idPayment, date, idPaymentType, idOrder, amount) VALUES (?, ?, ?, ?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, pagamento.getIdPayment());
				prep.setDate(2, pagamento.getDate(), Calendar.getInstance());
				prep.setInt(3, pagamento.getIdPaymentType());
				prep.setInt(4, pagamento.getIdOrder());
			    prep.setInt(5, pagamento.getAmount());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }
