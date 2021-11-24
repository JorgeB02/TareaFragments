package com.example.tareafragments
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: List<UserResponse>,
private val listener: (UserResponse) -> Unit
):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.tvName.text = user.name.first + " " + user.name.last
        holder.tvPlace.text = user.location.country
        Glide.with(holder.ivAvatar.context).load(user.picture.medium).placeholder(R.drawable.th2).into(holder.ivAvatar);

        holder.itemView.setOnClickListener{
            listener(user)
        }
    }

    override fun getItemCount(): Int  = users.size

    inner  class  UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvPlace: TextView = view.findViewById(R.id.tv_countrie)
        var ivAvatar : ImageView = view.findViewById(R.id.iv_image)
    }
}