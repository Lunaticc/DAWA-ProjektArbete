package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.User;
import dawaprojekt.dawaprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get paginated users
    public Page<User> findPageinated(int pageNr, int pageSize){
        Pageable pageable = PageRequest.of(pageNr-1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        return userRepository.findAll(pageable);
    }

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