package com.shinian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class ChartsController {

    @RequestMapping("/show")
    public String show() {

        return "charts";
    }
}
