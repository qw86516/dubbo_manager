package com.demo.controller;

import com.demo.dto.Dto;
import com.demo.dto.DtoUtil;
import com.demo.entity.Edoc_category;
import com.demo.entity.Edoc_entry;
import com.demo.service.UserService;
import com.demo.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/page")
    public Dto index(@RequestParam(value = "pageIndex",defaultValue = "1")int pageIndex,
                     @RequestParam(value = "categoryId",defaultValue = "0")int categoryId){
        Page<Edoc_entry> pages = userService.getEntryPages(categoryId, pageIndex, 2);
        return DtoUtil.returnDataSuccess(pages);
    }
    @RequestMapping("/category")
    public Dto category(){
        List<Edoc_category> categorys = userService.getCategory();
        return DtoUtil.returnDataSuccess(categorys);
    }

    @RequestMapping("/delete")
    public Dto delete(int id){
        int cnt= userService.deleteEntry(id);
        boolean flag=cnt==1;
        return DtoUtil.returnDataSuccess(flag);
    }

}
