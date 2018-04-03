package com.yuanwj.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanwj.model.News;
import com.yuanwj.repository.NewsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by bmk on 18-4-3.
 */
@RestController
@RequestMapping(value = "/api/v1/news/")
@Api(description = "新闻接口API")
public class NewsResource {

    @Inject
    private NewsMapper newsMapper;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @ApiOperation("获取所有news")
    public PageInfo<News> findAll(){
        PageHelper.startPage(1,5);
        List<News> newses =  newsMapper.findAll();
        PageInfo<News> pageInfo = new PageInfo<>(newses);
        return pageInfo;
    }

    @RequestMapping(value = "searchMap",method = RequestMethod.GET)
    @ApiOperation("根据title搜索新闻")
    public List<Map> searchMap(String title){
        List<Map> maps = newsMapper.searchMap(title);
        return newsMapper.searchMap(title);
    }

}
