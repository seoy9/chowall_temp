package hong.sy.recommend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import hong.sy.recommend.databinding.ActivityRecommendResultBinding

class Recommend_Result : AppCompatActivity() {
    private lateinit var binding: ActivityRecommendResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecommendResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        setRecyclerView()
    }

    private fun setToolbar() {
        val toolbar = binding.toolbarMain
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_icon)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setRecyclerView() {
        val rvResult = binding.rvRecommendResult

        rvResult.adapter = RecommendResultAdapter(getList(), this)
        rvResult.addItemDecoration(VerticalItemDecorator(100))
    }

    private fun getList(): ArrayList<RecommendResult> {
        val list = arrayListOf<RecommendResult>()

        list.add(RecommendResult("img_recommend_result", "recommend_result_title", "recommend_result_c1", "recommend_result_c2", "recommend_result_c3", "recommend_result_c4"))
        list.add(RecommendResult("img_recommend_result", "recommend_result_title", "recommend_result_c1", "recommend_result_c2", "recommend_result_c3", "recommend_result_c4"))
        list.add(RecommendResult("img_recommend_result", "recommend_result_title", "recommend_result_c1", "recommend_result_c2", "recommend_result_c3", "recommend_result_c4"))
        list.add(RecommendResult("img_recommend_result", "recommend_result_title", "recommend_result_c1", "recommend_result_c2", "recommend_result_c3", "recommend_result_c4"))

        return list
    }
}