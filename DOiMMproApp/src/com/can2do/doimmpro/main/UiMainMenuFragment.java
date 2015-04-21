package com.can2do.doimmpro.main;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ab.fragment.AbAlertDialogFragment.AbDialogOnClickListener;
import com.ab.image.AbImageCache;
import com.ab.image.AbImageLoader;
import com.ab.model.AbMenuItem;
import com.ab.task.AbTask;
import com.ab.task.AbTaskItem;
import com.ab.task.AbTaskListener;
import com.ab.util.AbAnimationUtil;
import com.ab.util.AbDialogUtil;
import com.ab.util.AbFileUtil;
import com.ab.util.AbImageUtil;
import com.ab.util.AbToastUtil;
import com.can2do.doimmpro.R;
import com.can2do.doimmpro.demo.activity.DemoMainActivity;
import com.can2do.doimmpro.global.MyApplication;
import com.can2do.doimmpro.im.activity.ContacterActivity;
import com.can2do.doimmpro.im.activity.MessageActivity;
import com.can2do.doimmpro.login.AboutActivity;
import com.can2do.doimmpro.model.User;

public class UiMainMenuFragment extends Fragment {

	private MyApplication application;
	private UiMain mActivity = null;
	private ExpandableListView mMenuListView;
	private ArrayList<String> mGroupName = null;
	private ArrayList<ArrayList<AbMenuItem>> mChilds = null;
	private ArrayList<AbMenuItem> mChild1 = null;
	private ArrayList<AbMenuItem> mChild2 = null;
	private UiLeftMenuAdapter mAdapter;
	private OnChangeViewListener mOnChangeViewListener;
	private TextView mNameText;
	private TextView mUserPoint;
	private ImageView mUserPhoto;
	private ImageView sunshineView;
	private AbImageLoader mAbImageLoader = null;
	private RelativeLayout loginLayout = null;
	private User mUser = null;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mActivity = (UiMain) this.getActivity();
		application = (MyApplication) mActivity.getApplication();

		View view = inflater.inflate(R.layout.main_menu, null);
		mMenuListView = (ExpandableListView) view.findViewById(R.id.menu_list);

		mNameText = (TextView) view.findViewById(R.id.user_name);
		mUserPhoto = (ImageView) view.findViewById(R.id.user_photo);
		mUserPoint = (TextView) view.findViewById(R.id.user_point);
		sunshineView = (ImageView) view.findViewById(R.id.sunshineView);
		loginLayout = (RelativeLayout) view.findViewById(R.id.login_layout);
		Button cacheClearBtn = (Button) view.findViewById(R.id.cacheClearBtn);

		cacheClearBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				AbDialogUtil.showProgressDialog(mActivity, 0, "正在清空缓存...");
				AbTask task = new AbTask();
				// 定义异步执行的对象
				final AbTaskItem item = new AbTaskItem();
				item.setListener(new AbTaskListener() {

					@Override
					public void update() {
						AbDialogUtil.removeDialog(mActivity);
						AbToastUtil.showToast(mActivity, "缓存已清空完成");
					}

					@Override
					public void get() {
						try {
							AbFileUtil.clearDownloadFile();
							AbImageCache.getInstance().clearBitmap();
						} catch (Exception e) {
							AbToastUtil.showToastInThread(mActivity,
									e.getMessage());
						}
					};
				});
				task.execute(item);

			}
		});

		mGroupName = new ArrayList<String>();
		mChild1 = new ArrayList<AbMenuItem>();
		mChild2 = new ArrayList<AbMenuItem>();

		ArrayList<ArrayList<AbMenuItem>> mChilds = new ArrayList<ArrayList<AbMenuItem>>();
		mChilds.add(mChild1);
		mChilds.add(mChild2);

		mAdapter = new UiLeftMenuAdapter(mActivity, mGroupName, mChilds);
		mMenuListView.setAdapter(mAdapter);
		for (int i = 0; i < mGroupName.size(); i++) {
			mMenuListView.expandGroup(i);
		}

		mMenuListView.setOnGroupClickListener(new OnGroupClickListener() {

			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				return true;
			}
		});

		mMenuListView.setOnChildClickListener(new OnChildClickListener() {

			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				if (mOnChangeViewListener != null) {
					mOnChangeViewListener.onChangeView(groupPosition,
							childPosition);
				}
				return true;
			}
		});

		// 图片的下载
		mAbImageLoader = new AbImageLoader(mActivity);
		mAbImageLoader.setMaxWidth(150);
		mAbImageLoader.setMaxHeight(150);

		initMenu();

		AbAnimationUtil.playRotateAnimation(sunshineView, 2000, 5,
				Animation.RESTART);

		mAbImageLoader.setErrorImage(R.drawable.image_error);
		mAbImageLoader.setEmptyImage(R.drawable.image_empty);

		return view;
	}

	public interface OnChangeViewListener {
		public abstract void onChangeView(int groupPosition, int childPosition);
	}

	public void setOnChangeViewListener(
			OnChangeViewListener onChangeViewListener) {
		mOnChangeViewListener = onChangeViewListener;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public void initMenu() {
		mGroupName.clear();
		mChild1.clear();
		mChild2.clear();

		mGroupName.add("常用");
		mGroupName.add("操作");

		AbMenuItem m0 = new AbMenuItem();
		m0.setIconId(R.drawable.message);
		m0.setText("信息");
		mChild1.add(m0);

		AbMenuItem m1 = new AbMenuItem();
		m1.setIconId(R.drawable.news);
		m1.setText("资讯");
		mChild1.add(m1);

		AbMenuItem m2 = new AbMenuItem();
		m2.setIconId(R.drawable.share);
		m2.setText("案例");
		mChild1.add(m2);

		AbMenuItem m3 = new AbMenuItem();
		m3.setIconId(R.drawable.set1);
		m3.setText("设置");
		mChild2.add(m3);

		AbMenuItem m4 = new AbMenuItem();
		m4.setIconId(R.drawable.about1);
		m4.setText("关于");
		mChild2.add(m4);

		AbMenuItem m5 = new AbMenuItem();
		m5.setIconId(R.drawable.quit1);
		m5.setText("退出");
		mChild2.add(m5);

		mAdapter.notifyDataSetChanged();
		for (int i = 0; i < mGroupName.size(); i++) {
			mMenuListView.expandGroup(i);
		}

		if (mUser == null) {
			setNameText("工作空间");
			setUserPhoto(R.drawable.photo01);
			setUserPoint("0");
			mNameText.setCompoundDrawables(null, null, null, null);
			loginLayout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if (mUser == null) {
						mActivity.toLogin(mActivity.LOGIN_CODE);
					}
				}
			});
		} else {
			setNameText(mUser.getUserName());
			downSetPhoto(mUser.getHeadUrl());
			if ("MAN".equals(mUser.getSex())) {
				Drawable d = mActivity.getResources().getDrawable(
						R.drawable.user_info_male);
				d.setBounds(0, 0, 26, 26);
				mNameText.setCompoundDrawables(null, null, d, null);
			} else if ("WOMAN".equals(mUser.getSex())) {
				Drawable d = mActivity.getResources().getDrawable(
						R.drawable.user_info_female);
				d.setBounds(0, 0, 26, 26);
				mNameText.setCompoundDrawables(null, null, d, null);
			} else {
				mNameText.setCompoundDrawables(null, null, null, null);
			}

			setUserPoint(String.valueOf(mUser.getPoint()));
			loginLayout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {

				}
			});
		}
		
		final String shareStr = this.getResources().getString(
				R.string.share_desc);
		setOnChangeViewListener(new OnChangeViewListener() {

			@Override
			public void onChangeView(int groupPosition, int childPosition) {
				if (groupPosition == 0) {
					if (childPosition == 0) {
						//消息
						Intent intent = new Intent(mActivity,
								MessageActivity.class);
						mActivity.startActivity(intent);
					} else if (childPosition == 1) {
						// 资讯
						Intent intent = new Intent(mActivity,
								ContacterActivity.class);
						startActivity(intent);
					} else if (childPosition == 2) {
						// 案例
						Intent intent = new Intent(mActivity,
								DemoMainActivity.class);
						startActivity(intent);
					}
				} else if (groupPosition == 1) {
					if (childPosition == 0) {
						// 设置
						Intent intent = new Intent(mActivity,
								AboutActivity.class);
						startActivity(intent);
					} else if (childPosition == 1) {
						// 关于
						Intent intent = new Intent(mActivity,
								AboutActivity.class);
						startActivity(intent);
					} else if (childPosition == 2) {
						//退出
						Intent intent = new Intent(mActivity,
								AboutActivity.class);
						startActivity(intent);
					}
				}
			}

		});

	}

	/**
	 * 描述：用户名的设置
	 * 
	 * @param mNameText
	 */
	public void setNameText(String mNameText) {
		this.mNameText.setText(mNameText);
	}

	/**
	 * 描述：设置用户阳光
	 * 
	 * @param mPoint
	 */
	public void setUserPoint(String mPoint) {
		this.mUserPoint.setText(mPoint);
		AbAnimationUtil.playRotateAnimation(sunshineView, 2000, 5,
				Animation.RESTART);
	}

	public void downSetPhoto(String mPhotoUrl) {
		// 缩放图片的下载
		mAbImageLoader.setEmptyImage(R.drawable.photo01);
		mAbImageLoader.setErrorImage(R.drawable.photo01_error);
		mAbImageLoader.display(mUserPhoto, mPhotoUrl);
	}

	/**
	 * 描述：设置头像
	 * 
	 * @param drawable
	 */
	public void setUserPhoto(int resId) {
		this.mUserPhoto.setImageResource(resId);
	}

}
