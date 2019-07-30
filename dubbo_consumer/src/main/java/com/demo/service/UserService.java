package com.demo.service;


import com.demo.entity.Edoc_category;
import com.demo.entity.Edoc_entry;
import com.demo.util.Page;

import java.util.List;

public interface UserService {

    List<Edoc_category> getCategory();

    Page<Edoc_entry> getEntryPages(int categoryId,
                                   int pageIndex,
                                   int pageSize);

    int deleteEntry(int id);
}
