package com.cjimgarten.hello;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chris on 3/9/18.
 */
@Controller
public class AppController {

    private static final Logger LOGGER = Logger.getLogger(AppController.class);

    @Value(value = "${com.cjimgarten.app.title}")
    String title;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        LOGGER.info("Get index page");
        model.addAttribute("title", title);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processForm(@RequestParam String name, Model model) {

        LOGGER.info("Processing form request");
        String greeting = "Hello " + name;

        if (name.equals("")) {
            greeting = "Greetings";
        }

        LOGGER.info(greeting);
        model.addAttribute("greeting", greeting);
        model.addAttribute("title", title);
        return "hello";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String processPathVariable(@PathVariable String name, Model model) {

        LOGGER.info("Processing path variable");
        String greeting = "Hello " + name;

        if (name.equals("")) {
            greeting = "Greetings";
        }

        LOGGER.info(greeting);
        model.addAttribute("greeting", greeting);
        model.addAttribute("title", title);
        return "hello";
    }
}
