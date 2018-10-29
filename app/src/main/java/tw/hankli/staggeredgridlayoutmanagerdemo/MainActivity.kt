package tw.hankli.staggeredgridlayoutmanagerdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<MyItem>()

    private lateinit var adapter: MyAdapter

    private lateinit var layoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化資料
        initItems()

        // 設定 RecyclerView 屬性
        view_list.setHasFixedSize(true)

        // 設定 Adapter
        adapter = MyAdapter(items)
        view_list.adapter = adapter

        // 設定 LayoutManager
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        view_list.layoutManager = layoutManager
    }

    private fun initItems() {

        for (n in 1..100) {

            val color = when (n % 4) {
                0 -> Color.CYAN
                1 -> Color.DKGRAY
                2 -> Color.GRAY
                3 -> Color.MAGENTA
                else -> Color.TRANSPARENT
            }

            items.add(MyItem("$n", color))
        }
    }
}
