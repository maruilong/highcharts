package com.shinian.controller;

import com.shinian.model.ModelJsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/charts")
public class ChartsController {

    @RequestMapping("/show")
    public String show() {

        return "charts";
    }


    @ResponseBody
    @RequestMapping("/lines")
    public String lines(HttpServletRequest request) {
        ModelJsonResult modelJsonResult = new ModelJsonResult();

        


        return modelJsonResult.toJson();
    }

}
