package org.apply.methods.chapret1.controller;

import org.apply.methods.chapret1.model.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    //http://localhost:8080/hello/Serhii/Klunniy?number=121
    @GetMapping(value = "{firstName}/{lastName}")
    public String helloGet(@PathVariable String firstName,  // переменная пути^: (localhost:8080/hello)
                           @PathVariable String lastName,
                           @RequestParam(value = "number", required = false) String number    // параметр запроса:  ?  &&
    ) {
        return String.format("Message:" + "\"Hello %s %s, number=%s\"", firstName, lastName, number);
    }

    //http://localhost:8080/hello
//    {
//        "firstName": "Serhii",
//            "lastName": "Klunniy",
//            "number": 333
//    }
    @RequestMapping(method = RequestMethod.POST)
    public String helloGet(@RequestBody HelloRequest request) {
        return String.format("Message:" + "\"Hello %s %s, number=%s\"", request.firstName(), request.lastName(), request.number());
    }
}
