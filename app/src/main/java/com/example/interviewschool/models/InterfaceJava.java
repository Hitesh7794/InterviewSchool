package com.example.interviewschool.models;
import android.webkit.JavascriptInterface;

import com.example.interviewschool.activities.callAc;

public class InterfaceJava {

    callAc callActivity;

    public InterfaceJava(callAc callActivity) {
        this.callActivity = callActivity;
    }

    @JavascriptInterface
    public void onPeerConnected(){
        callActivity.onPeerConnected();
    }

}
