package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.model.User;
import dawaprojekt.dawaprojekt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/allUsers")
    public String showUsers(Model model, Authentication authentication) {

        model.addAttribute("user", userService.getUser(authentication.getName()));
        model.addAttribute("userList", userService.getUsers());

        return "allusers";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute(name = "user") User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        encoder.encode(user.getPassword());
        System.out.println(user);

        String password = encoder.encode(user.getPassword());

        user.setPassword(password);
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setUserInfo("basic user");
        userService.saveUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public String editUser(Model model,
                           @ModelAttribute(name = "user") User user,
                           @PathVariable(name = "id") int id,
                           @RequestParam(name = "editUsername") String username,
                           @RequestParam(name = "editEmail") String email,
                           @RequestParam(name = "editRole") String role,
                           @RequestParam(name = "editUserInfo") String userInfo) {

        user = userService.getUser(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setRole(role);
        user.setUserInfo(userInfo);
        model.addAttribute("account", user);
        System.out.println(user);
        userService.saveUser(user);

        return "redirect:/auctions/1";
    }


}