package www.rejoin.com.one_code.notification

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_photo.*
import www.rejoin.com.one_code.R
import java.io.File

class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        initView()
    }

    private fun initView() {
        var imageUri: Uri
        take_photo.setOnClickListener {
            val outputImage = File(externalCacheDir, "output.jpg")
            if (outputImage.exists()) {
                outputImage.delete()
                outputImage.createNewFile()
            }
            if (Build.VERSION.SDK_INT >= 24) {
                imageUri = FileProvider.getUriForFile(this@PhotoActivity, "com.rejoin.fileprovider", outputImage)
            } else {
                imageUri = Uri.fromFile(outputImage)
            }
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, 1)
        }

        open_album.setOnClickListener {
            val intent = Intent("android.intent.action.GET_CONTENT")
            intent.setType("image/*")
            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}
