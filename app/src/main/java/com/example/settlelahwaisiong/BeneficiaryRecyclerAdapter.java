package com.example.settlelahwaisiong;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class BeneficiaryRecyclerAdapter extends RecyclerView.Adapter<BeneficiaryRecyclerAdapter.BeneficiaryViewHolder>  {


    private ArrayList<Beneficiary> listBeneficiary;
    public ImageView overflow;
    private Context mContext;
    private DatabaseHelper1 databaseHelper1;


    public BeneficiaryRecyclerAdapter(ArrayList<Beneficiary> listBeneficiary, Context mContext) {
        this.listBeneficiary = listBeneficiary;
        this.mContext = mContext;


    }

    public class BeneficiaryViewHolder extends RecyclerView.ViewHolder {


        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewAddress;
        public AppCompatTextView textViewCountry;
        ImageButton image1;
        ImageButton image2;

        public BeneficiaryViewHolder(View view) {
            super(view);
            image2 =(ImageButton) view.findViewById(R.id.imageButton7);

            image1 =(ImageButton) view.findViewById(R.id.imageButton6);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewAddress = (AppCompatTextView) view.findViewById(R.id.textViewAddress);
            textViewCountry = (AppCompatTextView) view.findViewById(R.id.textViewCountry);


        }

        }

    private void deletePlace( int position) {
        Beneficiary forgot  = listBeneficiary.get(position);

        DatabaseHelper1 databaseHelper1 = new DatabaseHelper1(mContext);

        databaseHelper1.removePlace(forgot.getId());
        listBeneficiary.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }


    @Override
    public BeneficiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_beneficiary_recycler, parent, false);

        return new BeneficiaryViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(final BeneficiaryViewHolder holder, final int position) {
        holder.textViewName.setText(listBeneficiary.get(position).getName());
        holder.textViewEmail.setText(listBeneficiary.get(position).getEmail());
        holder.textViewAddress.setText(listBeneficiary.get(position).getAddress());
        holder.textViewCountry.setText(listBeneficiary.get(position).getCountry());


        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePlace(position);
            }
        });
        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity3.class);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {

        return listBeneficiary.size();

    }

    public void setFilter(ArrayList<Beneficiary> newList){
        listBeneficiary= new ArrayList<>();
        listBeneficiary.addAll(newList);
        notifyDataSetChanged();
    }






}

