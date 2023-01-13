package hong.sy.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import android.widget.TextView
import hong.sy.recommend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        setContentColor()

        binding.btnSearchQ1.setOnClickListener {
            val intent = Intent(this, Recommend_Q2::class.java)
            startActivity(intent)
        }
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

    private fun setContentColor() {
        content = binding.tvQ1
        val textData = content.text.toString()
        val builder = SpannableStringBuilder(textData)
        val colorMainSpan = ForegroundColorSpan(getResources().getColor(R.color.main))
        builder.setSpan(colorMainSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        content.text = builder
    }
}