package com.pratamawijaya.retrofit20.data;

import com.pratamawijaya.retrofit20.model.Contributor;
import java.util.List;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 9/11/15
 * Project : Retrofit20
 */
public interface GithubService {
  @GET("repos/{owner}/{repo}/contributors") Call<List<Contributor>> contributors(
      @Path("owner") String owner, @Path("repo") String repo);

  //@GET("repos/{owner}/{repo}/contributors") Observable<List<Contributor>> contributors(
  //    @Path("owner") String owner, @Path("repo") String repo);
}
