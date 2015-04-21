package com.can2do.doimmpro.main;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ab.activity.AbActivity;
import com.ab.db.storage.AbSqliteStorage;
import com.ab.db.storage.AbSqliteStorageListener.AbDataSelectListener;
import com.ab.db.storage.AbStorageQuery;
import com.ab.util.AbToastUtil;
import com.ab.view.pullview.AbPullToRefreshView;
import com.ab.view.pullview.AbPullToRefreshView.OnFooterLoadListener;
import com.ab.view.pullview.AbPullToRefreshView.OnHeaderRefreshListener;
import com.ab.view.titlebar.AbTitleBar;
import com.can2do.doimmpro.R;
import com.can2do.doimmpro.global.MyApplication;

/**
 * 消息列表界面
 * 
 */
public class MessageActivity extends AbActivity implements
		OnHeaderRefreshListener, OnFooterLoadListener {

	private MyApplication application;
	private AbPullToRefreshView mAbPullToRefreshView = null;
	private ListView mListView = null;
	// 每一页显示的行数
	public int pageSize = 10;
	// 当前页数
	public int pageNum = 1;

	// 数据库操作类
	private AbSqliteStorage mAbSqliteStorage = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setAbContentView(R.layout.im_message_list);

		AbTitleBar mAbTitleBar = this.getTitleBar();
		mAbTitleBar.setTitleText(R.string.message_name);
		mAbTitleBar.setLogo(R.drawable.button_selector_back);
		mAbTitleBar.setTitleBarBackground(R.drawable.top_bg);
		mAbTitleBar.setTitleTextMargin(10, 0, 0, 0);
		mAbTitleBar.setLogoLine(R.drawable.line);

		application = (MyApplication) getApplication();

		// 初始化AbSqliteStorage
		mAbSqliteStorage = AbSqliteStorage.getInstance(this);

		// 获取ListView对象
		mAbPullToRefreshView = (AbPullToRefreshView) this
				.findViewById(R.id.mPullRefreshView);
		mListView = (ListView) this.findViewById(R.id.mListView);

		// 打开关闭下拉刷新加载更多功能
		mAbPullToRefreshView.setOnHeaderRefreshListener(this);
		mAbPullToRefreshView.setOnFooterLoadListener(this);

		// 设置进度条的样式
		mAbPullToRefreshView.getHeaderView().setHeaderProgressBarDrawable(
				this.getResources().getDrawable(R.drawable.progress_circular));
		mAbPullToRefreshView.getFooterView().setFooterProgressBarDrawable(
				this.getResources().getDrawable(R.drawable.progress_circular));
		// mAbPullListView.getHeaderView().setHeaderProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular2));
		// mAbPullListView.getFooterView().setFooterProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular2));

		// item被点击事件
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			}
		});

	}

	@Override
	protected void onResume() {
		// 第一次下载数据
		queryData(0);

		super.onResume();
	}

	@Override
	public void onHeaderRefresh(AbPullToRefreshView view) {
		pageNum = 1;
		queryData(0);
	}

	@Override
	public void onFooterLoad(AbPullToRefreshView view) {
		pageNum++;
		queryData(1);
	}

	public void queryData(final int query) {
		// 查询数据
		AbStorageQuery mAbStorageQuery = new AbStorageQuery();

		AbStorageQuery mAbStorageQuery2 = new AbStorageQuery();
		mAbStorageQuery.or(mAbStorageQuery2);
		mAbStorageQuery.setLimit(pageSize);
		mAbStorageQuery.setOffset((pageNum - 1) * pageSize);

	}

}
