package de.fhdo.passwordmanager.controller;

import de.fhdo.passwordmanager.entity.User;
import de.fhdo.passwordmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcConfig {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public void setPasswordEncoder(
      PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/home")
  public String home(Model model) {
    return "home";
  }

  @GetMapping("/")
  public String homeRoot(Model model) {
    return "home";
  }

  @GetMapping("/hello")
  public String hello(Model model) {
    return "hello";
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/login")
  public String loginPost(Model model) {
    return "login";
  }

  @GetMapping("/register")
  public String greetingForm(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping(value = "/createUser")
  public String createUser(Model model, @ModelAttribute User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return "home";
  }

}
