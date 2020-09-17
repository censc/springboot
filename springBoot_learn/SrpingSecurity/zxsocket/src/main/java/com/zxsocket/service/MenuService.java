package com.zxsocket.service;

import com.zxsocket.bean.Menu;
import com.zxsocket.common.HrUtils;
import com.zxsocket.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menu_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }
    
    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }
    
    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }
    
    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
