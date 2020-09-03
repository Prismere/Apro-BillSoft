package com.apro.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteConnection {
	Connection connection;
	public SqliteConnection()
	{
		connection = SqliteConnection.Connector();
		if(connection==null)
		{
			System.out.println("Connection Not Successful");
		
			System.exit(1);
		}
	}
	public boolean isDbConnected()
	{
		try
		{
			return !connection.isClosed();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public static Connection Connector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:testdb.sqlite");
			return conn;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public boolean isLogin(String user, String pass) throws SQLException
	{
		PreparedStatement preparedStatement=null;
		ResultSet resultset=null;
		String query="select * from login where uname = ? and pass = ?";
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			resultset=preparedStatement.executeQuery();
			if (resultset.next())
			{
				return true;
			}
				else
				{
				return false;
				}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			preparedStatement.close();
			resultset.close();
		}
	}
}
