package a.room.with.a.view.screens.list

import a.room.with.a.view.R
import a.room.with.a.view.common.BaseFragment
import a.room.with.a.view.room.entity.SearchEntity
import a.room.with.a.view.screens.VenueViewModel
import a.room.with.a.view.util.Resource
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.*


@AndroidEntryPoint
class ListFragment : BaseFragment() {
    private lateinit var venueViewModel: VenueViewModel
    private lateinit var listener: ItemAdapter.ItemListener
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        venueViewModel = ViewModelProvider(requireActivity()).get(VenueViewModel::class.java)
        venueViewModel.searchResultLiveData.observe(viewLifecycleOwner, Observer {
            setupView(it)
        })
        listener = object : ItemAdapter.ItemListener {
            override fun onClickedCharacter(venueId: String) {
                findNavController().navigate(
                    R.id.next_action,
                    bundleOf("id" to venueId)
                )
            }
        }

        adapter = ItemAdapter(listener)
        results_rv.layoutManager = LinearLayoutManager(requireContext())
        results_rv.adapter = adapter

        search_button.setOnClickListener {
            hideKeyboard()
            if(search_text.text?.isNotBlank()==true){
                venueViewModel.search(search_text.text.toString())
            }
        }
    }

    fun setupView(resource: Resource<List<SearchEntity>>) {
        viewConfigState(resource)
        when(resource.status){
            Resource.Status.SUCCESS -> {
                resource.data?.let {
                    if (it.isNotEmpty()) {
                        adapter.setItems(it)
                    } else {
                        viewConfigState(Resource.empty(it))
                    }
                }
            }
        }
    }
}