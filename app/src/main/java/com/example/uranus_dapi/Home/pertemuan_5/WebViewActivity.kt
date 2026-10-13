package com.example.uranus_dapi.Home.pertemuan_5

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.databinding.ActivityWebViewBinding

// 1. Ubah warisan dari AppCompatActivity menjadi BaseActivity
class WebViewActivity : BaseActivity() {

    private lateinit var webBinding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inflate layout activity_web_view ke dalam fragment_container milik BaseActivity
        webBinding = ActivityWebViewBinding.inflate(layoutInflater)
        binding.fragmentContainer.addView(webBinding.root)

        // 3. Setup Toolbar
        setSupportActionBar(webBinding.toolbar)

        supportActionBar?.apply {
            title = "WebView"
            setDisplayHomeAsUpEnabled(true)
        }

        // 4. Setup WebView
        webBinding.webView.webViewClient = WebViewClient()
        webBinding.webView.settings.javaScriptEnabled = true
        webBinding.webView.settings.domStorageEnabled = true
        webBinding.webView.loadUrl("https://www.google.com")

        // 5. Tombol back pada Toolbar
        webBinding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 6. Handling tombol back Android (kembali di histori webView jika ada)
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (webBinding.webView.canGoBack()) {
                        webBinding.webView.goBack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }
}