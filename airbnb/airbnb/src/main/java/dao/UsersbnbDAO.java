package dao;

import java.sql.SQLException;

import com.model.Status;
import com.model.Usersbnb;

public interface UsersbnbDAO {
	Status signUp(Usersbnb user) throws SQLException;

	Usersbnb signIn(Usersbnb user) throws SQLException;

	Usersbnb viewProfile(int userId) throws SQLException;

	Status updateProfile(Usersbnb user) throws SQLException;
}
