package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
//	//need to inject the customer dao  // remove this because we added service layer
//	@Autowired
//	private CustomerDAO customerDAO;
	
	
	
//	need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		
		//get the customers from the dao
		//List<Customer> theCustomers = customerDAO.getCustomers();
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model theModel) {
		
		//get the customer from database
		Customer theCustomer = customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form
		return "customer-form";
		
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
@GetMapping("/login")
public ModelAndView showForm()
{
	ModelAndView mav = new ModelAndView("showForm");
	return mav;
}
	
	@PostMapping("/authenticate")
	public ModelAndView process(@ModelAttribute("prachi")Customer theCustomer)
	{
		ModelAndView mav = new ModelAndView("list-customers");
		Customer theCustomer1 = customerService.loginCustomer(theCustomer.getFirstName(),theCustomer.getLastName(),theCustomer.getEmail());
		mav.addObject("prachi", theCustomer1);

		return mav;
	}
	
	
	
	
	

}



