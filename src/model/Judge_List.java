package model;

import dao.Judge_ListDAO;

public class Judge_List {

	public void execute(int number,String judge_name) {
		Judge_ListDAO dao = new Judge_ListDAO();
		dao.addList(number, judge_name);
	}
}
