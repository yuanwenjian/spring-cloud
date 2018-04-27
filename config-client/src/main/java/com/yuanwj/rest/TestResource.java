package com.yuanwj.rest;

import com.yuanwj.config.BiocloudProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by bmk on 17-11-28.
 */
@RestController
@RequestMapping(value = "/api/v1/test/")
public class TestResource {

    private static final Logger LOG = LoggerFactory.getLogger(TestResource.class);

    @Inject
    private  BiocloudProperties biocloudProperties;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        LOG.debug(biocloudProperties.getFtp().getHost());
        LOG.debug(biocloudProperties.getFtp().getPort()+"");
        LOG.debug(biocloudProperties.getFtp().getUser());
        return "success";
    }

//    public String uploadFile(String path){
//
//    }
}
