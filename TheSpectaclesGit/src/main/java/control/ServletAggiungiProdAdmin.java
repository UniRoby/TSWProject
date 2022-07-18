package control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.util.*;

import dao.*;
import model.*;


@WebServlet("/AggiungiProdAdmin")
@MultipartConfig (fileSizeThreshold= 1024 * 1024 * 2, maxFileSize= 1024 * 1024 * 10, maxRequestSize= 1024 * 1024 * 50)
public class ServletAggiungiProdAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	private OcchialeDao oDao= new OcchialeDao();
	
	static String UPLOAD_DIRECTORY="images\\shop\\products";
	private String extractFileName (Part pa) {
		String context= pa.getHeader("content-disposition");
		String[] item= context.split(";");
		for (String s : item) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length() - 1);
			}
		}
		return "";
	}
	public void init() throws ServletException {
		super.init();
		oDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	public ServletAggiungiProdAdmin() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Sono nella Servlet di aggiunta Occhiale");
				
		String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;
		System.out.println("\nUploadpath :"+uploadPath);
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
					
		Part part= request.getPart("img1");
		String fileName= extractFileName (part);
		part.write(uploadPath + File.separator + fileName);
		
		
		Part part2= request.getPart("img2");
		String fileName2= extractFileName (part2);	
		part2.write(uploadPath + File.separator + fileName2);
		
		
		String idOcchiale= request.getParameter("id");
		String nomeProd= request.getParameter("nome");
		String brand= request.getParameter("brand");
		int prezzo= Integer.parseInt(request.getParameter("prezzo"));
		int disp=Integer.parseInt(request.getParameter("disp"));
		String colore= request.getParameter("colore");
		String categoria= request.getParameter("categoria");
		String sex= request.getParameter("sesso");
		String desc= request.getParameter("desc");

				
		OcchialeBean prod= new OcchialeBean();
		
		prod.setIdGlasses(idOcchiale);
		prod.setNameGlasses(nomeProd);
		prod.setBrand(brand);
		prod.setPrice(prezzo);
		prod.setAvailability(disp);
		prod.setColor(colore);
		prod.setCategory(categoria);
		prod.setType(sex);
		prod.setDescription(desc);
		prod.setImage(fileName);
		if(!fileName.equals(null))
			prod.setImage2(fileName2);
		
	
		
		try {
			oDao.doSave(prod);
			

		}
		catch (SQLException e) {
			System.out.println ("Errore nella ServletAggiungiProdAdmin: " + e.getMessage());
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("PageAmministratore.jsp");
		dis.forward(request, response);
	}

}