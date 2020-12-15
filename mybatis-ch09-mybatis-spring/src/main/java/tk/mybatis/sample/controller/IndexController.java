package tk.mybatis.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(value = {"/index",""})
    public ModelAndView dict(HttpServletRequest request){
        log.info("{}",request.getRequestURL());
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("now",new Date());

        return mv;
    }

}
