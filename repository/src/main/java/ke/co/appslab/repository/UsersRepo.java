package ke.co.appslab.repository;

import ke.co.appslab.core.models.User;
import ke.co.appslab.db.UserDao;

public class UsersRepo {
    UserDao userDao = new UserDao();

    public void createUser(){
        userDao.createUser();
    }

    public User getUser(){
        return userDao.getUser();
    }
}
