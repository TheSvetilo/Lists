package com.example.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.lists.databinding.ActivityListViewBinding
import com.example.lists.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListViewBinding.inflate(layoutInflater).also { setContentView(it.root) }

//        setupSimpleListView()
        setupSimpleListViewGeneratedData()
    }

    private fun setupSimpleListViewGeneratedData() {
        val data = (1..100).map {
            mapOf(
                KEY_TITLE to "Title #$it",
                KEY_DESC to "Description #$it"
            )
        }

        val adapter = SimpleAdapter(
            this,
            data,
            R.layout.item_custom,
            arrayOf(KEY_TITLE, KEY_DESC),
            intArrayOf(R.id.textTitle, R.id.textDescription)
        )

        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemTitle = data[position][KEY_TITLE]
                val selectedItemDescription = data[position][KEY_DESC]

                val dialog = AlertDialog.Builder(this)
                    .setTitle(selectedItemTitle)
                    .setMessage(selectedItemDescription)
                    .setPositiveButton("Ok") { dialog, whitch -> }
                    .create()

                dialog.show()
            }
    }

    private fun setupSimpleListView() {

        val data = listOf(
            mapOf(
                KEY_TITLE to "First Title",
                KEY_DESC to "The first some description."
            ),
            mapOf(
                KEY_TITLE to "Second Title",
                KEY_DESC to "The second some description."
            ),
            mapOf(
                KEY_TITLE to "Third Title",
                KEY_DESC to "The third some description."
            )
        )

        val adapter = SimpleAdapter(
            this,
            data,
            R.layout.simple_list_item_2,
            arrayOf(KEY_TITLE, KEY_DESC),
            intArrayOf(R.id.text1, R.id.text2)
        )

        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItemTitle = data[position][KEY_TITLE]
                val selectedItemDescription = data[position][KEY_DESC]

                val dialog = AlertDialog.Builder(this)
                    .setTitle(selectedItemTitle)
                    .setMessage(selectedItemDescription)
                    .setPositiveButton("Ok") { dialog, whitch -> }
                    .create()

                dialog.show()
            }
    }

    companion object {
        const val KEY_TITLE = "title"
        const val KEY_DESC = "description"
    }

}