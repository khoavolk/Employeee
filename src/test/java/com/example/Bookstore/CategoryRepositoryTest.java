package com.example.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Employee.domain.Department;
import com.example.Employee.domain.DepartmentRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private DepartmentRepository crepository;

    //Test if I can find category by name?
    @Test
    public void findByNameShouldReturnCategory() {
        
        List<Department> categories = crepository.findByName("Fantastic");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryid()).isNotNull();
    }
    
    @Test
    public void deleteCategory() {
		List<Department> categories = crepository.findByName("Fantastic");
		assertThat(categories).hasSize(1);
    	crepository.deleteById((long) 1);
    	categories = crepository.findByName("Fantastic");
    	assertThat(categories).hasSize(0);
    }
  
}
