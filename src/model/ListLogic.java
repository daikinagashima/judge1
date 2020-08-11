package model;

import dao.Judge_ListDAO;

public class ListLogic {
	public boolean execute(int number,String name) {
		Judge_ListDAO dao = new Judge_ListDAO();
		int nu = dao.findList(number,name);
		if(nu >= 1) {
			return true;
		}else {return false;}
	}

}
