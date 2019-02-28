package app.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.mapper.UserMapper;
import app.value.User;

@RestController
public class UserRS {
	
	@Autowired
	private app.repo.UserRepository userRepository; 
	

	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/user")
	@GetMapping("/user")
    public List<User> findAll() throws SQLException {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/user/{id}", method=RequestMethod.GET)
	@GetMapping("/user")
    public ResponseEntity<User> findById(@PathVariable(value="id") Integer id) throws SQLException {
		System.out.println(id);
		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<User>(userRepository.findById(id), responseHeaders, HttpStatus.OK);
	}
	
	
	@PostMapping("/user")
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
	
	}
	
	
}
