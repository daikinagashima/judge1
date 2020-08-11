package model;

import dao.RegisterDAO;

public class Loginlogic {

	public boolean execute(Login login) {
		RegisterDAO dao = new RegisterDAO();
		User user = dao.findByLogin(login);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

}
