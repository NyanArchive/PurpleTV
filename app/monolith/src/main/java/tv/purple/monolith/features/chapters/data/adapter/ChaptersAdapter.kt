package tv.purple.monolith.features.chapters.data.adapter

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tv.purple.monolith.bridge.RES_STRINGS
import tv.purple.monolith.core.util.ViewUtil.getView
import tv.purple.monolith.core.util.ViewUtil.inflate
import tv.purple.monolith.features.chapters.component.data.model.Chapter

class ChaptersAdapter(
    private val listener: OnChapterClickedListener
) : RecyclerView.Adapter<ChaptersAdapter.ChapterItemViewHolder>() {
    private var chapters: List<Chapter> = listOf()

    interface OnChapterClickedListener {
        fun onClicked(item: Chapter)
    }

    class ChapterItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val logo = view.getView<ImageView>(
            resName = RES_STRINGS.purpletv_chapters_item__logo
        )
        private val title = view.getView<TextView>(
            resName = RES_STRINGS.purpletv_chapters_item__title
        )
        private val timestamp = view.getView<TextView>(
            resName = RES_STRINGS.purpletv_chapters_item__timestamp
        )

        fun onBind(listener: OnChapterClickedListener, chapter: Chapter) {
            title.text = chapter.title
            timestamp.text = DateUtils.formatElapsedTime(chapter.timestamp.toLong())
            chapter.url?.let { url ->
                Glide.with(logo).load(url).into(logo)
            }
            itemView.setOnClickListener { listener.onClicked(item = chapter) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterItemViewHolder {
        return ChapterItemViewHolder(
            parent.inflate(
                resName = RES_STRINGS.purpletv_chapters_item,
                parent = parent
            )
        )
    }

    override fun onBindViewHolder(holder: ChapterItemViewHolder, position: Int) {
        holder.onBind(listener, chapters[position])
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chapters: List<Chapter>) {
        this.chapters = chapters
        notifyDataSetChanged()
    }
}