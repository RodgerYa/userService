package com.yan.service;

import com.yan.entity.Comment;
import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Service
public interface MovieService {

    public ResponseData getMovieList();

    public ResponseData getMovieByID(String id);

    public List<Comment> getCommentList();

    public ResponseData addComment(RequestData requestData);

    public List<Comment> getCommentListByMovieID(String movieID);
}
