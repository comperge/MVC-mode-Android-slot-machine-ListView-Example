package org.ratpoisonfactory.slotListviewmvc.view.top;

import org.ratpoisonfactory.common.PFragControl;
import org.ratpoisonfactory.common.PFragment;

import android.content.Context;


public class TopControl extends PFragControl {
	private TopView frag;
	
	public TopControl(Context context) {
		super(context);
	}
	
	public PFragment asFragCreate() {
		reData();
		frag = TopView.with();
		return pCreate(frag);
	}

	public PFragment asFragResume() {
		reData();
		if (frag == null) {
			this.asFragCreate();
		}
		return pResume(frag.withView());
	}

	private void reData() {
	}

	@Override
	public void abView() {
	}
	
}