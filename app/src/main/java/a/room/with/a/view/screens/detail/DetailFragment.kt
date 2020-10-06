package a.room.with.a.view.screens.detail

import a.room.with.a.view.R
import a.room.with.a.view.common.BaseFragment
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.PhotoInfo
import a.room.with.a.view.screens.VenueViewModel
import a.room.with.a.view.util.Resource
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.imagepipeline.image.ImageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*


@AndroidEntryPoint
class DetailFragment : BaseFragment(){
    private lateinit var venueViewModel :VenueViewModel
    private lateinit var listener :BaseControllerListener<ImageInfo?>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = object : BaseControllerListener<ImageInfo?>() {
            override fun onIntermediateImageSet(id: String, imageInfo: ImageInfo?) {
                updateViewSize(imageInfo)
            }

            override fun onFinalImageSet(id: String, imageInfo: ImageInfo?, animatable: Animatable?) {
                updateViewSize(imageInfo)
            }
        }


        venueViewModel = ViewModelProvider(requireActivity()).get(VenueViewModel::class.java)
        venueViewModel.detailsLiveData.observe(viewLifecycleOwner, Observer {
            setupView(it)
        })

        arguments?.getString("id")?.let { venueViewModel.details(it) }

        action.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action, null))
    }

    fun setupView(resource: Resource<DetailEntity>){
            viewConfigState(resource)
            when(resource.status){
                Resource.Status.SUCCESS -> {
                    resource.data?.let { response ->
                        venu_name.text = response.venueName
                        description.text = response.description
                         ratingbar.rating = (response.ratings?:0).toFloat()
                        short_url.text = response.shortUrl

                        val photoPath = response.run {
                            if (photos?.isNotBlank() == true && !photos.equals("[]", false)) {
                                val items = (Gson()).fromJson<List<PhotoInfo>>(
                                    photos,
                                    object : TypeToken<List<PhotoInfo>>() {}.type
                                )
                                items?.getOrNull(0)?.run { "${this.prefix}500x500${this.suffix}" }
                            } else {
                                null
                            }
                        }

                        if (photoPath?.isNotBlank() == true) {
                            var controllerBuilder = Fresco.newDraweeControllerBuilder()
                            val controller: DraweeController =
                                (controllerBuilder as PipelineDraweeControllerBuilder)
                                    .setControllerListener(listener)
                                    .setUri(photoPath)
                                    .setOldController(best_photo.controller)
                                    .build()
                            best_photo.controller = controller


                            best_photo.visibility = View.VISIBLE
                        } else {
                            best_photo.visibility = View.GONE
                        }

                    }
                }
            }
    }

    fun updateViewSize(imageInfo: ImageInfo?) {
        if (imageInfo != null) {
            best_photo.layoutParams.width = imageInfo.getWidth();
            best_photo.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            best_photo.aspectRatio = imageInfo.width.toFloat() / imageInfo.height.toFloat();
        }
    }
}