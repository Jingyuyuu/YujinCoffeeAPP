package tw.mymis.yujincoffeeapp.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tw.mymis.yujincoffeeapp.R;

public class indextAdapter extends RecyclerView.Adapter <indextAdapter.ViewHolder> {

    SQLiteDatabase db;
    ArrayList<SimpleIndext> restAll;
    public indextAdapter(SQLiteDatabase db) {
        this.db = db;
        restAll = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from restaurant;", null );
        //請將資料轉成 adapter 本的資料結構備用 以免 db被系統回收關閉
        if( cursor.getCount() > 0 ) {
            cursor.moveToFirst();
            do {
                SimpleIndext simpleIndext = new SimpleIndext(
                        cursor.getString(0)
                );
                restAll.add(simpleIndext);
            }while ( cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    @NonNull
    @Override
    public indextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull indextAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
