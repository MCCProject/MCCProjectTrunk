package com.mcc.lookaround;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Main activity that hosts and manages the WebView.
 */
public class MainActivity extends Activity {

    private static WebView mWebView;
    private static Handler mHandler;
    
    // Suppress XSS warning
    /**
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mWebView = (WebView)findViewById(R.id.webview);
        
        // Enable JavaScript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mHandler = new Handler();
        
        // Instantiate web interface and load web page
        mWebView.addJavascriptInterface(new WebInterface(this), "Android");
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(getString(R.string.html_root));
    }

    /**
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Check if the key event was the Back button and if there is a history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack())
        {
            mWebView.goBack();
            return true;
        }
        
        return super.onKeyDown(keyCode, event);
    }
    
    /**
     * Loads the given URL in the WebView.
     * @param in The URL to load.
     */
    public static void loadUrl(final String in)
    {
        // Execute in a separate thread from the UI thread.
        mHandler.post(new Runnable() {
            public void run() {
                mWebView.loadUrl(in);
            }
        });
    }
    
    /**
     * Displays a toast.
     * @param context The context to show the toast.
     * @param msg The message to display.
     */
    public static void showToast(final Context context, final String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
