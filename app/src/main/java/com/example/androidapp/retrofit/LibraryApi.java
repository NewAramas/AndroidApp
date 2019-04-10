package com.example.androidapp.retrofit;

import com.example.androidapp.pojo.BookModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LibraryApi {

    @GET("books")
    Call<List<BookModel>> getBooks();
}
