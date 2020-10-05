package a.room.with.a.view.screens.list

import a.room.with.a.view.databinding.ItemEntryBinding
import a.room.with.a.view.room.entity.IconInformation
import a.room.with.a.view.room.entity.SearchEntity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var items = listOf<SearchEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemEntryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    fun setItems(items: List<SearchEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ItemViewHolder(
        private val itemBinding: ItemEntryBinding,
        private val listener: ItemListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        private lateinit var item: SearchEntity

        init {
            itemBinding.root.setOnClickListener {
                item.venueId?.let { listener.onClickedCharacter(it) }
            }
        }

        fun bind(item: SearchEntity) {
            this.item = item
            itemBinding.name.text = item.venueName
            itemBinding.address1.text = item.formattedAddress
            itemBinding.address2.text = item.location
            item.icons?.let {
                (Gson()).fromJson<List<IconInformation>>(
                    it,
                    object : TypeToken<List<IconInformation>>() {}.type
                )?.getOrNull(0)?.apply {
                    itemBinding.image.setImageURI("${prefix}64${suffix}")
                }
            }
        }
    }

    interface ItemListener {
        fun onClickedCharacter(venueId: String)
    }
}