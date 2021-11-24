package com.example.tareafragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

class UserDetailFragment : Fragment() {
    private var emailUser: String? = null
    private lateinit var tvFirstName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            emailUser = it.getString(ARG_USER_EMAIL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFirstName = view.findViewById(R.id.tv_name1)
        val gson = Gson()
        val userResponse : ResultResponse =
            gson.fromJson(FakeData.usersJson, ResultResponse::class.java)

        val user: UserResponse? = userResponse.users.firstOrNull{ emailUser == it.email}

        if (user == null) {
            Log.d("UserDetailFragment", "User not found")
            Toast.makeText(context, "User not found", Toast.LENGTH_SHORT)
        }
        tvFirstName.text = user?.name?.first
    }

    companion object {
        private const val ARG_USER_EMAIL = "user_email"

        @JvmStatic
        fun newInstance(param1: String) =
            UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_EMAIL, emailUser)
                }
            }
    }
}