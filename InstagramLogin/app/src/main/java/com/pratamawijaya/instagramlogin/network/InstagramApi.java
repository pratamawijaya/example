package com.pratamawijaya.instagramlogin.network;

import com.pratamawijaya.instagramlogin.models.ResponseToken;
import com.pratamawijaya.instagramlogin.models.UserMediaResponse;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/17/15
 * Project : InstagramLogin
 */
public interface InstagramApi {

  @FormUrlEncoded @POST("/oauth/access_token") Observable<ResponseToken> getToken(
      @Field("client_id") String clientID, @Field("client_secret") String clientSecret,
      @Field("grant_type") String grantType, @Field("redirect_uri") String redirectUri,
      @Field("code") String code);

  @GET("/v1/users/{id}/media/recent") Observable<UserMediaResponse> getUserMediaRecent(
      @Path("id") String userId, @Query("access_token") String accessToken);
}
