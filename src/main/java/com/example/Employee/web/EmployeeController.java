package com.example.Employee.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Employee.domain.Employee;
import com.example.Employee.domain.EmployeeRepository;
import com.example.Employee.domain.DepartmentRepository;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DepartmentRepository crepository;
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/list")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "list"; 
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../list";
    } 
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	    public String addBook(Model model){
		 //content of the method is completely empty new object
	    	model.addAttribute("book", new Employee());
	    	model.addAttribute("categories", crepository.findAll()); 
	    	//go to new html-end-point
	        return "addbook";
	    } 
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Employee book){
	        repository.save(book);
	        return "redirect:list";
	    } 
	
	 @RequestMapping(value = "/edit/{id}")
		public String edit(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("category", crepository.findAll());
		return "edit";
	 }
	 
	    //RESTful service to get all books
		@RequestMapping(value ="/books", method = RequestMethod.GET)
		public @ResponseBody List<Employee> bookListRest(){
			return (List<Employee>) repository.findAll();
		}


		//RESTful service to get books by id
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Employee> findBookRest(@PathVariable("id") Long bookId) {	
	    	return repository.findById(bookId);
	    }       

	}


