package com.example.faq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class versionadapter extends RecyclerView.Adapter<versionadapter.versionVH>{
    List<version> versionList;

    public versionadapter(List<version> versionList) {
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public versionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new versionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull versionVH holder, int position) {
    version version=versionList.get(position);
    holder.codeNameTxt.setText(version.getCodeName());
        holder.versionTxt.setText(version.getVersion());
        holder.apilevelTxt.setText(version.getApiLevel());
        holder.descriptionTxt.setText(version.getDescription());

        boolean isExpandable = versionList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable? View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public class versionVH extends RecyclerView.ViewHolder {
        TextView codeNameTxt,versionTxt,apilevelTxt,descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;
        public versionVH(@NonNull View itemView) {
            super(itemView);

            codeNameTxt=itemView.findViewById(R.id.code_name);
            versionTxt=itemView.findViewById(R.id.version);
            apilevelTxt=itemView.findViewById(R.id.api_level);
            descriptionTxt=itemView.findViewById(R.id.description);

            linearLayout=itemView.findViewById(R.id.linear_layout);
            expandableLayout=itemView.findViewById(R.id.expadabale_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    version version= versionList.get(getAdapterPosition());
                    version.setExpandable(!version.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
