package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Judge_ListDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public boolean addList(int number,String judge_name) {
		try (
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {

            String sql = "INSERT INTO JUDGE_LIST(NUMBER,JUDGE_NAME) VALUES(?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);

            pStmt.setInt(1, number);
            pStmt.setString(2, judge_name);


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
	public int findList(int number,String name) {
		int nu = 0;
			try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	                Statement statement = connection.createStatement();
	                ) {
	                	String sql = "SELECT * FROM JUDGE_LIST WHERE NUMBER = ? AND JUDGE_NAME = ?;";
	                	PreparedStatement pStmt = connection.prepareStatement(sql);

	                	pStmt.setInt(1, number);
	                	pStmt.setString(2, name);

	                	ResultSet rs = pStmt.executeQuery();

	                	if(rs.next()) {
	                		nu ++;
	                	}
	                }catch(SQLException e) {
	                	e.printStackTrace();
	                	return 0;
	                }
			return nu;

	}

}
