package com.jj.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Msg {
    private List<Items> list;

    private Integer page;

    private long total;
}
