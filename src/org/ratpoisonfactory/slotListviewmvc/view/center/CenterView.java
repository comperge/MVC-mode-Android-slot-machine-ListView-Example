package org.ratpoisonfactory.slotListviewmvc.view.center;

import org.ratpoisonfactory.slotListviewmvc.R;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;
import org.ratpoisonfactory.common.Log;
import org.ratpoisonfactory.common.PFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CenterView extends PFragment {
	private final String TAG = "CenterView" + ":" + "K.J";
	private TextView tv_screen,tv_screen2;
	protected static CenterView with() {
		CenterView frag = new CenterView();
		return frag;
	}

	protected CenterView withView() {
		return this;
	}

	@Override
	public View abCreateView(LayoutInflater inflater, ViewGroup container) {
		View root = inflater.inflate(R.layout.main_screen_frag, container, false);
		tv_screen = (TextView) root.findViewById(R.id.tv_screen);
		tv_screen2 = (TextView) root.findViewById(R.id.tv_screen2);
		return root;
	}

	@Override
	public void abResume() {
		Log.i(TAG, "abResume CenterView");
	}
	
	public void scrolling(BcInfoBean bean){
		tv_screen.setText(bean.getNumber());
	}
	
	public void scrollSelected(BcInfoBean bean){
		tv_screen2.setText( bean.getTitle());
	}
}