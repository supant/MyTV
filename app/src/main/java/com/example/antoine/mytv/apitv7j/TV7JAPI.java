package com.example.antoine.mytv.apitv7j;

import com.example.antoine.mytv.MessageEventErreur;
import com.example.antoine.mytv.MessageEventGrille;
import com.example.antoine.mytv.jsonpojo7.Programme;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TV7JAPI  {

	// Classe realisee en synchrone

	private TVServiceTV7J service;
	public static String ENTETE_TV7="http://www.programme-television.org/";
	public static String ENTETE_IMDB="http://www.imdb.com/find?&q=";
	public static String ENTETE_TELERAMA="http://www.telerama.fr/recherche/recherche.php?query=";

	public TV7JAPI() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.programme-television.org/var/t7j/storage/json/")
				.addConverterFactory(GsonConverterFactory.create()).build();

		service = retrofit.create(TVServiceTV7J.class);

		/*
		 * En asynchrone �a ferait : Call<ResponseBody> toto=service.listMoteur();
		 * toto.enqueue(this);
		 */

	}

	public void pgChaine(int chaine,Date date,int periode) {
		String sResponse="";
		String param = ""+chaine+"_";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    param=param+format.format(date);
		param=param+"_t"+periode;

		Call<ResponseBody> req = service.pgChaine(param);
		req.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response) {
				// handle success

				Gson gson = new Gson();
				Programme monpg=null;
				try {
					monpg = gson.fromJson(cutDebuttv7j(new String(response.body().bytes())), Programme.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (monpg!=null) {
					MessageEventGrille me = new MessageEventGrille();
					for(int i=0; i<monpg.getGrille().getADiffusion().size();i++) {
						me.addtListTitle(monpg.getGrille().getADiffusion().get(i));
					}
					me.setChaine(monpg.getGrille().getNomChaine());

					EventBus.getDefault().post(me);
				} else {
					MessageEventErreur me = new MessageEventErreur();
					me.setErreur("erreur "+call.toString());
					EventBus.getDefault().post(me);
				}

			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t) {
				MessageEventErreur me = new MessageEventErreur();
				me.setErreur("erreur "+call.toString());
				EventBus.getDefault().post(me);
			}
		});
	}






	/*
	 * public ListChaine listeDesChaines() { ListChaine lc = new ListChaine(); try {
	 * Call<ResponseBody> req=service.listeDesChaines(); Response<ResponseBody>
	 * response = req.execute(); if (response.code()==200) { //String sResponse =
	 * new String(response.body().bytes());
	 * System.out.println(response.body().getClass()); } else
	 * erreur("Error listeDesChaines "+response.code()); } catch (IOException e) {
	 * //e.printStackTrace(); erreur("Error listeDesChaines IOException"); }
	 * 
	 * return lc; }
	 */

	private void erreur(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}


	
	public String cutDebuttv7j(String s) {
		String result="";
		int debut = s.indexOf('{');
		result = s.substring(debut, s.length()-2);
		return result;
	}
	
	public static int ARTE=111;
	public static int CPLUS=34;
	public static int CDECALE=30;
	public static int CSPORT=35;
	public static int CCINEMA=33;
	public static int CFAMILY=657;
	public static int CSERIE=1563;
	public static int OCSMAX=730;
	public static int OCSCHOC=732;
	public static int OCSCITY=733;
	public static int SUNDANCE=833;
	
	public static int nuit=1; //5h-8h
	public static int matin=2; //8h-12h
	public static int apm=3; //12h-16h
	public static int finapm=4; //16h-20h
	public static int soir=5;  //20h-0h
	public static int debutnuit=6; //0h-5h


	public static String getNomChaine(int chaine) {
		if (chaine==ARTE) return "Arte";
		if (chaine==CPLUS) return "Canal+";
		if (chaine==CDECALE) return "Canal+ Décalé";
		if (chaine==CSPORT) return "Canal+ Sport";
		if (chaine==CCINEMA) return "Canal+ Cinéma";
		if (chaine==CFAMILY) return "Canal+ Family";
		if (chaine==CSERIE) return "Canal+ Séries";
		if (chaine==OCSMAX) return "OCS Max";
		if (chaine==OCSCHOC) return "OCS Choc";
		if (chaine==OCSCITY) return "OCS City";
		if (chaine==SUNDANCE) return "Sundance TV";

		return "";
	}
}
