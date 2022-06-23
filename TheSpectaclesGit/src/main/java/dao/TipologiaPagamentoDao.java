package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import model.*;


	 public class TipologiaPagamentoDao implements Model<TipologiaPagamentoBean, DataSource> {

	 	private static final String TABLE_NAME = "tipologiaPagamento";

	 	private DataSource ds;

		public void setDB(DataSource obj) {
			this.ds=obj;
		}

		public TipologiaPagamentoBean doRetrieveByKey(ArrayList<String> keys) throws SQLException {
			TipologiaPagamentoBean bean = new TipologiaPagamentoBean();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
	
	 		String selectSQL = "SELECT * FROM " + TipologiaPagamentoDao.TABLE_NAME + " WHERE CODE = ?";

	 		try {
	 			con = ds.getConnection();
				prep = con.prepareStatement(selectSQL);
				prep.setString(1, keys.get(0));
				rs = prep.executeQuery();

	 			while (rs.next()) {
	 			
	            	bean.setIdPaymentType(rs.getInt("idPayentType"));
	            	bean.setPaymentName(rs.getString("paymentName"));
	 			}

	 		} finally {
	 			rs.close();
				prep.close();
				con.close();
	 		}
	 		return bean;
		}
	
		public Collection<TipologiaPagamentoBean> doRetrieveAll(String order) throws SQLException {
			Collection<TipologiaPagamentoBean> tipologiaPagamento = new ArrayList<TipologiaPagamentoBean>();
			Connection con = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			String sql = "SELECT idPaymentType FROM " + TipologiaPagamentoDao.TABLE_NAME+" ORDER BY ?";
			/*if(order !=null && !order.equals("")) {
				sql += " ORDER BY " + order;
			}*/
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);
				prep.setString(1, order);
				rs = prep.executeQuery();
			
			while (rs.next()) {
				TipologiaPagamentoBean bean = new TipologiaPagamentoBean();
				bean.setIdPaymentType(rs.getInt("idPaymentType"));
				bean.setPaymentName(rs.getString("paymentName"));

				tipologiaPagamento.add(bean);
		}
		 } finally {
				rs.close();
				prep.close();
				con.close();
			}
			return tipologiaPagamento;
		}
		
		public void doUpdate(TipologiaPagamentoBean tipologiaPagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String sql = "UPDATE tipologiaPagamento SET idPaymentType=?, paymentName=?";

			try {
				con = ds.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, tipologiaPagamento.getIdPaymentType());
				prep.setString(2, tipologiaPagamento.getPaymentName());
			
				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doDelete(TipologiaPagamentoBean tipologiaPagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
			String deleteSQL = "DELETE FROM " + TipologiaPagamentoDao.TABLE_NAME + " WHERE CODE = ?";
			
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(deleteSQL);

				prep.setInt(1, tipologiaPagamento.getIdPaymentType());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}

		public void doSave(TipologiaPagamentoBean tipologiaPagamento) throws SQLException {
			Connection con = null;
			PreparedStatement prep = null;
		
			String insertSQL = "INSERT INTO " + TipologiaPagamentoDao.TABLE_NAME
					+ " (idPaymentType, paymentName) VALUES (?, ?)";
			try {
				con = ds.getConnection();
				prep = con.prepareStatement(insertSQL);

				prep.setInt(1, tipologiaPagamento.getIdPaymentType());
				prep.setString(2, tipologiaPagamento.getPaymentName());

				prep.executeUpdate();

			} finally {
				prep.close();
				con.close();
			}
		}
	 }