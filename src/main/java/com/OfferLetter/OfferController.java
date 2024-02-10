package com.OfferLetter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	
	
	@GetMapping("/")
	public String Home(Model model) {
		OfferLetter offer = new OfferLetter();
		model.addAttribute("offer", offer);
		return "index";
	}
	
	
	@PostMapping("/send")
	public String sendOfferLetter(@ModelAttribute("offer") OfferLetter offerLetter , HttpServletRequest request) throws Exception {
		OfferLetter savLetter = new OfferLetter();
		savLetter.setId(offerLetter.getId());
		savLetter.setName(offerLetter.getName());
		savLetter.setEmail(offerLetter.getEmail());
		//String email = request.getParameter("email");
//		offerService.saveEnrollment(offerLetter);
		offerService.sendOfferLetter(offerLetter.getEmail() , offerLetter.getName());
		System.out.print("Enrollment Successfully Registered!");
	    return "redirect:/";
		
		
		
	}
	

}
