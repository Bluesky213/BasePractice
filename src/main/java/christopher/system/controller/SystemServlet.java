package christopher.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemServlet {
    @RequestMapping("/{page}")
    public String goPage(@PathVariable String page){
        return "system/"+page;
    }
}
