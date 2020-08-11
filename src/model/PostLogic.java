package model;

import dao.PostDAO;

public class PostLogic {

	public void execute(Post post) {
		PostDAO dao = new PostDAO();
		dao.create(post);
	}
}
