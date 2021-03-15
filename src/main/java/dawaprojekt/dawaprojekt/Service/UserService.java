package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.User;
import dawaprojekt.dawaprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    // Get a single user
    public User getUser(Integer userID){
        return userRepository.getOne(userID);
    }
    public User getUser(String username){
        return userRepository.getUserByUsername(username);
    }

    // Save a user
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    // Delete a user
    public void deleteUser(Integer userID){
        userRepository.deleteById(userID);
    }
}