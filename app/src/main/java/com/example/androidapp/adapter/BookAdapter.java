package com.example.androidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.pojo.BookModel;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private List<BookModel> listBook;
    private LayoutInflater layoutInflater;

    public BookAdapter(Context context, List<BookModel> listBooks){
        this.listBook = listBooks;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listBook.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = layoutInflater.inflate(R.layout.book_layout, parent, false);
        }
        BookModel bookModel = (BookModel) getItem(position);
        TextView textViewName = view.findViewById(R.id.txtName);
        TextView textViewAuthor = view.findViewById(R.id.txtAuthor);
        TextView textViewLang = view.findViewById(R.id.txtLanguage);

        textViewName.setText(bookModel.getName());
        textViewAuthor.setText(bookModel.getAuthors());
        textViewLang.setText(bookModel.getLanguage());

        return view;
    }
}
