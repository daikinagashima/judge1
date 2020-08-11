package model;

public class Post {

	private String userName;
	private String title;
	private String content;
	private String pattern1;
	private String pattern2;
	private int number;


	public Post(String userName,String title,String content,String pattern1,String pattern2) {
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.pattern1 = pattern1;
		this.pattern2 = pattern2;
	}

	public Post(int number,String userName,String title,String content,String pattern1,String pattern2) {
		this.number = number;
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.pattern1 = pattern1;
		this.pattern2 = pattern2;
	}
	public int getNumber() {
		return number;
	}

	public String getUserName() {
		return userName;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getPattern1() {
		return pattern1;
	}

	public String getPattern2() {
		return pattern2;
	}



}
