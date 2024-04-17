package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Status;
import com.model.Usersbnb;

public class UsersbnbDAOImpl implements UsersbnbDAO {

	private Connection connection;

	public UsersbnbDAOImpl() {
		// TODO Load the DBUtil class
		connection = DBUtil.getConnection();
		System.out.println("User impl's connection= " + connection.hashCode());
	}
	
	
	
	
//	------------- Sign Up ------------------------------------------------------------------
	@Override
	public Status signUp(Usersbnb user) throws SQLException {
		String sql = "insert into Usersbnb (user_name,user_email,user_password,user_address,user_mobile) values(?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserEmail());
		pst.setString(3, user.getUserPassword());
		pst.setString(4, user.getUserAddress());
		pst.setString(5, user.getUserMobile());
//		pst.setString(6, user.getUserAvatar());
		pst.executeUpdate();
		Status s = new Status();
		s.setQueryStatus(true);
		return s;
	}

	
//	----------------- Sign In ---------------------------------------------------------------
	@Override
	public Usersbnb signIn(Usersbnb user) throws SQLException {
		String sql = "SELECT * FROM Usersbnb WHERE user_email = ? AND user_password = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getUserEmail());
		pst.setString(2, user.getUserPassword());

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			user = new Usersbnb(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return user;
		}

		return null;
	}

	
	
//	--------------- View Profile ---------------------------------------------------------------
	@Override
	public Usersbnb viewProfile(int userId) throws SQLException {
		String sql = "SELECT * FROM usersbnb WHERE user_id =?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, userId);
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {

			return (new Usersbnb (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7)));

		}
		return null;
	}
	
	
	
	
//	------------------------------- Update Profile -------------------------------------------------

	@Override
	public Status updateProfile(Usersbnb user) throws SQLException {
		String sql = "Update Usersbnb SET user_name=? ,user_email=?,user_address=?,user_mobile=?,user_avatar=?   where user_id=?";
		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserEmail());
		pst.setString(3, user.getUserAddress());
		pst.setString(4, user.getUserMobile());
		pst.setString(5, user.getUserAvatar());
		pst.setInt(6, user.getUserId());
		int res = pst.executeUpdate();

		return new Status((res == 1) ? true : false);
	}
		
}
