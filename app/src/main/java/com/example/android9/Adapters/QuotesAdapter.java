package com.example.android9.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android9.Clicks.QuotesClick;
import com.example.android9.R;

import java.util.Locale;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesHolder>{

    String[] quotes;
    QuotesClick click;
    Context context;
    public QuotesAdapter(String[] quotes, QuotesClick click) {
        this.quotes = quotes;
        this.click = click;
    }
    @NonNull
    @Override
    public QuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_item,parent,false);
        return new QuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtQuotes.setText(quotes[position]);
        TextToSpeech tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
            }
        });
        tts.setLanguage(Locale.forLanguageTag("hi"));
        tts.setPitch(0.2f);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click.getQuote(quotes[position]);
//                Toast.makeText(context, ""+quotes[position], Toast.LENGTH_SHORT).show();
//                tts.speak(quotes[position], TextToSpeech.QUEUE_ADD, null,null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return quotes.length;
    }

    class QuotesHolder extends RecyclerView.ViewHolder {

        TextView txtQuotes;
        public QuotesHolder(@NonNull View itemView) {
            super(itemView);

            txtQuotes = itemView.findViewById(R.id.txtQuotes);

        }
    }

}
