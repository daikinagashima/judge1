package model;

import dao.RegisterDAO;

public class RegisterUserLogic {
    public void execute(User user) {
    	RegisterDAO dao = new RegisterDAO();
    	dao.create(user);

    }
}