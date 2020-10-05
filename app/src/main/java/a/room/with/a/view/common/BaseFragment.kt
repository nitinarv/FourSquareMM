package a.room.with.a.view.common

import a.room.with.a.view.R
import a.room.with.a.view.response.detail.DetailsResponse
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.util.Resource
import a.room.with.a.view.util.Resource.Status
import a.room.with.a.view.util.Resource.Status.*
import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

open class BaseFragment : Fragment() {

    fun viewConfigState(resource: Resource<*>){
        val loading = view?.findViewById<LottieAnimationView>(R.id.loading)
        val empty = view?.findViewById<LottieAnimationView>(R.id.empty)
        val tryagain = view?.findViewById<LottieAnimationView>(R.id.tryagain)
        val background = view?.findViewById<View>(R.id.background)
        when(resource.status){
            EMPTY -> {
                loading?.visibility = View.GONE
                empty?.visibility = View.VISIBLE
                tryagain?.visibility = View.GONE
                background?.visibility = View.VISIBLE
            }
            ERROR -> {
                loading?.visibility = View.GONE
                empty?.visibility = View.GONE
                tryagain?.visibility = View.VISIBLE
                background?.visibility = View.VISIBLE
                Toast.makeText(requireActivity(), resource.message, Toast.LENGTH_SHORT).show()
            }
            LOADING -> {
                loading?.visibility = View.VISIBLE
                tryagain?.visibility = View.GONE
                empty?.visibility = View.GONE
                background?.visibility = View.VISIBLE
            }
            SUCCESS -> {
                loading?.visibility = View.GONE
                tryagain?.visibility = View.GONE
                empty?.visibility = View.GONE
                background?.visibility = View.GONE
            }
        }
    }

    fun hideKeyboard() {
        val config = requireActivity().resources.configuration
        if (config.hardKeyboardHidden != 1) {
            val inputManager =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            requireActivity().currentFocus?.let {
                inputManager.hideSoftInputFromWindow(
                    it.windowToken,
                    0
                )
            }
        }
    }

}