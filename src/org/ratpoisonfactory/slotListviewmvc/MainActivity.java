package org.ratpoisonfactory.slotListviewmvc;

import org.ratpoisonfactory.slotListviewmvc.R;
import org.ratpoisonfactory.common.Log;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;
import org.ratpoisonfactory.slotListviewmvc.view.bottom.BottomControl;
import org.ratpoisonfactory.slotListviewmvc.view.bottom.BottomControl.MainActToBottomConEvent;
import org.ratpoisonfactory.slotListviewmvc.view.center.CenterControl;
import org.ratpoisonfactory.slotListviewmvc.view.top.TopControl;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends FragmentActivity {
	public Context mContext;
	public FragmentManager mFragMan;
	private final String TAG = "MainActivity" + ":" + "K.J";
	private BottomControl mBottomControl = null;
	private TopControl mTopControl = null;
	private CenterControl mCenterControl = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "AppStart");
		mContext = this;
		setContentView(R.layout.mainlayout);
		mFragMan = getSupportFragmentManager();

		mBottomControl = new BottomControl(MainActivity.this);
		mTopControl = new TopControl(MainActivity.this);
		mCenterControl = new CenterControl(MainActivity.this);
		mBottomControl.setEvent(new MainActToBottomConEvent() {
			@Override
			public void scrolling(BcInfoBean bean) {
				mCenterControl.scrolling(bean);
			}

			@Override
			public void scrollSelected(BcInfoBean bean) {
				Log.i(TAG, bean.getTitle());
				mCenterControl.scrollSelected(bean);
				mCenterControl.scrolling(bean);
			}
		});

		pFragAdd(R.id.frameTop, mTopControl.asFragCreate());
		pFragAdd(R.id.frameScreen, mCenterControl.asFragCreate());
		pFragAdd(R.id.frameBottom, mBottomControl.asFragCreate());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainlayout, menu);
		return true;
	}

	public void pFragAdd(int resId, Fragment frag) {
		if (frag != null) {
			final FragmentTransaction fragTrans = mFragMan.beginTransaction();
			fragTrans.add(resId, frag, "");
			fragTrans.commit();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i(TAG, "onConfigurationChaged");
	}
}
