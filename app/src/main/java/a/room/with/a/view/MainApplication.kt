package a.room.with.a.view

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application(){

    @Inject
    lateinit var config : ImagePipelineConfig

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this, config)
    }
}