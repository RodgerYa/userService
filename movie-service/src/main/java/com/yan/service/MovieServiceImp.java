package com.yan.service;

import com.yan.entity.*;
import com.yan.mapper.CommentMapper;
import com.yan.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public ResponseData getMovieList() {
        List<Movie> movieList = movieMapper.selectMovieList();

        for (Movie movie:movieList) {
            movie.setImage("/image/"+movie.getImage());
        }
        System.out.println(movieList);
        return new ResponseData(movieList);
    }

    @Override
    public ResponseData getMovieByID(String id) {
        Movie movie = movieMapper.selectByPrimaryKey(id);
        System.out.println(movie);
        movie.setImage("/image/"+movie.getImage());
        List<Comment> comments = this.getCommentListByMovieID(id);
        User user = null;
        for(Comment comment:comments){
            user = userFeignClient.getUserByID(comment.getUserid()).getData().get(0);
            comment.setUserName(user.getName());
        }
        movie.setCommentList(comments);
        List<Movie> movieList=new ArrayList<>();
        movieList.add(movie);
        return new ResponseData(movieList);
    }

    @Override
    public List<Comment> getCommentList(){
        List<Comment> commentList = commentMapper.selectCommentList();
        //.........调用userService 通过id 获取 username
        System.out.println(commentList);
        return commentList;
    }

    @Override
    public List<Comment> getCommentListByMovieID(String movieID){
        List<Comment> commentList = commentMapper.selectCommentListByMovieID(movieID);
        return commentList;
    }

    @Override
    public ResponseData addComment(RequestData requestData){
        Movie movie = movieMapper.selectByPrimaryKey(requestData.getMovieID());
        Comment comment = null;
        comment.setComment(requestData.getComment());
        comment.setMovieid(requestData.getMovieID());
        comment.setUserid(requestData.getUserName());
        comment.setVote(0);
        movie.getCommentList().add(comment);
        movieMapper.updateByPrimaryKey(movie);
        return new ResponseData();
    }
}
