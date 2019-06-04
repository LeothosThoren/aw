package fr.airweb.news.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import fr.airweb.news.R
import fr.airweb.news.databinding.ActivityDetailBinding
import fr.airweb.news.model.remote.news_model.NewsItem
import fr.airweb.news.view.utils.ITEM_NEWS_EXTRA
import fr.airweb.news.view_model.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        // init configuration
        configureToolbar()

        // Retrieve data
        val homeData = intent.getParcelableExtra(ITEM_NEWS_EXTRA) as NewsItem
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.apply {
            getTitle().value = (homeData.title)
            getContent().value = (homeData.content)
            getPicture().value = (homeData.picture)
        }

        binding.itemNewsViewModel = viewModel
    }

    //***************
    // Configuration
    //***************


    // Toolbar

    private fun configureToolbar() {
        setSupportActionBar(binding.detailToolbar)
        binding.detailToolbar.title = getString(R.string.toolbar_title)
        binding.detailToolbar.subtitle = getString(R.string.toolbar_subtitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_activity_menu, menu)
        return true
    }
}
