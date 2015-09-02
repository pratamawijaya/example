package com.pratamawijaya.mosbyexample.model.response;

import com.pratamawijaya.mosbyexample.model.Post;

import java.util.List;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/2/15
 * Project : MosbyExample
 */
public class ResponsePost {
    private List<Post> posts;
    private String status;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

