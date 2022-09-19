package com.example.livedata.fragment


import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore.Images
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.livedata.R
import com.example.livedata.databinding.FragmentDetailBinding
import java.io.*
import java.util.*


class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentDetailBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        permissionChecked()
    }

    fun getData(){
        binding.product = args.dataProduct
    }


    fun permissionChecked(){
        if (activity?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.READ_EXTERNAL_STORAGE) } != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        } else {
            buyToWhatsApp()
        }
    }

    fun buyToWhatsApp() {

        val drawable = ContextCompat.getDrawable(requireActivity(), args.dataProduct.image.first().images)
        val bitmap = (drawable as BitmapDrawable).bitmap

        // Click listener for button widget
        binding.btnBuy.setOnClickListener {
            val uri: Uri = saveImageToExternalStorage(bitmap)
            val message = """
                halo, saya tertarik dengan produk
                ${args.dataProduct.name} dengan harga Rp. ${args.dataProduct.price},
                apakah masih available
            """.trimIndent()
                val whatsApp = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_TEXT, message)
                    putExtra(Intent.EXTRA_STREAM, uri)
                    type = "text/plain"
                    type = "image/jpeg"
                    `package` = "com.whatsapp"
                }
                startActivity(whatsApp)
        }
    }
    fun saveImageToExternalStorage(bitmap: Bitmap?): Uri {
        val path = Environment.getExternalStorageDirectory().toString()
        val file = File(path, "${UUID.randomUUID()}.jpeg")

        try {
            val stream: OutputStream = FileOutputStream(file)
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e : Exception){
            println(e.printStackTrace())
        }
//        Toast.makeText(requireActivity(), file.absolutePath, Toast.LENGTH_SHORT).show()
        return Uri.parse(file.absolutePath)
    }





//    fun buyToWhatsApp(){
//        val imageUri = "android.resource://${activity?.packageName}/drawable/danilla"
//        val message = """
//                halo, saya tertarik dengan produk
//                ${args.dataProduct.name} dengan harga Rp. ${args.dataProduct.price},
//                apakah masih available
//            """.trimIndent()
//        val a = registerForActivityResult(ActivityResultContracts.GetContent()
//        ) {
//            val whatsApp = Intent(Intent.ACTION_SEND).apply {
//                putExtra(Intent.EXTRA_TEXT,message)
//                putExtra(Intent.EXTRA_STREAM,it)
//                type = "text/plain"
//                type = "image/jpeg"
//                `package` = "com.whatsapp"
//                Log.d("PATH_URI",
//                    Uri.parse("content://com.android.providers.media.documents/document/image%3A157872")
//                        .toString()
//                )
//            }
//            startActivity(whatsApp)
//        }
//        binding.btnBuy.setOnClickListener {
//            a.launch("image/*")
//        }
//    }




}