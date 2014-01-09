package org.ratpoisonfactory.slotListviewmvc.view.bottom;

import java.util.ArrayList;

import org.ratpoisonfactory.slotListviewmvc.R;
import org.ratpoisonfactory.common.Log;
import org.ratpoisonfactory.common.PFragment;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

@SuppressLint("NewApi")
public class BottomView extends PFragment implements OnScrollListener {
	private final String TAG = "BottomFrag" + ":" + "K.J";
	private ArrayList<BcInfoBean> beans = null;
	private ListView lv;
	private BaseAdapter mAdapter;
	private IFragtoControlEvent mIFragtoControlEvent;
	private Button btn_up, btn_down;
	private Animation fadeOutAnimation;
	private int selectpostion= 0;
	boolean positionset = false;
	private int lastItemPosition = 10000;

	protected void setBeans(ArrayList<BcInfoBean> beans) {
		this.beans = beans;
	}
	protected void setEvent(IFragtoControlEvent mIFragtoControlEvent){
		this.mIFragtoControlEvent = mIFragtoControlEvent;
	}

	protected static BottomView with(ArrayList<BcInfoBean> beans) {
		BottomView frag = new BottomView();
		frag.setBeans(beans);
		return frag;
	}

	protected BottomView withView(ArrayList<BcInfoBean> beans) {
		this.beans = beans;
		return this;
	}

	@Override
	public View abCreateView(LayoutInflater inflater, ViewGroup container) {
		View root = inflater.inflate(R.layout.main_bottom_frag, container, false);
		lv = (ListView) root.findViewById(R.id.lv);
		lv.setSmoothScrollbarEnabled(true);
		
		btn_up = (Button) root.findViewById(R.id.btn_up);
		btn_down = (Button) root.findViewById(R.id.btn_down);
		btn_up.setBackgroundResource(R.drawable.thumb_transparent);
		btn_down.setBackgroundResource(R.drawable.thumb_transparent);
		
		fadeOutAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);	    
		fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {			
			@Override
			public void onAnimationStart(Animation animation) {
				btn_up.setBackgroundResource(R.drawable.btn_up);
				btn_down.setBackgroundResource(R.drawable.btn_down);
			}			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				btn_up.setBackgroundResource(R.drawable.thumb_transparent);
				btn_down.setBackgroundResource(R.drawable.thumb_transparent);
			}
		});
		findListItem();
		
		btn_up.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(selectpostion > 0){
					selectpostion = selectpostion-1;
					lv.setSelectionFromTop(selectpostion,0);
					if(mIFragtoControlEvent != null)  mIFragtoControlEvent.scrollSelected(beans.get(selectpostion));					
				}
				btn_up.startAnimation(fadeOutAnimation);
				btn_down.startAnimation(fadeOutAnimation);
			}
		});
		btn_down.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(selectpostion+1 < lastItemPosition){
					selectpostion = selectpostion+1;
					lv.setSelectionFromTop(selectpostion,0);
					if(mIFragtoControlEvent != null)  mIFragtoControlEvent.scrollSelected(beans.get(selectpostion));
				}
				btn_up.startAnimation(fadeOutAnimation);
				btn_down.startAnimation(fadeOutAnimation);
			}		
		});
		lv.setOnScrollListener(this);

		return root;
	}

	@Override
	public void abResume() {
		Log.i(TAG, "abResume bottom");
		mAdapter = new BottomAdapter(pContext, beans);
		lv.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if(mIFragtoControlEvent != null) mIFragtoControlEvent.scrolling(beans.get(lv.getFirstVisiblePosition()));
		if(firstVisibleItem > lastItemPosition){
			lv.smoothScrollToPosition(lastItemPosition);
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {		
		if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
//			Log.i(TAG,"SCROLL_STATE_IDLE" +SCROLL_STATE_IDLE);
			if(positionset){
				positionset = false;
				lv.smoothScrollToPosition(lv.getFirstVisiblePosition());
				if(mIFragtoControlEvent != null)  mIFragtoControlEvent.scrollSelected(beans.get(lv.getFirstVisiblePosition()));
				selectpostion = lv.getFirstVisiblePosition();
			}
			positionset = false;			
		}else if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
			positionset = true;
			
		}else if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING){
			if(positionset){
				btn_down.startAnimation(fadeOutAnimation);
				btn_up.startAnimation(fadeOutAnimation);
			}
		}
	}
	
	protected interface IFragtoControlEvent{
		void scrolling(BcInfoBean bean);
		void scrollSelected(BcInfoBean bean);
	}
	
	private void findListItem(){
		if(beans == null) return;
		lastItemPosition = 0;
		for(BcInfoBean bean : beans){
			if(bean.getType() == 999) break;
			++lastItemPosition;
		}
	}
}