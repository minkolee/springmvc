package cc.conyli.dao;

import cc.conyli.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
