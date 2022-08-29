package me.lazychildren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.lazychildren.dao.DairyDao;

import me.lazychildren.entity.Dairy;
import me.lazychildren.entity.User;
import me.lazychildren.ret.PageRet;
import me.lazychildren.service.DairyService;
import me.lazychildren.util.GloabalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DairyServiceImpl implements DairyService {


    @Autowired
    private DairyDao dairyDao;



    public PageRet getOnesDairies(User user , Integer curpage){
        IPage<Dairy> page = new Page(curpage, GloabalUtil.PAGE_SIZE);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid",user.getId());
        dairyDao.selectPage(page, queryWrapper);
        int totalNum = (int)page.getTotal();
        int size = (int)page.getSize();
        return new PageRet((int) page.getCurrent(), totalNum,size,page.getRecords());

    }

    @Override
    public Boolean writeDairy(User user, Dairy dairywrite) {



        dairywrite.setDate(GloabalUtil.getTime());
        dairywrite.setUserid(user.getId());
        dairyDao.insert(dairywrite);
        return true;
    }


}
