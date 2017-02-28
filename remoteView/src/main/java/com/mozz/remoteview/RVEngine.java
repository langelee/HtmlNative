package com.mozz.remoteview;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.ViewGroup;

import com.mozz.remoteview.parser.OnRViewLoaded;
import com.mozz.remoteview.parser.RVModule;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.InputStream;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Yang Tao, 17/2/21.
 */

public class RVEngine {

    public static final String LUA_TAG = "RVScript";

    private HandlerThread mProcessThread = new HandlerThread("RVProcessThread");

    private Handler mProcessHandler = new Handler(mProcessThread.getLooper());


    private RVEngine() {
    }

    private static RVEngine sInstance = null;

    public static RVEngine getInstance() {
        if (sInstance == null) {
            synchronized (RVEngine.class) {
                if (sInstance == null) {
                    sInstance = new RVEngine();
                }
            }
        }

        return sInstance;
    }

    public static void loadView(InputStream inputStream, OnRViewLoaded onRViewLoaded) {

    }

    public static void loadView(InputStream inputStream, Activity activity) {

    }

    public static void loadView(InputStream inputStream, Fragment view) {

    }

    public static void loadView(InputStream inputStream, ViewGroup viewGroup) {

    }

    public void onDestory() {
        RVModule.clearCache();
    }
}