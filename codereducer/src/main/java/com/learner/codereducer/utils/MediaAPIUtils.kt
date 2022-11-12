package com.learner.codereducer.utils

import android.content.Context
import android.media.MediaExtractor
import android.media.MediaFormat
import android.net.Uri
import android.util.Size
import java.io.FileDescriptor

object MediaAPIUtils {
    private const val videoMime = "video/"
    private const val audioMime = "audio/"

    fun getVideoSize(context: Context, uri: Uri, callBack: (Size?) -> Unit) {
        var size: Size? = null
        getVideoFile(context, uri) {
            size = Size(it.getInteger(MediaFormat.KEY_WIDTH), it.getInteger(MediaFormat.KEY_HEIGHT))
        }
        callBack(size)
    }

    fun getVideoDuration(context: Context, uri: Uri, callBack: (Long?) -> Unit) {
        var vDuration: Long? = null
        getVideoFile(context, uri) { vDuration = it.getLong(MediaFormat.KEY_DURATION) }
        callBack(vDuration)
    }

    private fun getVideoFile(context: Context, videoUri: Uri, callBack: (MediaFormat) -> Unit) {
        getSpecificFile(context, videoUri, videoMime) { callBack(it) }
    }

    private fun getAudioFile(context: Context, videoUri: Uri, callBack: (MediaFormat) -> Unit) {
        getSpecificFile(context, videoUri, audioMime) { callBack(it) }
    }

    fun getSpecificFile(
        context: Context, mediaUri: Uri, mimeType: String, callBack: (MediaFormat) -> Unit
    ) {
        MediaExtractor().use { extractor ->
            extractor.setDataSource(context, mediaUri, null)
            getSpecificFile(extractor, mimeType, callBack)
        }
    }

    fun getSpecificFile(
        mediaAbsPath: String, mimeType: String, callBack: (MediaFormat) -> Unit
    ) {
        MediaExtractor().use { extractor ->
            extractor.setDataSource(mediaAbsPath)
            getSpecificFile(extractor, mimeType, callBack)
        }
    }

    fun getSpecificFile(
        fileDescriptor: FileDescriptor, mimeType: String, callBack: (MediaExtractor,Int) -> Unit
    ) {
        MediaExtractor().use { extractor ->
            extractor.setDataSource(fileDescriptor)
            getSpecificFile(extractor, mimeType, callBack)
        }
    }

    private fun getSpecificFile(
        extractor: MediaExtractor, mimeType: String, callBack: (MediaFormat) -> Unit
    ) = getSpecificFile(extractor, mimeType) { xtr, idx -> callBack(xtr.getTrackFormat(idx)) }

    /**@return the 1st file which [MediaFormat.KEY_MIME] matched with [fileMimeType]*/
    fun getSpecificFile(
        extractor: MediaExtractor, fileMimeType: String, callBack: (MediaExtractor, Int) -> Unit
    ) {
        for (i in 0 until extractor.trackCount) {
            val mediaFormat = extractor.getTrackFormat(i)
            val mime = mediaFormat.getString(MediaFormat.KEY_MIME)
            if (mime?.startsWith(fileMimeType) == true) {
                callBack(extractor, i)
                break
            }
        }
    }


    fun getVideoThumbnail(context: Context, uri: Uri, callback: () -> Unit) {
        getSpecificFile(context, uri, videoMime) {
        }
    }
}

private fun MediaExtractor.use(block: (MediaExtractor) -> Unit) {
    block(this)
    this.release()
}
