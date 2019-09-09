package com.aditya.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.ProductDao;
import com.aditya.pojo.Product;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product p = new Product();
	ProductDao pd=new ProductDao();

	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		String qty = request.getParameter("pqty");
		String image = request.getParameter("pimage");
		String category = request.getParameter("pcategory");
		String descript = request.getParameter("pdescript");

		
		p.setPName(name);
		p.setPPrice(price);
		p.setPQuantity(qty);
		p.setPImage(image);
		p.setPCategory(category);
		p.setPDescript(descript);

		boolean b = pd.addProduct(p);

		if (b) {
			response.sendRedirect("ProductList.jsp");
		} else {
			response.sendRedirect("AddProduct.jsp");
		}
	}

}