package com.example.viewmodel_livedata


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(context: Context, userDataList: ArrayList<UserDataList>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var context: Context
    var userDataList: ArrayList<UserDataList>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.user_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = userDataList[position]
        holder.id.text = item.id
        holder.name.text = item.name
        holder.button.setOnClickListener {
            //fun onClick(v: View?) {
                if (holder.button.getText() === "팔로잉") {
                    MainViewModel.decrease()//여기 로그로 확인점 해봐야겠다. 숫자가 안바뀌는건지 바꼈는데 변환이 안되는건지
                    holder.button.setBackgroundColor(Color.parseColor("#2196F3"))
                    holder.button.setTextColor(Color.parseColor("#FFFFFF"))
                    holder.button.setText("팔로우")
                    holder.button.isEnabled()
                } else {
                    MainViewModel.increase()
                    holder.button.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    holder.button.setTextColor(Color.parseColor("#000000"))
                    holder.button.setText("팔로잉")
                }
            //}
        }
    }

    override fun getItemCount(): Int {
        return userDataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView
        var name: TextView
        var button: Button

        init {
            id = itemView.findViewById(R.id.id)
            name = itemView.findViewById(R.id.name)
            button = itemView.findViewById(R.id.button)
        }
    }

    init {
        this.context = context
        this.userDataList = userDataList
    }
}
