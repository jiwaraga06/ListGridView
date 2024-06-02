package com.example.listgridview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyGridView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_grid_view)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecycleView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)

        val itemList = listOf(
            MyItemListView("https://cdn-icons-png.freepik.com/512/3135/3135715.png?ga=GA1.1.250746295.1717321429", "Raga","hallo raga"),
            MyItemListView("https://cdn-icons-png.freepik.com/512/3135/3135789.png?ga=GA1.1.250746295.1717321429","Andi","Apa kabar ?"),
        )
        val adapter = MyAdapterListView(itemList)
        recyclerView.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}