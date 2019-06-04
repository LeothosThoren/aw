package fr.airweb.news.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import fr.airweb.news.R
import fr.airweb.news.listNews
import fr.airweb.news.model.remote.news_model.News
import fr.airweb.news.model.remote.news_model.NewsItem
import fr.airweb.news.view.utils.ITEM_NEWS_EXTRA
import fr.airweb.news.view_model.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var builder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        promptLoading()
        configureViewModel()

    }

    //***************
    // Configuration
    //***************

    private fun promptLoading() {
        builder = AlertDialog.Builder(this)
        builder.setMessage("Loading...")
        dialog = builder.create()
        dialog.show()
    }

    private fun disablePrompt() {
        dialog.dismiss()
    }

    private fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getApiRepository().observe(this, Observer<News> { data->
            configureRecyclerViewList(data.news as List<NewsItem>)
            disablePrompt()
        })
    }

    @SuppressLint("WrongConstant")
    private fun configureRecyclerViewList(list: List<NewsItem>) {
        itemList.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
        }

        itemList.withModels {
            var i = 0
            for (item in list) {
                listNews {
                    id("list${i++}")
                    news(item) //Define xml variable
                    onClick { data, _, _, position ->
                        val intent = Intent(this@HomeActivity, DetailActivity::class.java)
                        intent.putExtra(ITEM_NEWS_EXTRA, data.news())
                        startActivity(intent)

                    }
                }

            }
        }
    }
}
