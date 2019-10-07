package sakila.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.ActorDao;
import sakila.address.model.AddressDao;
import sakila.address.model.CategoryDao;
import sakila.address.model.CityDao;
import sakila.address.model.CountryDao;
import sakila.address.model.CustomerDao;
import sakila.address.model.FilmActorDao;
import sakila.address.model.FilmCategoryDao;
import sakila.address.model.FilmDao;
import sakila.address.model.FilmTextDao;
import sakila.address.model.InventoryDao;
import sakila.address.model.LanguageDao;
import sakila.address.model.PaymentDao;
import sakila.address.model.RentalDao;
import sakila.address.model.StaffDao;
import sakila.address.model.StoreDao;


@WebServlet("/indexController")
public class IndexController extends HttpServlet {
	private CountryDao countryDao;
	private CityDao cityDao;
	private ActorDao actorDao;
	private AddressDao addressDao;
	private CategoryDao categoryDao;
	private CustomerDao customerDao;
	private FilmActorDao filmActorDao;
	private FilmCategoryDao filmCategoryDao;
	private FilmDao filmDao;
	private FilmTextDao filmTextDao;
	private LanguageDao languageDao;
	private PaymentDao paymentDao;
	private RentalDao rentalDao;
	private StaffDao staffDao;
	private InventoryDao inventoryDao;
	private StoreDao storeDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		countryDao = new CountryDao();
		int countryRow = countryDao.selectCountryCount();
		map.put("countryRow", countryRow);
		
		cityDao = new CityDao();
		int cityRow = cityDao.selectCityCount();
		map.put("cityRow", cityRow);
		
		actorDao = new ActorDao();
		int actorRow = actorDao.selectActorCount();
		map.put("actorRow", actorRow);
		
		addressDao = new AddressDao();
		int addressRow = addressDao.selectAddressCount();
		map.put("addressRow", addressRow);
		
		categoryDao = new CategoryDao();
		int categoryRow = categoryDao.selectCategoryCount();
		map.put("categoryRow", categoryRow);
		
		customerDao	= new CustomerDao();	
		int customerRow = customerDao.selectCustomerCount();
		map.put("customerRow", customerRow);
		
		filmActorDao = new FilmActorDao();
		int filmActorRow = filmActorDao.selectFilmActorCount();
		map.put("filmActorRow", filmActorRow);
		
		filmCategoryDao = new FilmCategoryDao();
		int filmCategoryRow = filmCategoryDao.selectFilmCategoryCount();
		map.put("filmCategoryRow", filmCategoryRow);
		
		filmDao = new FilmDao();
		int filmRow = filmDao.selectFilmCount();
		map.put("filmRow", filmRow);
		
		filmTextDao = new FilmTextDao();
		int filmTextRow = filmTextDao.selectFilmTextCount();
		map.put("filmTextRow", filmTextRow);
		
		languageDao = new LanguageDao();
		int languageRow = languageDao.selectLanguageCount();
		map.put("languageRow", languageRow);
		
		paymentDao = new PaymentDao();
		int paymentRow = paymentDao.selectPaymentCount();
		map.put("paymentRow", paymentRow);
		
		rentalDao = new RentalDao();
		int rentalRow = rentalDao.selectRentalCount();
		map.put("rentalRow", rentalRow);
		
		staffDao = new StaffDao();
		int staffRow = staffDao.selectStaffCount();
		map.put("staffRow", staffRow);
		
		inventoryDao = new InventoryDao();
		int inventoryRow = inventoryDao.selectInventoryCount();
		map.put("inventoryRow", inventoryRow);
		
		storeDao = new StoreDao();
		int storeRow = storeDao.selectStoreCount();
		map.put("storeRow", storeRow);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().append(jsonStr);
		
		
		
	}

}
