package com.yan.controller;

import com.yan.entity.Movie;
import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.service.MovieService;
import com.yan.service.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Controller
@RequestMapping(value ="/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/getMovieList")
    @ResponseBody
    public ResponseData query(){
        return this.movieService.getMovieList();
    }

    @RequestMapping(value = "/getMovieByID/{id}")
    @ResponseBody
    public ResponseData queryByID(@PathVariable(value = "id") String id){
        return this.movieService.getMovieByID(id);
    }

    @RequestMapping(value = "/addComment")
    @ResponseBody
    public ResponseData addComment(@RequestBody RequestData requestData){
         return this.movieService.addComment(requestData);
    }

}
