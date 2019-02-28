package app.mapper;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.value.User;

@Service
public class UserMapper {

	public User map(String content) {
		User userFromJSON = null;
		   ObjectMapper mapper = new ObjectMapper();
		   try {
		           userFromJSON = mapper.readValue(content, User.class);
		           System.out.println(userFromJSON.toString());
		          
		          return (userFromJSON);
		       } catch (JsonGenerationException e) {
		           System.out.println(e);
		           } catch (JsonMappingException e) {
		          System.out.println(e);
		       } catch (IOException e) {
		       System.out.println(e);
		       } 
		  
		   return userFromJSON;
	}
	
	
}
