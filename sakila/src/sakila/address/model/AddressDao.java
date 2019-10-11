package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class AddressDao {
		
	public int insertAddress(Connection conn,Address add) throws Exception{
		int addressId = 0;
		//Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into address(address, address2, district, city_id, postal_code, phone, last_update ) values(?,?,?,?,?,?,now())";
			//conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//입력한 행에 대한 프라이머리 키값
			stmt.setString(1, add.getAddress());
			stmt.setString(2, add.getAddress2());
			stmt.setString(3, add.getDistrict());
			stmt.setInt(4, add.getCity().getCityId());
			stmt.setString(5, add.getPostalCode());
			stmt.setString(6, add.getPhone());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				addressId = rs.getInt(1);
			}
		
		return addressId;
	}
	
	
	public List<Address> selectAddressList(){
		List<Address> list = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select co.country, ci.city, ad.address_id, ad.address, ad.address2, ad.district, ad.postal_code, ad.phone, ad.last_update\r\n" + 
				" from address ad inner join city ci inner join country co on ad.city_id = ci.city_id and ci.country_id = co.country_id\r\n" + 
				" order by ad.address_id desc";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Address address = new Address();
				address.setCity(new City());
				address.getCity().setCountry(new Country());
				address.getCity().getCountry().setCountry(rs.getString("co.country"));				
				address.getCity().setCity(rs.getString("ci.city"));
				address.setAddressId(rs.getInt("ad.address_id"));
				address.setAddress(rs.getString("ad.address"));
				address.setAddress2(rs.getString("ad.address2"));
				address.setDistrict(rs.getString("ad.district"));
				address.setPostalCode(rs.getString("ad.postal_code"));
				address.setPhone(rs.getString("ad.phone"));
				address.setLastUpdate(rs.getString("ad.last_update"));
				list.add(address);				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);			
		}
		return list;
	}
	
	public int selectAddressCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from address";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
