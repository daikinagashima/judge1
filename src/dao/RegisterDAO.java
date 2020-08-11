package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Login;
import model.User;


public class RegisterDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean create(User user) {
		try (
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {

            String sql = "INSERT INTO USER(NAME,PASS) VALUES(?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);

            pStmt.setString(1, user.getName());
            pStmt.setString(2, user.getPass());

            int result = pStmt.executeUpdate();
            if(result != 1) {
            	return false;
            }


        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
		return true;

	}
	public boolean findName(String name) {
		try  {Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);


			String sql = " SELECT NAME FROM USER WHERE NAME = ? ;";
			PreparedStatement pStmt = connection.prepareStatement(sql);

			pStmt.setString(1, name);
			ResultSet rs = pStmt.executeQuery();

			rs.next();
			String getname = rs.getString("NAME");

			if(getname == name) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e){
			return false;
		}
	}

	public User findByLogin(Login login) {
		User user = null;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				Statement statement = connection.createStatement();	){
			String sql = " SELECT NAME ,PASS FROM USER WHERE NAME = ? AND PASS = ?;";

			PreparedStatement pStmt = connection.prepareStatement(sql);

			pStmt.setString(1, login.getName());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				user = new User(name,pass);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;

	}
}
