package com.postbook;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Properties;
import com.model.Status;
import com.model.Usersbnb;

import dao.PropertiesDAOImpl;
import dao.UsersbnbDAOImpl;

@Path("project")
public class MyResource {

///	<------------------Usersbnb------------------>

	UsersbnbDAOImpl usersbnbImpl = new UsersbnbDAOImpl();

	@Path("usersbnb/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status addUser(Usersbnb user) throws SQLException {
		return usersbnbImpl.signUp(user);
	}

	@Path("usersbnb/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usersbnb loginUser(Usersbnb user) throws SQLException {
		return usersbnbImpl.signIn(user);
	}

	@Path("usersbnb/getUser/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usersbnb getUser(@PathParam("userId") int userId) throws SQLException {
		return usersbnbImpl.viewProfile(userId);
	}

	@Path("usersbnb/updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateUser(Usersbnb user) throws SQLException {
		return usersbnbImpl.updateProfile(user);
	}

	//------------------------Properties------------------------------------------
	
		PropertiesDAOImpl propertiesdaoimpl = new PropertiesDAOImpl();

//		view all properties
		@Path("properties/allproperties")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Properties> viewAllMovies() throws SQLException{
			return propertiesdaoimpl.viewAllProperties();
		}
		
//		view my properties

		@Path("properties/myProperties/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Properties> getMyTweet(@PathParam("id") int id) throws SQLException {
			return propertiesdaoimpl.viewMyProperties(id);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	<-----------------Tweets url------------------>

//	TweetDAOImpl tweetImpl = new TweetDAOImpl();
//
//	@Path("tweets/add")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Status addTweet(Tweets tweet) throws SQLException {
//		return tweetImpl.addNewTweet(tweet);
//	}
//
//	@Path("tweets/myTweet/{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Tweets> getMyTweet(@PathParam("id") int id) throws SQLException {
//		return tweetImpl.viewMyTweet(id);
//	}
//
//	@Path("tweets/deleteTweet/{id}")
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//	public Status deleteTweet(@PathParam("id") int id) throws SQLException {
//		return tweetImpl.deleteMyTweet(id);
//	}
//
//	@Path("tweets/getAllTweet")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Tweets> getAllTweet() throws SQLException {
//		return tweetImpl.viewAllTweet();
//	}
//	
//	@Path("tweets/likes/{id}")
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//	public Likes likeTweet(@PathParam("id") int id) throws SQLException{
//		return tweetImpl.incrementLikes(id);
//	}
//	
	
	
//---------------Show All Movies----------------

//	@Path("tweets/getAllTweet")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Tweets> getAllTweet() throws SQLException {
//		return tweetImpl.viewAllTweet();
//	}
	
	
	

