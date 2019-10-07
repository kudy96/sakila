package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;

@WebServlet("/address/insertCity")
public class InsertCity extends HttpServlet {
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String city = request.getParameter("city");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		System.out.println("city :" + city);
		System.out.println("countryId :" + countryId);
		
		cityDao = new CityDao();
		City c = new City();
		c.setCountry(new Country());		
		c.setCity(city);
		c.getCountry().setCountryId(countryId);
		
		cityDao.insertCity(c);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(gson);
		response.getWriter().append(gsonStr);
		
	}

}
