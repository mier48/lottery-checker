package com.albertomier.lotterychecker.core.utils

import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.albertomier.lotterychecker.core.extensions.isNumeric
import com.albertomier.lotterychecker.core.interfaces.AnalyzerCallback
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata
import com.google.mlkit.vision.common.InputImage


@ExperimentalGetImage
class ImageAnalyzer : ImageAnalysis.Analyzer {

    private lateinit var analyzerCallback: AnalyzerCallback

    fun setCallback(analyzerCallback: AnalyzerCallback) {
        this.analyzerCallback = analyzerCallback
    }

    private fun degreesToFirebaseRotation(degrees: Int): Int = when (degrees) {
        0 -> FirebaseVisionImageMetadata.ROTATION_0
        90 -> FirebaseVisionImageMetadata.ROTATION_90
        180 -> FirebaseVisionImageMetadata.ROTATION_180
        270 -> FirebaseVisionImageMetadata.ROTATION_270
        else -> throw Exception("Rotation must be 0, 90, 180, or 270.")
    }

    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            //var image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val image = FirebaseVisionImage.fromMediaImage(mediaImage, 0)

            val detector = FirebaseVision.getInstance().onDeviceTextRecognizer

            val result = detector.processImage(image)
                .addOnSuccessListener { firebaseVisionText ->
                    //Log.e("TAG", firebaseVisionText.text)

                    val resultText = firebaseVisionText.text
                    for (block in firebaseVisionText.textBlocks) {

                        if (block.text.isNumeric()) {
                            if (block.text.length == 5) {
                                //result = block.text
                                Log.e("TAG", block.text)
                            }
                        }

                        val blockText = block.text
                        val blockConfidence = block.confidence
                        val blockLanguages = block.recognizedLanguages
                        val blockCornerPoints = block.cornerPoints
                        val blockFrame = block.boundingBox
                        for (line in block.lines) {
                            val lineText = line.text
                            val lineConfidence = line.confidence
                            val lineLanguages = line.recognizedLanguages
                            val lineCornerPoints = line.cornerPoints
                            val lineFrame = line.boundingBox
                            for (element in line.elements) {
                                val elementText = element.text
                                val elementConfidence = element.confidence
                                val elementLanguages = element.recognizedLanguages
                                val elementCornerPoints = element.cornerPoints
                                val elementFrame = element.boundingBox
                            }
                        }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("TAG", e.message!!)
                }


        }
    }

//    fun getText(): String {
//        return result
//    }


}
