package dao;

import java.sql.SQLException;
import java.util.List;


import com.model.Properties;

public interface PropertiesDAO {
	

	List<Properties> viewAllProperties() throws SQLException;
	List<Properties> viewMyProperties(int userId) throws SQLException;
}
