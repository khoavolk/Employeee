package com.example.Bookstore;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Employee.web.EmployeeController;
import com.example.Employee.web.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
