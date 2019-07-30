package com.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.entity.Edoc_category;
import com.demo.entity.Edoc_entry;
import com.demo.service.RpcEdocService;
import com.demo.service.UserService;
import com.demo.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Reference
    RpcEdocService rpcEdocService;

    @Override
    public List<Edoc_category> getCategory() {
        return rpcEdocService.getCategory();
    }

    @Override
    public Page<Edoc_entry> getEntryPages(int categoryId, int pageIndex, int pageSize) {
        int from=(pageIndex-1)*pageSize;
        int count=rpcEdocService.getEntryCount(categoryId);
        List<Edoc_entry> list=rpcEdocService.getEntryPages(categoryId,from,pageSize);
        Page<Edoc_entry> page=new Page<>(pageIndex,pageSize,count,list);
        return page;
    }

    @Override
    public int deleteEntry(int id) {
        return rpcEdocService.deleteEntry(id);
    }
}
