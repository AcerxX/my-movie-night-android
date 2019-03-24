package roprojects.mymovienight;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    private Context mContext;

    WebAppInterface(Context ctx) {
        this.mContext = ctx;
    }

    @JavascriptInterface
    public void callNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        mContext.getApplicationContext().startActivity(intent);
    }

    @JavascriptInterface
    public void openWaze(String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("waze://?q=" + address));
        mContext.getApplicationContext().startActivity(intent);
    }

    @JavascriptInterface
    public void openGoogleMaps(String address) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        mContext.getApplicationContext().startActivity(mapIntent);
    }
}
