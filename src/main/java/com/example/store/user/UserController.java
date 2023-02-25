package com.example.store.user;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.store.user.SignUpForm;
import com.example.store.user.User;
import com.example.store.user.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value="signup")
    public String addUser(Model model){
        model.addAttribute("signUpForm", new SignUpForm());
        return "signup";
    }

    @RequestMapping(value="saveuser",method = RequestMethod.POST)
    public String save (@Valid @ModelAttribute("signUpForm") SignUpForm signupForm, BindingResult binding){
        if (!binding.hasErrors()) {
            if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
                String pwd=signupForm.getPassword();
                BCryptPasswordEncoder bc= new BCryptPasswordEncoder();
                String hashPwd= bc.encode(pwd);

                User newUser= new User();
                newUser.setPassword(hashPwd);
                newUser.setUsername(signupForm.getUsername());
                newUser.setRole("USER");
                if (repository.findByUsername(signupForm.getUsername())==null) {
                    repository.save(newUser);
                }
                else {
                    binding.rejectValue("username","err.username", "Există deja un cont cu acest username");
                    return "signup";
                }
            }
            else {
                binding.rejectValue("passwordCheck", "err.passCheck", "Parolele nu se potrivesc");
                return "signup";
            }
        }
        else {
            return "signup";
        }
        return "redirect:/login";
    }
}

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")

    public String showUserList(Model model){
        List<User> listUsers = service.lisAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/new")

    public String showNewForm(Model model){
        model.addAttribute("user", new User());

        return "user_form";


    }
}
*/