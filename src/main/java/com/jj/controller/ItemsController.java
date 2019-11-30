package com.jj.controller;

import com.jj.pojo.Items;
import com.jj.pojo.Msg;
import com.jj.service.ItemsService;
import com.jj.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@RestController
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Value("${qiniu.url}")
    private String url;
    @Autowired
    private UploadUtils up;
    /*@RequiresPermissions(value = {"user_find"})*/

    @RequestMapping("/all/{size}/{page}")
    public Msg findall(@PathVariable("size") Integer size, @PathVariable("page") Integer page) {
        return itemsService.findall(size, page);
    }


    @RequestMapping(value = "/findOne")
    public Items findOne(@RequestBody Items items) {
        Integer id = items.getId();
        return itemsService.findOne(id);
    }

    @RequestMapping("/update")
    public Items updateById(@RequestBody Items items) {
        Items items1 = null;
        items1 = itemsService.updateById(items);
        return items1;
    }

    @RequestMapping("/add")
    public Items add(@RequestBody Items items, MultipartFile multipartFile) {
        Items items1 = null;
    try{
        String upload = up.upload(multipartFile);
        items.setPic(url + upload);
        items1 = itemsService.updateById(items);
    }catch (Exception e){
        items1 = itemsService.updateById(items);
    }
        return items1;
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public String del(@RequestBody Items items){
        return itemsService.del(items.getId());
    }
}
