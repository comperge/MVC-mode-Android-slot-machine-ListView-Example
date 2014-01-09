package org.ratpoisonfactory.common;
public class Log {
	private static final boolean APP_TRACE_LOG_ON = true;

	public static void i(String TAG, String msg) {
		if (APP_TRACE_LOG_ON) {
			android.util.Log.i(TAG, msg);
		}
	}

	public static void e(String TAG, String msg) {
		if (APP_TRACE_LOG_ON) {
			android.util.Log.e(TAG, msg);
		}
	}

	public static void d(String TAG, String msg) {
		if (APP_TRACE_LOG_ON) {
			android.util.Log.d(TAG, msg);
		}
	}
}
