package com.pratamawijaya.mosbyexample.data;

import com.pratamawijaya.mosbyexample.model.response.ResponsePost;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by pratama on 5/31/15.
 */
public interface PratamaService {

    @GET("/get_recent_posts")
    public Observable<ResponsePost> getPosts();

    //@GET("/get_post/")
    //public Observable<ResponsePostDetail> getPost(@Query("post_id") int postId);
}
