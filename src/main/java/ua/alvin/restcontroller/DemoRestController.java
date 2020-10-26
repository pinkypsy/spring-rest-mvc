package ua.alvin.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

//    code for /hello endpoint
    @GetMapping("/hello")
    public String say(){
        return "HelloWorld";
    }
}
