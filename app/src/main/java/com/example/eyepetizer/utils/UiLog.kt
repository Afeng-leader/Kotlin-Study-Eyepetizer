package com.example.eyepetizer.utils

import android.util.Log

object UiLog {
    var TAG = "UiLog"
    var DEBUG = isLoggable(3)
    var INFO = isLoggable(4)
    var VERBOSE = isLoggable(2)
    var WARN = isLoggable(5)
    var ERROR = isLoggable(6)
    private const val FORCE_LOGGING = true
    fun d(prefix: String, msg: String) {
        if (DEBUG) {
            Log.d(TAG, "$prefix: $msg")
        }
    }

    fun d(objectPrefix: Any?, msg: String) {
        if (DEBUG) {
            Log.d(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
        }
    }

    fun i(prefix: String, msg: String) {
        if (INFO) {
            Log.i(TAG, "$prefix: $msg")
        }
    }

    fun i(objectPrefix: Any?, msg: String) {
        if (INFO) {
            Log.i(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
        }
    }

    fun v(prefix: String, msg: String) {
        if (VERBOSE) {
            Log.v(TAG, "$prefix: $msg")
        }
    }

    fun v(objectPrefix: Any?, msg: String) {
        if (VERBOSE) {
            Log.v(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
        }
    }

    fun w(prefix: String, msg: String) {
        if (WARN) {
            Log.w(TAG, "$prefix: $msg")
        }
    }

    fun w(objectPrefix: Any?, msg: String) {
        if (WARN) {
            Log.w(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
        }
    }

    fun e(prefix: String, msg: String) {
        if (ERROR) {
            Log.e(TAG, "$prefix: $msg")
        }
    }

    fun e(objectPrefix: Any?, msg: String) {
        if (ERROR) {
            Log.e(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
        }
    }

    fun wtf(prefix: String, msg: String) {
        Log.wtf(TAG, "$prefix: $msg")
    }

    fun wtf(objectPrefix: Any?, msg: String) {
        Log.wtf(TAG, getPrefixFromObject(objectPrefix) + ": " + msg)
    }

    fun isLoggable(level: Int): Boolean {
        return true
    }

    private fun getPrefixFromObject(obj: Any?): String {
        return if (obj == null) "<null>" else obj.javaClass.simpleName
    }
}
