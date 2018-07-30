package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import system.model.Item;
import system.service.DBService;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;

@Controller
public class DBController {

    @Autowired
    private DBService dbService;

    @RequestMapping(value = "/add_item", method = RequestMethod.GET)
    public ModelAndView addItem(ModelAndView modelAndView) {
        Item item = new Item();
        modelAndView.addObject("command", item);
        modelAndView.setViewName("add_item");
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView itemList(ModelAndView modelAndView) throws IOException {
        List<Item> itemList = dbService.getAllItems();
        modelAndView.addObject("command", itemList);
        modelAndView.setViewName("items_page");
        return modelAndView;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView result(@ModelAttribute Item item) {
        dbService.addItem(item);
        return new ModelAndView("result");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(ModelAndView modelAndView, HttpServletRequest request){
        List<Item> itemList = dbService.searchItems(request);
        modelAndView.addObject("command", itemList);
        modelAndView.setViewName("items_page");
        return modelAndView;
    }

}