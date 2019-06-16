package jp.shiita.realmlivedata.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import dagger.android.support.DaggerAppCompatActivity
import jp.shiita.realmlivedata.R
import jp.shiita.realmlivedata.data.SimpleText
import jp.shiita.realmlivedata.data.SimpleTextDataSource
import org.joda.time.DateTime
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject lateinit var dataSource: SimpleTextDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.edit_button).setOnClickListener { startActivity(Intent(this, EditActivity::class.java)) }
        findViewById<Button>(R.id.show_button).setOnClickListener { startActivity(Intent(this, ShowActivity::class.java)) }
        findViewById<Button>(R.id.add_button).setOnClickListener { dataSource.addSimpleText(SimpleText(DateTime.now().toString("HH:mm:ss"))) }
        findViewById<Button>(R.id.delete_all_button).setOnClickListener { dataSource.deleteAllSimpleText() }
    }
}
