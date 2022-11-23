package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Employee.domain.Employee;
import com.example.Employee.domain.EmployeeRepository;
import com.example.Employee.domain.Department;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	 @Autowired
	    private EmployeeRepository repository;
	    //private CategoryRepository crepository;
	 
	    //Check if I can find a book
	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Employee> books = repository.findByAuthor("G.G.Martin");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("G.G.Martin");
	    }
	    
	    //Check if I can save a new book
	    @Test
	    public void createNewBook() {
	    	Employee book = new Employee("IT", "Stephene King", 1992, "2113", 70, new Department("Horror"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }  
	    
	    //Check if I can delete book
	    @Test
	    public void deleteBook() {
	    	List<Employee> books = repository.findByTitle("Twilight");
	    	assertThat(books).hasSize(1);
	    	repository.deleteById((long) 9);
	    	books = repository.findByTitle("Twilight");
	    	assertThat(books).hasSize(0);
	    }
	    
}
