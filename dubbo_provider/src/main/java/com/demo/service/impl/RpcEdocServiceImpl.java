package com.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.entity.Edoc_category;
import com.demo.entity.Edoc_entry;
import com.demo.mapper.Edoc_categoryMapper;
import com.demo.mapper.Edoc_entryMapper;
import com.demo.service.RpcEdocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class RpcEdocServiceImpl implements RpcEdocService{

    @Autowired
    Edoc_categoryMapper edoc_categoryMapper;
    @Autowired
    Edoc_entryMapper edoc_entryMapper;

    @Override
    public List<Edoc_category> getCategory() {
        return edoc_categoryMapper.getCategory();
    }

    @Override
    public List<Edoc_entry> getEntryPages(int categoryId, int from, int pageSize) {
        return edoc_entryMapper.getEntryPages(categoryId,from,pageSize);
    }

    @Override
    public int getEntryCount(int categoryId) {
        return edoc_entryMapper.getEntryCount(categoryId);
    }

    @Override
    public int deleteEntry(int id) {
        return edoc_entryMapper.deleteEntry(id);
    }
}
