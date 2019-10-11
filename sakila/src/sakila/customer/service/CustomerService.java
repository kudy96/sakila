package sakila.customer.service;

import java.sql.*;
import sakila.address.model.*;
import sakila.db.DBHelper;


public class CustomerService {
	private AddressDao addressDao;
	private CustomerDao customerDao;
	public void insertCustomer(Address add, Customer customer) {	
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			addressDao = new AddressDao();
			int addressId = addressDao.insertAddress(conn, add);
			customer.setAddress(new Address());
			customer.getAddress().setAddressId(addressId);
			
			customerDao = new CustomerDao();
			customerDao.insertCustomer(conn ,customer);		
			conn.commit();
		}catch(Exception e) {
			try {conn.rollback();} 
			catch(SQLException e1) {}
			e.printStackTrace();		
		}finally {
			DBHelper.close(null, null, conn);
		}
	
	}
}
