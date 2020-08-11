package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAO {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public boolean create(Post post) {
		try (
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {

            String sql = "INSERT INTO POST(NAME,TITLE,CONTENT,PATTERN1,PATTERN2) VALUES(?,?,?,?,?)";
            PreparedStatement pStmt = connection.prepareStatement(sql);

            pStmt.setString(1, post.getUserName());
            pStmt.setString(2, post.getTitle());
            pStmt.setString(3, post.getContent());
            pStmt.setString(4, post.getPattern1());
            pStmt.setString(5, post.getPattern2());

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
	public List<Post> findAll() {
		List<Post> postList = new ArrayList<>();

		try(Connection connection = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT NUMBER,NAME,TITLE,CONTENT,PATTERN1,PATTERN2 FROM POST ";
			PreparedStatement pStmt = connection.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int number = Integer.parseInt(rs.getString("NUMBER"));
				String name = rs.getString("NAME");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String pattern1 = rs.getString("PATTERN1");
				String pattern2 = rs.getString("PATTERN2");
				Post post = new Post(number,name,title,content,pattern1,pattern2);
				postList.add(post);
			}



		}catch(SQLException e) {
			e.printStackTrace();
			return null;

		}
		return postList;
	}
	public void addJudge(String pattern,int num) {
		try (
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
//			String sql = "UPDATE POST SET ? = ? + 1 WHERE NUMBER = ? ;";
			String sql = "update post set "+pattern+" = "+pattern+" + 1 where number = "+num+" ;";

            PreparedStatement pStmt = connection.prepareStatement(sql);


//            pStmt.setString(1, pattern);
//            pStmt.setString(2, pattern);
//            pStmt.setInt(3, num);
            int rs = pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR");

		}

	}
	public int findNUMBER(int number) {
		int nu = 0;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
                	String sql = "SELECT NUMBER FROM POST WHERE NUMBER = ?;";
                	PreparedStatement pStmt = connection.prepareStatement(sql);

                	pStmt.setInt(1, number);

                	ResultSet rs = pStmt.executeQuery();

                	if(rs.next()) {
                		nu = rs.getInt("NUMBER");
                	}
                }catch(SQLException e) {
                	e.printStackTrace();
                	return 0;
                }
		return nu;
	}

	public String getPattern1(int number) {
		String pattern1 = null;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
			String sql = "SELECT PATTERN1 FROM POST WHERE NUMBER = ?;";
        	PreparedStatement pStmt = connection.prepareStatement(sql);

        	pStmt.setInt(1, number);
        	ResultSet rs = pStmt.executeQuery();
        	if(rs.next()) {
        		pattern1 = rs.getString("PATTERN1");
        	}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pattern1;
	}
	public String getPattern2(int number) {
		String pattern2 = null;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
			String sql = "SELECT PATTERN2 FROM POST WHERE NUMBER = ?;";
        	PreparedStatement pStmt = connection.prepareStatement(sql);

        	pStmt.setInt(1, number);
        	ResultSet rs = pStmt.executeQuery();
        	if(rs.next()) {
        		pattern2 = rs.getString("PATTERN2");
        	}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pattern2;
	}

	public int getPattern1_num(int number) {
		int nu = 0;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
			String sql = "SELECT PATTERN1_NUM FROM POST WHERE NUMBER = ?;";
        	PreparedStatement pStmt = connection.prepareStatement(sql);

        	pStmt.setInt(1, number);
        	ResultSet rs = pStmt.executeQuery();
        	if(rs.next()) {
        		nu = rs.getInt("PATTERN1_NUM");
        	}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return nu;
	}

	public int getPattern2_num(int number) {
		int nu = 0;
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                Statement statement = connection.createStatement();
                ) {
			String sql = "SELECT PATTERN2_NUM FROM POST WHERE NUMBER = ?;";
        	PreparedStatement pStmt = connection.prepareStatement(sql);

        	pStmt.setInt(1, number);
        	ResultSet rs = pStmt.executeQuery();
        	if(rs.next()) {
        		nu = rs.getInt("PATTERN2_NUM");
        	}
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return nu;
	}




}
