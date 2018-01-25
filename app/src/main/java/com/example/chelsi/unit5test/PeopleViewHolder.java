package com.example.chelsi.unit5test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chelsi on 1/24/2018.
 */

public class PeopleViewHolder extends RecyclerView.ViewHolder {

    ImageView profilePicture;
    TextView personName;

    public PeopleViewHolder(View itemView) {
        super(itemView);

        profilePicture = itemView.findViewById(R.id.profile);
        personName = itemView.findViewById(R.id.name);

    }

    public void bind(People people){

        profilePicture.setImageResource(people.getImage());
        personName.setText(people.getName());
    }
}
