package com.xiyifen.dao;

import com.xiyifen.pojo.BaseDict;

import java.util.List;

public interface DictMapper {

    public List<BaseDict> findDictByCode(String code);
}
