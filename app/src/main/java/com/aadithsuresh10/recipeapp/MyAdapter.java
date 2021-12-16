package com.aadithsuresh10.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<FoodViewHolder>{

    private Context mContext;
    private List<FoodData> myFoodList;

    public MyAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup,false);
        return new FoodViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int i) {

        holder.imageview.setImageResource(myFoodList.get(i).getItemimage());
        holder.mTitle.setText(myFoodList.get(i).getItemName());
        holder.mDescription.setText(myFoodList.get(i).getItemDescription());
        holder.mPrice.setText(myFoodList.get(i).getViewAll());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if(i==0)
                {
                    intent = new Intent(mContext, Sweets.class);
                    mContext.startActivity(intent);
                }
                else if(i==1)
                {
                    intent = new Intent(mContext, VegDishes.class);
                    mContext.startActivity(intent);
                }
                else if(i==2)
                {
                    intent = new Intent(mContext, EggDishes.class);
                    mContext.startActivity(intent);
                }
                else if(i==3)
                {
                    intent = new Intent(mContext, Nveg.class);
                    mContext.startActivity(intent);
                }
                else if(i==4)
                {
                    intent = new Intent(mContext, Milkshakes.class);
                    mContext.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder
{

    ImageView imageview;
    TextView mTitle;
    TextView mDescription;
    TextView mPrice;
    CardView mCardView;

    public FoodViewHolder(View itemView) {
        super(itemView);

        imageview = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mPrice = itemView.findViewById(R.id.tvPrice);

        mCardView = itemView.findViewById(R.id.myCarView);


    }
}