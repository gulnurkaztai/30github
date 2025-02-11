package algonquin.cst8319.enigmatic

import algonquin.cst8319.enigmatic.databinding.ActivityMainBinding
import android.util.Log
import android.view.ViewGroup
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.util.concurrent.ExecutorService
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.common.Barcode
import java.util.concurrent.atomic.AtomicBoolean
import com.google.android.gms.tasks.Tasks


@ExperimentalGetImage
class ImageAnalyzer(private var bindingMain: ActivityMainBinding) : ImageAnalysis.Analyzer {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    private val barcodeScanner = BarcodeScanning.getClient(
        BarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
            .build()
    )

    private var isProcessing = AtomicBoolean(false)
    private var isSnackbarVisible = AtomicBoolean(false)
    private val recognizedTextBlocks = mutableListOf<String>()
    private var barcodeValue = ""

    fun createImageAnalysis(cameraExecutor: ExecutorService): ImageAnalysis {
        return ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
            .apply {
                setAnalyzer(cameraExecutor, this@ImageAnalyzer)
            }
    }
    override fun analyze(imageProxy: ImageProxy) {
        try {
            if (isSnackbarVisible.get() || !isProcessing.compareAndSet(false, true)) {
                return
            }

            val mediaImage = imageProxy.image ?: return
            val image = InputImage.fromMediaImage(
                mediaImage,
                imageProxy.imageInfo.rotationDegrees
            )

            processImageConcurrently(image)
        } finally {
            imageProxy.close()
        }
    }

    private fun processImageConcurrently(image: InputImage) {
        Tasks.whenAllComplete(
            recognizer.process(image),
            barcodeScanner.process(image)
        ).addOnSuccessListener { tasks ->
            val results = processResults(tasks)
            if (results.isNotEmpty() && !isSnackbarVisible.get()) {
                showResults(results)
            }
        }.addOnCompleteListener {
            isProcessing.set(false)
        }
    }

    private fun processResults(tasks: List<com.google.android.gms.tasks.Task<*>>): String {
        var output = ""

        tasks.forEach { task ->
            if (task.isSuccessful) {
                when (val result = task.result) {
                    is com.google.mlkit.vision.text.Text -> {
                        recognizedTextBlocks.clear()
                        for (block in result.textBlocks) {
                            if (block.text !in recognizedTextBlocks) {
                                recognizedTextBlocks.add(block.text)
                            }
                        }
                    }
                    is List<*> -> {
                        val barcodes = result as? List<Barcode>
                        barcodes?.firstOrNull()?.let {
                            barcodeValue = it.displayValue ?: ""
                        }
                    }
                }
            }
        }

        recognizedTextBlocks.forEach { block ->
            output += "$block\n"
        }
        if (barcodeValue.isNotEmpty()) {
            output += "Barcode: $barcodeValue"
        }

        return output
    }

    private fun showResults(results: String) {
        isSnackbarVisible.set(true)
        Snackbar.make(bindingMain.root, results, Snackbar.LENGTH_SHORT)
            .apply {
                addCallback(object : Snackbar.Callback() {
                    override fun onDismissed(snackbar: Snackbar, event: Int) {
                        isSnackbarVisible.set(false)
                        recognizedTextBlocks.clear()
                        barcodeValue = ""
                    }
                })
                setTextMaxLines(30)
                show()
            }
    }
}
