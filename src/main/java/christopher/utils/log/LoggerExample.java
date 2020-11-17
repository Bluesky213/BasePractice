package christopher.utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoggerExample {
    public final static Logger logger = LoggerFactory.getLogger(LoggerExample.class);
    @RequestMapping("logger")
    @ResponseBody
    public void printLogger(){
        logger.info("DEBUG");
        logger.info("INFO");
        logger.info("DEBUG");
        logger.info("ERROR");
    }
}
