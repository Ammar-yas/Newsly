package com.intdv.newsly.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intdv.newsly.R;
import com.intdv.newsly.model.NewsArticle;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopHeadlinesAdapter extends RecyclerView.Adapter<TopHeadlinesAdapter.HeadLineViewHolder> {

    private Context context;
    private List<NewsArticle> articles;

    public TopHeadlinesAdapter(Context context, List<NewsArticle> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public HeadLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headlines_item, parent, false);
        return new HeadLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadLineViewHolder holder, int position) {
        NewsArticle newsArticle = articles.get(position);
        holder.title.setText(newsArticle.getTitle());
        holder.description.setText(newsArticle.getDescription());
        Picasso.get().load(newsArticle.getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class HeadLineViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.headlineItemTitleTV)
        TextView title;
        @BindView(R.id.headlineItemDescriptionTV)
        TextView description;
        @BindView(R.id.headlineItemIV)
        ImageView image;

        public HeadLineViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
