package org.ratpoisonfactory.slotListviewmvc.view.top;

import org.ratpoisonfactory.slotListviewmvc.R;
import org.ratpoisonfactory.common.Log;
import org.ratpoisonfactory.common.PFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopView extends PFragment {
	private final String TAG = "TopFrag" + ":" + "K.J";
	protected static TopView with() {
		TopView frag = new TopView();
		return frag;
	}

	protected TopView withView() {
		return this;
	}

	@Override
	public View abCreateView(LayoutInflater inflater, ViewGroup container) {
		View root = inflater.inflate(R.layout.main_top_frag, container, false);
		return root;
	}

	@Override
	public void abResume() {
		Log.i(TAG, "abResume top");
	}
}