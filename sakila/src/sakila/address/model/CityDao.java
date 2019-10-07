package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class CityDao {
	public List<City> selectCityList(int currentPage){
		List<City> list = new ArrayList<City>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int rowPerPage = 10;
		int beginRow = (currentPage-1) * rowPerPage;
		
		String sql = "select ci.city_id, ci.city, co.country, co.country_id, ci.last_update from city ci inner join country co on ci.country_id = co.country_id order by city_id desc limit ?,?";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				City city = new City();
				city.setCountry(new Country());
				city.setCityId(rs.getInt("ci.city_id"));
				city.setCity(rs.getString("ci.city"));
				city.getCountry().setCountry(rs.getString("co.country"));
				city.getCountry().setCountryId(rs.getInt("co.country_id"));
				city.setLastUpdate(rs.getString("ci.last_update"));			
				list.add(city);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);			
		}
		return list;
		
	}
	public int selectCityCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from city";
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
