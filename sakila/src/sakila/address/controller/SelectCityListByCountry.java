package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;

@WebServlet("/address/selectCityListByCountry")
public class SelectCityListByCountry extends HttpServlet {
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		cityDao = new CityDao();
		
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		System.out.println("countryId :" + countryId );
		
		List<City> list = cityDao.selectCityListByCountry(countryId);
						
		Gson gson = new Gson();
		String gsonStr = gson.toJson(list);
		response.getWriter().write(gsonStr);
		
	}
}
