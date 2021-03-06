package com.unipool.unipool;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<chat_data> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(chat_data data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    void init() {listData.clear();}

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView chat_userID;
        private TextView chat_Text;
        private  LinearLayout linearLayout;
        private EditText editText;

        ItemViewHolder(View itemView) {
            super(itemView);
            chat_userID = itemView.findViewById(R.id.chat_userID);
            chat_Text = itemView.findViewById(R.id.chat_Text);
            linearLayout = itemView.findViewById(R.id.chat_layout);
        }

        void onBind(chat_data data) {
            chat_userID.setText(data.getChat_userID());
            chat_Text.setText(data.getChat_Text());
            LinearLayout.LayoutParams layoutParams_userID = (LinearLayout.LayoutParams) chat_userID.getLayoutParams();
            LinearLayout.LayoutParams layoutParams_Text = (LinearLayout.LayoutParams) chat_Text.getLayoutParams();

            if(data.getMyText()==true) {
                chat_Text.setBackgroundResource(R.drawable.chat_image_right);
                layoutParams_userID.gravity = Gravity.RIGHT;
                layoutParams_Text.gravity = Gravity.RIGHT;
            }
            else {
                chat_Text.setBackgroundResource(R.drawable.chat_image);
                layoutParams_userID.gravity = Gravity.LEFT;
                layoutParams_Text.gravity = Gravity.LEFT;
            }
        }
    }
}
