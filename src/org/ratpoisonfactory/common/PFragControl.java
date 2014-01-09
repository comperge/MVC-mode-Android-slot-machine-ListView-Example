package org.ratpoisonfactory.common;

import android.content.Context;

public abstract class PFragControl {
	public Context pContext;

	public PFragControl(Context context) {
		pContext = context;
	}

	public abstract void abView();

	public PFragment pCreate(PFragment pFragment) {
		abView();
		return pFragment;
	}

	public PFragment pResume(PFragment pFragment) {
		pFragment.pResume();
		abView();
		return pFragment;
	}
	
	public String res(int resId){
		return pContext.getResources().getString(resId);
	}
}