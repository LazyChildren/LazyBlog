package me.lazychildren.service;


import me.lazychildren.entity.Dairy;
import me.lazychildren.entity.User;
import me.lazychildren.ret.PageRet;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface DairyService {
    public PageRet getOnesDairies(User user, Integer curpage);
    public Boolean writeDairy(User user, Dairy dairyWrite);
}
