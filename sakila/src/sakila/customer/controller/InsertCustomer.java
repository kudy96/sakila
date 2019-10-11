package sakila.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Address;
import sakila.address.model.City;
import sakila.address.model.Customer;
import sakila.address.model.Store;
import sakila.customer.service.CustomerService;

@WebServlet("/customer/insertCustomer")
public class InsertCustomer extends HttpServlet {
	
	private CustomerService customerService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		//address -> request..
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String district = request.getParameter("district");
		String postalCode = request.getParameter("postalCode");
		String phone = request.getParameter("phone");
		System.out.println("address :"+address);
		System.out.println("address2 :"+address2);
		System.out.println("district :"+district);
		System.out.println("postalCode :"+postalCode);
		System.out.println("phone :"+phone);
		
		//customer -> request...
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String eMail = request.getParameter("eMail");	
			System.out.println("firstName :"+firstName);
			System.out.println("lastName :"+lastName);
			System.out.println("eMail :"+eMail);
			
		Address add = new Address();
		add.setCity(new City());		
		add.setAddress(address);
		add.setAddress2(address2);
		add.setDistrict(district);
		add.setPostalCode(postalCode);
		add.setPhone(phone);
		add.getCity().setCityId(Integer.parseInt(request.getParameter("cityId")));
					
		Customer customer = new Customer();
		customer.setStore(new Store());
		customer.getStore().setStoreId(Integer.parseInt(request.getParameter("storeId")));
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.seteMail(eMail);
		
		customerService = new CustomerService();
		customerService.insertCustomer(add, customer);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(gson);
		response.getWriter().append(gsonStr);
		
	}

}
