package luffy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        log.info("查询数据库.....");
        return "ok";
    }
}
