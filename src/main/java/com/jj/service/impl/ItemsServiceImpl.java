package com.jj.service.impl;

import com.jj.pojo.Items;
import com.jj.pojo.Msg;
import com.jj.repository.ItemsRepository;
import com.jj.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public String del(int id) {
        try {
            itemsRepository.deleteById(id);
            return "ok";
        } catch (Exception e) {
            return "no";
        }

    }

    @Override
    public void add(Items items) {
        itemsRepository.save(items);
    }

    @Override
    public Msg findall(Integer size,Integer page) {
        if(page<0){
            page=0;
        }else{
            page=page-1;
        }
        Pageable of = PageRequest.of(page, size);
        Page<Items> all = itemsRepository.findAll(of);
        List<Items> content = all.getContent();

        Msg msg = new Msg();
        msg.setList(content);

        msg.setTotal(all.getTotalElements());
        msg.setPage(all.getTotalPages());
        return msg;
    }

    @Override
    public Items updateById(Items items) {
        Items items1 = itemsRepository.saveAndFlush(items);
        return items1;
    }

    @Override
    public List<Items> findallTj(String name, float price) {
        return null;
    }

    @Override
    public Items findOne(int id) {
        Optional<Items> byId = itemsRepository.findById(id);
        Items items = null;
        if (byId.isPresent()) {
            items = byId.get();
        }
        return items;
    }
}
