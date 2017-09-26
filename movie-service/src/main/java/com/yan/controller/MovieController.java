package com.yan.controller;

import com.yan.entity.ResponseData;
import com.yan.service.MovieService;
import com.yan.service.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Controller
@RequestMapping(value ="/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "getMovieList")
    @ResponseBody
    public ResponseData query(){
        return this.movieService.getMovieList();
    }

    @RequestMapping(value = "/getMovieByID")
    @ResponseBody
    public ResponseData queryByID(){
        return this.movieService.getMovieByID();
    }
}
