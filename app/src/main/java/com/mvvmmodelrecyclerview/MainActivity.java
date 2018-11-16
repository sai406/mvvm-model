package com.mvvmmodelrecyclerview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mvvmmodelrecyclerview.adapter.CustomAdapter;
import com.mvvmmodelrecyclerview.model.News;
import com.mvvmmodelrecyclerview.viewmodel.NewsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private List<NewsModel> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsList = new ArrayList<>();

        customAdapter = new CustomAdapter(newsList);
        recyclerView.setAdapter(customAdapter);
        fulldetails();

    }


    private void fulldetails() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req = new StringRequest(Request.Method.GET, "http://kansolvetec.com/androidapps/news.json", new Response.Listener<String>() {
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.d("typedata", "onResponse: " + response);
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        NewsModel newsModel = new NewsModel();


                        if (!obj.isNull("UserName")) {
                            newsModel.Title = (obj.getString("UserName"));
                        }
                        if (!obj.isNull("InstallationId")) {
                            newsModel.Desc = (obj.getString("InstallationId"));
                        }
                        if (!obj.isNull("Imagepath")) {
                            newsModel.Imagepath = (obj.getString("Imagepath"));
                        }

                        newsList.add(newsModel);

                    }
                    customAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {
        };

        queue.add(req);

    }
}
