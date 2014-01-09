package org.ratpoisonfactory.slotListviewmvc.view.bottom;

import java.util.ArrayList;

import org.ratpoisonfactory.common.PFragControl;
import org.ratpoisonfactory.common.PFragment;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;
import org.ratpoisonfactory.slotListviewmvc.model.ModelCreator;
import org.ratpoisonfactory.slotListviewmvc.view.bottom.BottomView.IFragtoControlEvent;

import android.content.Context;

public class BottomControl extends PFragControl {
	private BottomView frag;
	private ArrayList<BcInfoBean> beans;
	private MainActToBottomConEvent mMainActToBottomConEvent;

	public BottomControl(Context context) {
		super(context);
	}

	public PFragment asFragCreate() {
		reData();
		frag = BottomView.with(beans);
		frag.setEvent(mIFragtoControlEvent);
		return pCreate(frag);
	}

	public PFragment asFragResume() {
		reData();
		if (frag == null) {
			frag = BottomView.with(beans);
			frag.setEvent(mIFragtoControlEvent);
			return pCreate(frag);
		}else{
			return pResume(frag.withView(beans));
		}
	}

	private void reData() {
	    beans = new ModelCreator().dummyResult();
	}

	@Override
	public void abView() {}
	
	public void setEvent(MainActToBottomConEvent mMainActToBottomConEvent){
		this.mMainActToBottomConEvent = mMainActToBottomConEvent;
	}
	

	private IFragtoControlEvent mIFragtoControlEvent = new IFragtoControlEvent() {
		@Override
		public void scrolling(BcInfoBean bean) {
			if(bean.getType() != 999)
				mMainActToBottomConEvent.scrolling(bean);
		}		
		@Override
		public void scrollSelected(BcInfoBean bean) {
			if(bean.getType() != 999)
				mMainActToBottomConEvent.scrollSelected(bean);
		}
	};
	
	public interface MainActToBottomConEvent{
		void scrolling(BcInfoBean bean);
		void scrollSelected(BcInfoBean bean);
	}
}