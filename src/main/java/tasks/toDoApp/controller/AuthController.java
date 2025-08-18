package tasks.toDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tasks.toDoApp.dto.UserCreationDTO;
import tasks.toDoApp.dto.UserLoginDTO;
import tasks.toDoApp.model.User;
import tasks.toDoApp.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserCreationDTO userCreationDTO) {
        User user = userService.createUser(userCreationDTO);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.getUserByEmail(userLoginDTO.getEmail());
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String,Object> map = new HashMap<>();
        map.put("token","fake-jwt-token-"+user.getId());
        map.put("user",user);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
