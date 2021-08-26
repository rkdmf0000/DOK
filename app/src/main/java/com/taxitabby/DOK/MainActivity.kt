
package com.taxitabby.DOK


import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //status remove
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)


        var data : Array<String> = arrayOf("하나","둘")

        val hackedRecyclerView : RecyclerView = findViewById(R.id.hackedList)
        val hackedRecyclerAdapter : AdapterOfTargetTheHacked = AdapterOfTargetTheHacked(data)

        val layoutManager = LinearLayoutManager(this)
        hackedRecyclerView.layoutManager = layoutManager

        hackedRecyclerView.adapter = hackedRecyclerAdapter

        hackedRecyclerView.setOnClickListener { Log.v("xxx", "hello!") }




// xml 에서 name 에 입력해서 필요없을듯?
//        val fm : FragmentManager = supportFragmentManager
//        val fragmentTs : FragmentTransaction = fm.beginTransaction()
//        fragmentTs.add(R.id.mainActivitySideSectionFragmentTag, FragmentOfMainActivitySideSection())
//        fragmentTs.commit()


    }
}