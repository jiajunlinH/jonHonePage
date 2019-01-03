package com.jon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomePageController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Date loveDate = null;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public String home(HttpServletRequest request) {
//        return "Hello," + request.getLocalName()+":"+request.getLocalPort() +
//                "<br> your ir address ：" + request.getRemoteAddr() + "。" +
//                "<br> your browser is " + request.getHeader("User-Agent") +
//                "<br> this server port :" + request.getLocalPort();
//    }

    @GetMapping(value = "/")
    public String homePage(Model model){
        model.addAttribute("nowDay", getClacDate());
        return "/homePage";
    }

    private Double getClacDate(){
        if(loveDate == null){
            try{
                loveDate = sdf.parse("2018-09-29 00:00:00");
            }catch (Exception e){

            }
        }
        Date nowDate = new Date();
        long times = nowDate.getTime() - loveDate.getTime();

        return times/1000/3600/24d;
    }
}
