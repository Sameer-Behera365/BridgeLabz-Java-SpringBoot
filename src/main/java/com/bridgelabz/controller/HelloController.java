package com.bridgelabz.controller;

import com.bridgelabz.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // UC1: curl localhost:8080/hello -w "\n"
    @GetMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello From BridgeLabz!!!";
    }

    // UC2: curl localhost:8080/hello/query?name=Mark -w "\n"
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String sayHelloQuery(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    // UC3: curl localhost:8080/hello/param/Mark -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    // UC4: curl -X POST -H "Content-Type: application/json"
    //      -d '{"firstName": "Mark","lastName": "Taylor"}'
    //      "http://localhost:8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHelloPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() +
                " " + user.getLastName() + "!";
    }

    // UC5: curl -X PUT localhost:8080/hello/put/Mark/?lastName=Taylor -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName,
                              @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }
}