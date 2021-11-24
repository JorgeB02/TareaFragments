package com.example.tareafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fcv_fragment, UserListFragment(), "UserDetailFragment")
            .commit()

        findViewById<TextView>(R.id.tv_bottom).setOnClickListener {
            val fg = UserDetailFragment()
            val bundle = Bundle()
            bundle.putString("user_id", "1")
            fg.arguments = bundle
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                    .replace(R.id.fcv_fragment, fg, "UserDetailFragment")
            }
        }
    }
}