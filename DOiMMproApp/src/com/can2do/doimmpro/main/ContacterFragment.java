package com.can2do.doimmpro.main;

import java.util.ArrayList;
import java.util.List;

import org.jivesoftware.smack.Roster;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.can2do.doimmpro.R;
import com.can2do.doimmpro.global.MyApplication;
import com.can2do.doimmpro.model.User;

/**
 * 联系人列表界面
 * 
 */
public class ContacterFragment extends Fragment {

	private MyApplication application;
	private ContacterActivity mActivity = null;
	private ExpandableListView mListView;
	private List<String> mGroupNames;
	private User mUser = null;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mActivity = (ContacterActivity) this.getActivity();
		application = (MyApplication) mActivity.getApplication();

		View view = inflater.inflate(R.layout.im_contact_list, null);
		mListView = (ExpandableListView) view.findViewById(R.id.contact_list);
		mListView.setOnChildClickListener(new OnChildClickListener() {

			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
				return true;
			}
		});

		initContacter();

		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public void initContacter() {

	}

	public void toChat(String userName) {
		
	}

}
