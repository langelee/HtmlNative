package com.mozz.remoteview.parser.code;

import android.os.SystemClock;
import android.util.Log;

import com.mozz.remoteview.parser.ViewContext;


public class Code {
    private static final String TAG = Code.class.getSimpleName();
    static final boolean DEBUG = false;
    private String mCode;
    private String mFunctionName;

    private Code(String code, String functionName) {
        mCode = code;
        mFunctionName = functionName;
    }

    public static Code toCode(String function, String code) {
        return new Code(code, function);
    }

    @Override
    public String toString() {
        return mCode;
    }

    public void execute(ViewContext context) {
        long timeStart = SystemClock.currentThreadTimeMillis();

        context.execute(mCode);

        long spend = SystemClock.currentThreadTimeMillis() - timeStart;

        if (DEBUG) {
            Log.d(TAG, "=====" + mFunctionName + "=====");
            Log.d(TAG, mCode);
            Log.i(TAG, "executed " + mFunctionName + " spend " + spend + "ms.");
            Log.d(TAG, "=====");

        }
    }
}
