package app.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.mapper.CompanyMapper;
import app.value.Company;

@RestController
public class CompanyRS {
	
	@Autowired
	private app.repo.CompanyRepository companyRepository;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@RequestMapping("/company")
	@GetMapping("/company")
    public List<Company> findAll() throws SQLException {
		return companyRepository.findAll();
	}
	
	@RequestMapping(value = "/company/{id}", method=RequestMethod.GET)
	@GetMapping("/user")
    public ResponseEntity<Company> findById(@PathVariable(value="id") Integer id) throws SQLException {
		System.out.println(id);
		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<Company>(companyRepository.findById(id), responseHeaders, HttpStatus.OK);
	}
	
	
	/*@PostMapping("/user")
	public ResponseEntity<User> newUser(@RequestBody String content) throws SQLException, IllegalStateException {
		User user = userMapper.map(content);
		System.out.println(" - " + user.toString());
		user = userRepository.create(user);
		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Content-Type", "application/json;charset=UTF-8");
		
		if(user!=null) {
			return new ResponseEntity<User>(user, responseHeaders, HttpStatus.OK);
		}else {
			throw new IllegalStateException("Utente già presente a sistema") ;
		}
	
	}*/
	
	
}
