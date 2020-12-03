package christopher.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/test")
public class TestServlet {
    @RequestMapping("/{page}")
    public String goPage(@PathVariable String page){
        return "test/"+page;
    }
}
