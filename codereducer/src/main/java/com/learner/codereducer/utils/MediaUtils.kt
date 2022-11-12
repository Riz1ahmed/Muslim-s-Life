package com.learner.codereducer.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import java.io.File

object MediaUtils {
    fun playVideo(context: Context, videoPath: String) {
        val outFile = File(videoPath)
        if (outFile.exists()) {
            val uri =
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) Uri.parse(outFile.absolutePath)
                else FileProvider.getUriForFile(context, "${context.packageName}.riz1", outFile)
            playVideo(context, uri)
        }
    }

    fun playVideo(context: Context, videoUri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, videoUri)
            .setDataAndType(videoUri, "video/*") //or specify with "video/mp4"
            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(intent)

    }


    fun getVideoPickerIntent() = IntentUtils.getVideoPickerIntent()

    fun getThumbnailAt(context: Context, videoUri: Uri, secInMicro: Long?): Bitmap? {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(context, videoUri)
        val thumb = if (secInMicro != null) mmr.getFrameAtTime(secInMicro) else mmr.frameAtTime
        mmr.release()
        return thumb
    }

    /**@param videoPath the must be permitted
     * for example: from your pkg dir or Provided uri*/
    fun getThumbnailAt(videoPath: String, secInMicro: Long?): Bitmap? {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(videoPath)
        val thumb = if (secInMicro != null) mmr.getFrameAtTime(secInMicro) else mmr.frameAtTime
        mmr.release()
        return thumb
    }


    /**@param videoPath the must be permitted.
     * for example: from your pkg dir or Provided uri*/
    fun getDuration(videoPath: String): String? {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(videoPath)
        val duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        mmr.release()
        return duration
    }

    /**return track duration in millisecond*/
    fun getDuration(context: Context, videoUri: Uri): String? {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(context, videoUri)
        val durationInMillis = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        mmr.release()
        return durationInMillis
    }


    /**The result will find on [onActivityResult] with [requestCode] request code*/
    fun openAudioPicker(fragment: Fragment, requestCode: Int) {
        val gallery = Intent()
        gallery.type = "audio/*"
        gallery.action = Intent.ACTION_GET_CONTENT
        fragment.startActivityForResult(gallery, requestCode)
    }

    /**Not implemented*/
    fun notifyGallery() {

    }

    private fun runCloseableMMR(block: (MediaMetadataRetriever) -> Unit) {
        val mmr = MediaMetadataRetriever()
        block(mmr)
        mmr.release()
    }

    /*private fun MediaMetadataRetriever.use(block: (MediaMetadataRetriever) -> Unit) {
        block(this)
        this.release()
    }*/
}