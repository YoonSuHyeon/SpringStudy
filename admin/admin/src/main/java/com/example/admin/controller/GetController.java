package com.example.admin.controller;


import com.example.admin.model.SearchParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET,path = "/getMethod") //localhost:8080/api/getMethod   ** GetMapping와 같음
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id , @RequestParam(name = "password") String password){
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        return id + password;

    }

    @GetMapping("/getMultiParameter") // localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    public String getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }
}
