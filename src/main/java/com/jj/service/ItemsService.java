package com.jj.service;

import com.jj.pojo.Items;
import com.jj.pojo.Msg;

import java.util.List;

public interface ItemsService {
    String del(int id);
    void add(Items items);
    public Msg findall(Integer size, Integer page);
    Items updateById(Items items);
    List<Items> findallTj(String name, float price);
    Items findOne(int id);
}
