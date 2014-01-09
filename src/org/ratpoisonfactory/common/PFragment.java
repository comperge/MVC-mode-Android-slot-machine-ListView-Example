package org.ratpoisonfactory.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PFragment extends Fragment {
	public LayoutInflater pInflater;
	public Activity pActivity;
	public Context pContext;

	@Override
	public void onAttach(Activity activity) {
		pActivity = activity;
		pContext = activity;
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return abCreateView(inflater, container);
	}

	public View pInflateView(int resId, LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(resId, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		pActivityCreated(savedInstanceState);
		super.onActivityCreated(savedInstanceState);
		pResume();
	}

	public void pActivityCreated(Bundle savedInstanceState) {}

	public abstract View abCreateView(LayoutInflater inflater, ViewGroup container);
	public abstract void abResume();

	public void pPausing() {}

	@Override
	public void onPause() {
		super.onPause();
		if (pActivity.isFinishing()) {
			pPausing();
		}
	}

	@SuppressLint("HandlerLeak")
	protected Handler fHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			abResume();
			super.handleMessage(msg);
		}
	};

	public void pResume() {
		Message msg = Message.obtain();
		fHandler.sendMessageDelayed(msg, 50);
	}

	
	public String res(int resId){
		return pContext.getResources().getString(resId);
	}
}