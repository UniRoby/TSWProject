package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import java.util.UUID;

import model.*;

public class OcchialeOrdineDao {

	private static final String TABLE_NAME = "occhiale_ordine";

	private DataSource ds;

	public void setDB(DataSource obj) {

		this.ds = obj;

	}

	public void doSave(OcchialeOrdineBean occhialeOrdine) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME
				+ " (id_occhiale, id_ordine, prezzo_reale, iva ,quantita) VALUES(?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(insertSQL);

			ps.setString(1, occhialeOrdine.getProdotto().getIdGlasses());
			ps.setString(2, occhialeOrdine.getIdOrdine().toString());
			ps.setFloat(3, occhialeOrdine.getPrezzoEffettivo());
			ps.setFloat(4, occhialeOrdine.getIva());
			ps.setInt(5, occhialeOrdine.getQuantita());

			ps.executeUpdate();

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
	}

	public boolean doDelete(String idOcchialeOrdine) throws SQLException {
		return false;
	}

	public OcchialeOrdineBean doRetrieveByKey(String idOcchialeOrdine) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
		ArrayList<OcchialeOrdineBean> listaProdotti = new ArrayList<>();
		try {

			con = ds.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, idOcchialeOrdine);
			rs = ps.executeQuery();
			ArrayList<String> key = new ArrayList<>();

			while (rs.next()) {
				key.add(rs.getString(2));

				OcchialeBean prod = (OcchialeBean) new OcchialeDao().doRetrieveByKey(key);
				OcchialeOrdineBean prodotto = new OcchialeOrdineBean(rs.getInt(1), UUID.fromString(rs.getString(3)),
						prod, rs.getInt(4), rs.getFloat(5), rs.getInt(6));
				listaProdotti.add(prodotto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return listaProdotti.get(0);
	}

	public Collection<OcchialeOrdineBean> doRetrieveAll(String order) throws SQLException {

		Collection<OcchialeOrdineBean> occhiali = new ArrayList<OcchialeOrdineBean>();
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		ArrayList<String> key = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME;
		if (order != null && !order.equals("")) {
			query += " ORDER BY " + order;
		}

		try {
			con = ds.getConnection();
			prep = con.prepareStatement(query);
			rs = prep.executeQuery();

			while (rs.next()) {
				key.add(rs.getString(2));
				OcchialeBean prod = (OcchialeBean) new OcchialeDao().doRetrieveByKey(key);
				OcchialeOrdineBean bean = new OcchialeOrdineBean(rs.getInt(1), UUID.fromString(rs.getString(3)), prod,
						rs.getInt(4), rs.getFloat(5), rs.getInt(6));

				occhiali.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			rs.close();
			prep.close();
			con.close();
		}
		return occhiali;
	}

	/*public ArrayList<OcchialeOrdineBean> doRetrivebyOrder(OrdineBean ordine,DataSource dataS) throws SQLException {
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		ArrayList<OcchialeOrdineBean> ordini = new ArrayList<OcchialeOrdineBean>();
		ArrayList<String> key = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id_ordine = '" + ordine.getIdOrder() + "'";
     
		try {
			con = ds.getConnection();
			prep = con.prepareStatement(query);
			rs = prep.executeQuery();

			while (rs.next()) {
				
				key.add(rs.getString(2));
				OcchialeBean prod = new OcchialeBean();
				OcchialeDao oDao= new OcchialeDao();
				oDao.setDB(dataS);
				//Da modificare
				Collection<OcchialeBean> list= oDao.doRetrieveByKey(key);
				OcchialeOrdineBean bean = new OcchialeOrdineBean(rs.getInt(1), UUID.fromString(rs.getString(3)), prod,
						rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
				System.out.println("Metodo Dao: "+bean);
				ordini.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			rs.close();
			prep.close();
			con.close();
		}

		return ordini;
	}*/

	public ArrayList<OcchialeOrdineBean> doRetrivebyOrder(String ordine,DataSource data) throws SQLException {
	Connection con = null;
	PreparedStatement prep = null;
	ResultSet rs = null;
	ArrayList<OcchialeOrdineBean> ordini = new ArrayList<OcchialeOrdineBean>();
	
	String query = "SELECT * FROM " + TABLE_NAME + " WHERE id_ordine = ?";
 
	try {
		con = ds.getConnection();
		prep = con.prepareStatement(query);
		prep.setString(1, ordine);
		rs = prep.executeQuery();

		while (rs.next()) {
			/*OcchialeDao oDao= new OcchialeDao();
			oDao.setDB(data);
			OcchialeBean prod= oDao.doRetrieveOcchiale(rs.getString(2));
			System.out.println("Metodo OcchialeOrdineDao  OcchialeBean: "+prod);*/
			OcchialeOrdineBean bean = new OcchialeOrdineBean(rs.getInt(1), UUID.fromString(rs.getString("id_ordine")), rs.getString("id_occhiale"),
					rs.getInt("prezzo_reale"), rs.getFloat("iva"), rs.getInt("quantita"));
			System.out.println("Metodo OcchialeOrdineDao  doRetrivebyOrder: "+bean);
			ordini.add(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

		rs.close();
		prep.close();
		con.close();
	}
	System.out.println("tutti gli ordini doRetrivebyOrder: "+ordini);
	return ordini;
}

}
