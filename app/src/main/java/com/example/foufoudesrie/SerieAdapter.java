package com.example.foufoudesrie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;  

class SerieAdapter extends ArrayAdapter<Serie> {
    private Context mContext;
    private List<Serie> SerieList = new ArrayList<>();

    public SerieAdapter(Context context, ArrayList<Serie> list) {
        super(context, 0, list);
        mContext = context;
        SerieList = list;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.itemlist,parent,false);
        Serie currentSerie = SerieList.get(position);
        TextView titre = (TextView) listItem.findViewById(R.id.titre);
        TextView resume = (TextView) listItem.findViewById(R.id.resume);
        TextView duree =(TextView)listItem.findViewById(R.id.duree) ;
       TextView premierediffusion= (TextView)listItem.findViewById(R.id.premiereDiff);
        ImageView poster = (ImageView) listItem.findViewById(R.id.imageView_poster);
        Picasso.get().load(currentSerie.getImage()).into(poster);
        titre.setText(currentSerie.getTitre());
        resume.setText(currentSerie.getResume());
        duree.setText((CharSequence) currentSerie.getDuree());
       premierediffusion.setText((CharSequence) currentSerie.getPremiereDiffusion());
        return listItem;
    }
}

