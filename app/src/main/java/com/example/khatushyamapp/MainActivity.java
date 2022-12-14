package com.example.khatushyamapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    ImageView imageView;
    TextView fsname,lsname,userid,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler =findViewById(R.id.recycle);

        //listingdata();
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(llm);
        ApiInterface apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);
        Call<BhaktiMyModal> listingdata=apiInterface.getWallPaper();
        listingdata.enqueue(new Callback<BhaktiMyModal>() {
            @Override
            public void onResponse(Call<BhaktiMyModal> call, Response<BhaktiMyModal> response) {
                if (response.isSuccessful())
                {

                    recycleadapter recycleadapter = new recycleadapter(response.body().getWallpapers());
                    recycler.setAdapter(recycleadapter);

                }

            }

            @Override
            public void onFailure(Call<BhaktiMyModal> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

    /*   private void listingdata() {
           ApiInterface apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);
           Call<Pojo> listingdata=apiInterface.getData();
           listingdata.enqueue(new Callback<Pojo>() {
               @Override
               public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                   if (response.isSuccessful())
                   {

                       recycleadapter recycleadapter = new recycleadapter(response.body().getData());
                       recycler.setAdapter(recycleadapter);

                   }

               }

               @Override
               public void onFailure(Call<Pojo> call, Throwable t) {
                   Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();

               }
           });
       }

    */   class recycleadapter extends RecyclerView.Adapter<recycleadapter.MyViewHolder>
    {
        List<BhaktiMyModal.Wallpaper>list;
        public recycleadapter(List<BhaktiMyModal.Wallpaper>list){
            this.list=list;
        }

        @NonNull
        @Override
        public recycleadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
            recycleadapter.MyViewHolder viewHolder = new recycleadapter.MyViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull recycleadapter.MyViewHolder holder, int position) {
            holder.email.setText(list.get(position).getViews());
            holder.fsname.setText(list.get(position).getTitle());
            //holder.Lsname.setText(list.get(position).getLastName());
            String BASE_URl="https://bhaktidarshan.in/APP/wallpapers/uploads/wallpapers/";

            Picasso.with(getApplicationContext())
                    .load(BASE_URl+list.get(position).getImgavatar())
                    .placeholder(R.drawable.ic_launcher_background)
                    .fit()
                    .into(holder.imageView);
        }
        @Override
        public int getItemCount() {
            return list.size();}

        class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView fsname, userid,Lsname,email;
            ImageView imageView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                email=itemView.findViewById(R.id.email);
                fsname = itemView.findViewById(R.id.userid);
                imageView =itemView.findViewById(R.id.imgs);
            }
        }
    }
}