package com.yan.service;

import com.yan.entity.*;
import com.yan.mapper.CommentMapper;
import com.yan.mapper.MovieMapper;
import com.yan.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.mscapi.RSACipher;

import java.util.ArrayList;
import java.util.Date;
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
        User user = new User();
        for(Comment comment:comments){
            user = userFeignClient.getUserByID(comment.getUserid()).getData().get(0);
            System.out.println("feignClient query user: "+user);
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
    @Transactional
    public ResponseData addComment(RequestData requestData){
        if(requestData == null){
            return null;
        }
        Movie movie = movieMapper.selectByPrimaryKey(requestData.getMovieID());
        if (movie == null){
            System.out.println("movie is null!!! ");
            return null;
        }
        Comment comment = new Comment();
        comment.setComment(requestData.getComment());
        comment.setMovieid(requestData.getMovieID());
        comment.setUserid(requestData.getUserID());
        comment.setVote(0);

        commentMapper.insertSelective(comment);
        movie.getCommentList().add(comment);
        movieMapper.updateByPrimaryKey(movie);
        return new ResponseData();
    }

    public ResponseData getMovieByExample(RequestData requestData){
        if (requestData == null){
            return this.getMovieList();
        }
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();

        if(requestData.getReleaseDate() != null){
            String p = requestData.getReleaseDate();
            criteria.andReleaseDateIsNotNull();
            String time = p + "-00-00";
            String time2 = String.valueOf(Integer.parseInt(p) + 1) + "-00-00";
            Date date1 = DateUtil.format(time);
            Date date2 = DateUtil.format(time2);
            criteria.andReleaseDateBetween(date1, date2);
        }
        if(requestData.getMovieName() != null){
            criteria.andMovieNameIsNotNull();
            criteria.andMovieNameLike(requestData.getMovieName());
        }

        List<Movie> movieList = movieMapper.selectByExample(movieExample);
        System.out.println(movieList);
        for (Movie movie:movieList) {
            movie.setImage("/image/"+movie.getImage());
            if(requestData.getMovieName() != null){
                List<Comment> comments = this.getCommentListByMovieID(movie.getId());
                User user = new User();
                for(Comment comment:comments){
                    user = userFeignClient.getUserByID(comment.getUserid()).getData().get(0);
                    System.out.println("feignClient query user: "+user);
                    comment.setUserName(user.getName());
                }
                movie.setCommentList(comments);
            }
        }

        return new ResponseData(movieList);
    }
}
