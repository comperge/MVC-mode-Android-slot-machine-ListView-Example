package org.ratpoisonfactory.slotListviewmvc.view.center;

import org.ratpoisonfactory.common.PFragControl;
import org.ratpoisonfactory.common.PFragment;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;

import android.content.Context;

public class CenterControl extends PFragControl {
	private CenterView frag;

	public CenterControl(Context context) {
		super(context);
	}

	public PFragment asFragCreate() {
		reData();
		frag = CenterView.with();
		return pCreate(frag);
	}

	public PFragment asFragResume() {
		reData();
		if (frag == null) {
			frag = CenterView.with();
			return pCreate(frag);
		} else {
			return pResume(frag.withView());
		}
	}

	private void reData() {
	}

	@Override
	public void abView() {
	}
	
	public void scrolling(BcInfoBean bean){
		frag.scrolling(bean);
	}
	
	public void scrollSelected(BcInfoBean bean){
		frag.scrollSelected(bean);
	}

}