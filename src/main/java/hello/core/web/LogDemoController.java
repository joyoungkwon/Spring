package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo (HttpServletRequest req){
        String RequestURL = req.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.setRequestURL(RequestURL);

        myLogger.log("controller Test");
        logDemoService.logic("testId");
        return "ok";

    }

}
