package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.model.Properties;

public class PropertiesDAOImpl implements PropertiesDAO {
	
	private Connection connection;
	
	public PropertiesDAOImpl() {
		connection = DBUtil.getConnection();
	}

	@Override
	public List<Properties> viewAllProperties() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select * from properties";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Properties> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new Properties(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9)));
		}
		
		return list;
	}

	@Override
	public List<Properties> viewMyProperties(int userId) throws SQLException {
			String sql = "SELECT usersbnb.user_id, property_title, property_location, property_city, property_price, property_description, property_image, property_type FROM properties INNER JOIN usersbnb ON usersbnb.user_id = properties.user_id WHERE usersbnb.user_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			List<Properties> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Properties(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			return list;

		}
	}

	
	

