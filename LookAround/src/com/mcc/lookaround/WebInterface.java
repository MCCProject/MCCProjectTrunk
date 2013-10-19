package com.mcc.lookaround;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Description: Android interface for the Web page bi-directional communication.
 */
public class WebInterface
{
    Context mContext;
    
    /** Instantiate the interface and set the context 
     * @param c */
    WebInterface(Context c)
    {
        mContext = c;
    }
    
    /**
     * @param in The URL of the page to load.
     */
    @JavascriptInterface
    public void loadPage(final String in)
    {
        Log.d(WebInterface.class.getName(), "Loading page: " + in);
        final String url = mContext.getString(R.string.html_root) + "/" + in;
        MainActivity.loadUrl(url);
    }
    
    /**
     * @param msg
     */
    @JavascriptInterface
    public void showToast(final String msg)
    {
        Log.d(WebInterface.class.getName(), "Toast message: " + msg);
        MainActivity.showToast(mContext, msg);
    }
}
