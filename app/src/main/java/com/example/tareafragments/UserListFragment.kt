package com.example.tareafragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class UserListFragment : Fragment() {

    private lateinit var rvUser: RecyclerView


    //private var userId: String? = null

    //override fun onCreate(savedInstanceState: Bundle?) {
      //  super.onCreate(savedInstanceState)
       // arguments?.let{
    //    userId = it.getString(ARG_USER_ID)
      //  }
   // }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvUser = view.findViewById(R.id.rv_user)
        val gson = Gson()
        val userResponse: ResultResponse =
            gson.fromJson(FakeData.usersJson, ResultResponse::class.java)


        rvUser.adapter = UserAdapter(userResponse.users) { user ->
            val fg = UserDetailFragment.newInstance(user.email)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                replace(R.id.fcv_fragment, fg, "UserDetailFragment")
            }
        }
        rvUser.layoutManager = GridLayoutManager(context, 2)
    }

    companion object {
        private const val ARG_USER_ID = "user_id"
        @JvmStatic
        fun newInstance(userID: String): UserDetailFragment {
            val fg = UserDetailFragment()
            val bundle = Bundle()
            bundle.putString(ARG_USER_ID, userID)
                fg.arguments = bundle
            return fg
        }
    }
}