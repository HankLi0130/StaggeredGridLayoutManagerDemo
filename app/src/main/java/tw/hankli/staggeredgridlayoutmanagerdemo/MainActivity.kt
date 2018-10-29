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

        for (n in 1..12) {

            val photoRes = when (n % 4) {
                0 -> R.drawable.photo_0
                1 -> R.drawable.photo_1
                2 -> R.drawable.photo_2
                3 -> R.drawable.photo_3
                else -> Color.TRANSPARENT
            }

            items.add(MyItem("Demo$n", photoRes))
        }
    }
}
