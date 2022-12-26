package com.albertomier.lotterychecker.core.extensions

import android.graphics.Bitmap
import java.io.File

fun File.writeBitmap(
    bitmap: Bitmap,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
    quality: Int = 100
) {
    outputStream().use { out ->
        bitmap.compress(format, quality, out)
        out.flush()
    }
}