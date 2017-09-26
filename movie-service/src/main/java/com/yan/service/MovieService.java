package com.yan.service;

import com.yan.entity.ResponseData;
import org.springframework.stereotype.Service;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Service
public interface MovieService {

    public ResponseData getMovieList();

    public ResponseData getMovieByID();

}
