package shop.service;

import shop.entity.UserEntity;

public interface UserService {

    /**
     * User login
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * User registration
     *
     * @param user
     * @return
     */
    String register(UserEntity user);

    /**
     * Retrieves user by username
     *
     * @param username
     * @return
     */
    UserEntity findUserByUsername(String username);

    /**
     * Deletes user by username
     *
     * @param username
     */
    void deleteUser(String username);
}
