package org.ratpoisonfactory.slotListviewmvc.view.bottom;

import java.util.ArrayList;

import org.ratpoisonfactory.slotListviewmvc.R;
import org.ratpoisonfactory.slotListviewmvc.model.BcInfoBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomAdapter extends BaseAdapter {

	private ViewHolder mViewHolder = null;
	private ArrayList<BcInfoBean> beans;
	private Context pContext;
	public BottomAdapter(Context pContext, ArrayList<BcInfoBean> beans) {
		this.pContext = pContext;
		this.beans = beans;
	}
	public int getCount() {
		return beans.size();
	}
	public Object getItem(int position) {
		return beans.get(position);
	}
	public long getItemId(int position) {
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup container) {
		final int index = position;
		if (beans == null || beans.get(position) == null) {
			return null;
		}

		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView = View.inflate(pContext, R.layout.main_bottom_item, null);
			mViewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			mViewHolder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
			mViewHolder.ll_full_layout = (LinearLayout) convertView.findViewById(R.id.ll_full_layout);
			
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		
		if(beans.get(index).getType() == 999){
			mViewHolder.ll_full_layout.setVisibility(View.INVISIBLE);
		}else{
			mViewHolder.ll_full_layout.setVisibility(View.VISIBLE);
		}
		
		mViewHolder.tv_title.setText(beans.get(index).getTitle());
		mViewHolder.tv_desc.setText(beans.get(index).getDesc());
		
		return convertView;
	}

	private class ViewHolder {
		private TextView tv_title;
		private TextView tv_desc;
		private LinearLayout ll_full_layout;
	}
}
