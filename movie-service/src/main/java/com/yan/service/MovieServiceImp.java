package com.yan.service;

import com.yan.entity.Movie;
import com.yan.entity.MovieExample;
import com.yan.entity.ResponseData;
import com.yan.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public ResponseData getMovieList() {
        List<Movie> movieList = movieMapper.selectMovieList();

        for (Movie movie:movieList) {
            movie.setImage("/static/image/"+movie.getImage());
        }
        System.out.println(movieList);
        return new ResponseData(movieList);
    }

    @Override
    public ResponseData getMovieByID() {
//        String id;
//        Movie movie = movieMapper.selectByPrimaryKey(id);
        return null;
    }
}
