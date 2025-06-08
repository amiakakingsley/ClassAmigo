package com.amiaka;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amiaka.ModelDto.ApplicationUserDto;
import com.amiaka.Userservice.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private final UserService userService;

	
	public HomeController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/api/userinfo")
	@ResponseBody
	public ResponseEntity<ApplicationUserDto> showUser(){
		ApplicationUserDto applicationUserDto = userService.getUserProfile();
		return ResponseEntity.ok(applicationUserDto);
	}

	@GetMapping("/user/home")
	public String home(){
		return "home";
	}
	
	
	@GetMapping("/register")
	public String RegistrationPage() {
		return "registration";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/register")
	public String RegisterUser(Model model, ApplicationUserDto userDto) {
		if(userService.findUserByEmail(userDto.getEmail()).isPresent()) {
			return "redirect:/register";
			
		}
		userService.RegisterUser(userDto);
		
		return "redirect:/login";
		
	}
	
	@GetMapping("/user/AllUser")
	public String DisplayAllUsers(Model model) {
		   List<ApplicationUserDto> userDtos = userService.findAllUser();

	        model.addAttribute("users", userDtos);

	        return "home";
    }
	
	
	@GetMapping("/user/assign_tutor_role/{userId}")
	public String Assign_tutor_role(@PathVariable long userId, RedirectAttributes redirectAttribute) {
		if(userService.findById(userId)) {
			userService.AssignTutorRole(userId);
			redirectAttribute.addFlashAttribute("successMessage", "Tutor Assigned Successfully");
		}
		else {
			System.out.println("i didnt reach there");
			redirectAttribute.addFlashAttribute("errorMessage", "User or role not found.");
			   
		}
		
		return "redirect:/user/AllUser";
		
	}
	
	@GetMapping("/access_deniel")
	public String Access_denial() {
		return "access_denial";
		
	}
	

}

