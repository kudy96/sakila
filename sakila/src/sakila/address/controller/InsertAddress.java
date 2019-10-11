package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;

@WebServlet("/address/insertAddress")
public class InsertAddress extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		addressDao = new AddressDao();
		
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalCode = request.getParameter("postalCode");
		String phone = request.getParameter("phone");
		
			System.out.println("address :" + address);
			System.out.println("address :" + address2);
			System.out.println("district :" + district);
			System.out.println("postalCode :" + postalCode);
			System.out.println("phone :" + phone);
			
		
		Address add = new Address();
		add.setAddress(address);
		add.setAddress2(address2);
		add.setDistrict(district);
		add.setPostalCode(postalCode);
		add.setPhone(phone);
		
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(add);
		response.getWriter().write(gsonStr);
		
		
	}

}
