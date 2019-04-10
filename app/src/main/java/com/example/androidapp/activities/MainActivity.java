package com.example.androidapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.androidapp.R;
import com.example.androidapp.adapter.BookAdapter;
import com.example.androidapp.pojo.BookModel;
import com.example.androidapp.retrofit.LibraryApi;
import com.example.androidapp.retrofit.RetrofitImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<BookModel> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        initData();
    }

    private ArrayList<BookModel> initData() {

        final LibraryApi libraryApi = RetrofitImpl.getRetrofit().create(LibraryApi.class);
        final Call<List<BookModel>> books = libraryApi.getBooks();

        books.enqueue(new Callback<List<BookModel>>() {
            @Override
            public void onResponse(Call<List<BookModel>>call, Response<List<BookModel>> response) {
                Log.i("DEV", "response " + response.body().size());
                result = response.body();
                setList(response.body());
            }
            @Override
            public void onFailure(Call<List<BookModel>> call, Throwable t) {
                Log.e("DEV", "failure " + t);
            }
        });
        return new ArrayList<>();

    }

    private void setList(List<BookModel> body) {
        final BookAdapter bookAdapter = new BookAdapter(this, body);
        listView.setAdapter(bookAdapter);
    }

}
