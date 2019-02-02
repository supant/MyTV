package com.example.antoine.mytv.apitv7j;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TVServiceTV7J {
	
	//Programme d'une chaine pour une date et une periode
	@GET("tranches/{param}")
	Call<ResponseBody>  pgChaine(@Path("param") String param);
 
 
 /* @GET("motors/set/goto/{motorId}:{valeur}:{duree}")
  Call<ResponseBody> gotoMotor(@Path("motorId") String motorId,@Path("valeur") String valeur,@Path("duree") String duree);
  */
}

