package com.yuanwj.repository;

import com.yuanwj.model.News;

import java.util.List;
import java.util.Map;

/**
 * Created by bmk on 18-4-3.
 */
public interface NewsMapper {

    List<News> findAll();

    List<Map> searchMap(String title);
}
