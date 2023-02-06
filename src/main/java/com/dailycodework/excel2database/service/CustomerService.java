package com.dailycodework.excel2database.service;

import com.dailycodework.excel2database.domain.Customer;
import com.dailycodework.excel2database.domain.Role;
import com.dailycodework.excel2database.domain.Users;
import com.dailycodework.excel2database.repository.CustomerRepository;
import com.dailycodework.excel2database.repository.UserRepository;

import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private UserRepository customerRepository;
    
	@Autowired
	PasswordEncoder passwordEncoder;

    public void saveCustomersToDatabase(MultipartFile file){
    	List<Customer> users=new ArrayList<Customer>();
    	Long i=0L;
        if(ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Users> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                Users u= new Users();
            
                Role role= new Role(2L,"user");
                for(Users p: customers){
                	i++;
                	u.setPassword(passwordEncoder.encode(p.getPassword()));
                	u.setRole(role);
                	u.setId((Long)i);
                	u.setUsername(p.getUsername());
                	
                	System.out.println(u.getPassword());
                	System.out.println(u.getRole());
               	this.customerRepository.save(u);
                	};
                
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

//    public List<Customer> getCustomers(){
//        return customerRepository.findAll();
//    }
}
