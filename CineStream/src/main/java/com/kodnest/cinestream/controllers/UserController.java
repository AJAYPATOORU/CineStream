package com.kodnest.cinestream.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kodnest.cinestream.entities.Movie;
import com.kodnest.cinestream.entities.User;
import com.kodnest.cinestream.services.MovieService;
import com.kodnest.cinestream.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService usSr;
	@Autowired
	MovieService movSr;

	
	@GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
	
	@PostMapping("/signup")
	public String addUser(@ModelAttribute User usr) {
		boolean status = usSr.emailExists(usr.getEmail());
		if (status == true) {
			return "signupfail";
		} else {
			usSr.addUsers(usr);
			return "signupsuccess";
		}
	}

	
	@GetMapping("/signin")
    public String showSigninForm() {
        return "signin";
    }
	
	@PostMapping("/signin")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		boolean loginStatus = usSr.checkUser(email, password);
		if (loginStatus == true) {
			List<Movie> movieList = movSr.viewMovie();
			model.addAttribute("movies", movieList);
			session.setAttribute("email", email);
			List<Movie> lastFive = movSr.getLast5Products();
			model.addAttribute("last", lastFive);
			if (email.equals("admin@gmail.com")) {
				return "adminhome";
			} else {
				return "home";
			}
		} else {
			return "signinfail";
		}
	}

	@GetMapping("/view-users")
	public String viewUsers(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		List<User> userList = usSr.viewUser(email);
		model.addAttribute("users", userList);
		return "viewusers";
	}

	@GetMapping("/edit/{id}")
	public String getUser(@PathVariable(name = "id") int id, Model model) {
		User user = usSr.getUser(id);
		model.addAttribute("user", user);
		return "edituser";
	}
	
	@PostMapping("/edit/{id}")
    public String updateUser(@PathVariable(name = "id") int id, @ModelAttribute User user, RedirectAttributes redirect) {
        user.setId(id); // Ensure the ID is set for the update
        usSr.updateUser(user);
        redirect.addFlashAttribute("message", "User updated successfully");
        return "redirect:/view-users";
    }

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id, Model model, RedirectAttributes redirect) {
		usSr.deleteUser(id);
		redirect.addFlashAttribute("message", "Product deleted successfully");
		return "redirect:/view-users";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "signin";
	}
}
