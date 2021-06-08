package net.codejava.customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	protected CustomerService service;

	@RequestMapping("/")
	public ModelAndView Home()
	{
		ModelAndView mv = new ModelAndView("index");
		List<Customer> listCustomer= service.listAll();
		mv.addObject("listCustomer", listCustomer);
		return mv;
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model)
	{
		model.put("customer", new Customer());
		return "new_customer";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		service.save(customer);
		
		return "redirect:/";
	}
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id)
	{
		ModelAndView mv = new ModelAndView("edit_customer");
		Optional<Customer> customer = service.editid(id);
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam long id)
	{
		service.deleteid(id);
		return "redirect:/";
	}
	@RequestMapping("/search")
	public ModelAndView searchCustomer(@RequestParam String keyword)
	{
		ModelAndView mv = new ModelAndView("search");
		List<Customer> result= service.search(keyword);
		mv.addObject("result", result);
		return mv;
	}
}
