package com.example.ownbotapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ownbotapi.model.Definition;
import com.example.ownbotapi.model.Word;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RequestQueue queue;

    private RecyclerView mRecyclerView;
    private OwlBotAdapter mAdapter;
    private RecyclerView.LayoutManager mLayout;

    private ArrayList<Word> mWords;

    public static final String TAG = "test";

    String url;

    final String API_TOKEN = "9ea49e1ccb828fd7736d981aa3b027571da9ae86";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWords = new ArrayList<Word>();


        mRecyclerView = findViewById(R.id.recyclerView);
        mLayout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayout);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new OwlBotAdapter(mWords, this);
        mRecyclerView.setAdapter(mAdapter);

        fakeWords();
    }

    public void fakeWords() {


//        Definition definition = new Definition("noun", "test def", "a lion stands ready to attack",
//                "https://media.owlbot.info/dictionary/images/ooooow.jpg.400x400_q85_box-23,22,478,477_crop_detail.jpg",
//                "");

        List<Definition> definitions;


       /* List<Definition> definitions1 = null;
        mWords.add(new Word(definitions1, "Test Word", "Test Pronounciation"));*/
    }

    public void exitBtn(View v) {
        finish();
    }

    public void addBtn(View v) {
        enterData();
    }


    private void enterData() {
        String base = "https://owlbot.info/api/v4/dictionary/";
        editText = findViewById(R.id.searchTxt);
        String wordUrl = editText.getText().toString();

        sendRequest(base + wordUrl);
    }

    private void sendRequest(String url) {
        if (queue == null) {
            queue = Volley.newRequestQueue(this);
        }

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: " + response);
                        parseJson(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("MAIN", "That did not work!", error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                //  return super.getHeaders();

                Map<String, String> map = new HashMap<>();
                map.put("Authorization", "Token " + API_TOKEN);
                return map;
            }
        };

        queue.add(jsonObjectRequest);

    }

    private void parseJson(String json) {
        Gson gson = new GsonBuilder().create();
        Word word = gson.fromJson(json, Word.class);
        if (word != null) {
            mWords.add(word);
            word.getDefinitions().get(0).getImageUrl();
            mAdapter.notifyDataSetChanged();
        }
    }
}
