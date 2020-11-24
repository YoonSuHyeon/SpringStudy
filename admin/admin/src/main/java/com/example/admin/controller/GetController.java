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
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{"accout" : "" , "email" : "" , "page" : 0} json  스프링 부트에서 Jackson라이브러리를 통해서 Json형태로 바꿔줌 객체를 리턴한다는것은 Json

        return searchParam;
    }
}
