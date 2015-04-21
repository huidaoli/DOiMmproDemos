package com.can2do.doimmpro.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import com.ab.view.sliding.AbSlidingTabView;
import com.can2do.doimmpro.R;
import com.can2do.doimmpro.main.UiMainContentFragment;

public class UiMainSlidingTabFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab_top, null);
		AbSlidingTabView mAbSlidingTabView = (AbSlidingTabView) view
				.findViewById(R.id.mAbSlidingTabView);

		// 如果里面的页面列表不能下载原因：
		// Fragment里面用的AbTaskQueue,由于有多个tab，顺序下载有延迟，还没下载好就被缓存了。改成用AbTaskPool，就ok了。
		// 或者setOffscreenPageLimit(0)

		// 缓存数量
		mAbSlidingTabView.getViewPager().setOffscreenPageLimit(5);

		UiMainContentFragment page1 = new UiMainContentFragment();
		UiMainContentFragment page2 = new UiMainContentFragment();
		UiMainContentFragment page3 = new UiMainContentFragment();
		UiMainContentFragment page4 = new UiMainContentFragment();
		UiMainContentFragment page5 = new UiMainContentFragment();
		UiMainContentFragment page6 = new UiMainContentFragment();
//		MainContentFragment page7 = new MainContentFragment();
//		MainContentFragment page8 = new MainContentFragment();
		
		List<Fragment> mFragments = new ArrayList<Fragment>();
		mFragments.add(page1);
		mFragments.add(page2);
		mFragments.add(page3);
		mFragments.add(page4);

		List<String> tabTexts = new ArrayList<String>();
		tabTexts.add("首页");
		tabTexts.add("餐饮");
		tabTexts.add("保健");
		tabTexts.add("器材");
		
		// 设置样式
		mAbSlidingTabView.setTabTextColor(Color.BLACK);
		mAbSlidingTabView.setTabSelectColor(Color.rgb(30, 168, 131));
		mAbSlidingTabView.setTabBackgroundResource(R.drawable.tab_bg);
		mAbSlidingTabView.setTabLayoutBackgroundResource(R.drawable.slide_top);
		// 演示增加一组
		mAbSlidingTabView.addItemViews(tabTexts, mFragments);

		// 演示增加一个
		mAbSlidingTabView.addItemView("礼品", page5);
		mAbSlidingTabView.addItemView("其他", page6);
//		mAbSlidingTabView.addItemView("其他", page7);
//		mAbSlidingTabView.addItemView("其他", page8);

		mAbSlidingTabView.setTabPadding(20, 8, 20, 8);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
