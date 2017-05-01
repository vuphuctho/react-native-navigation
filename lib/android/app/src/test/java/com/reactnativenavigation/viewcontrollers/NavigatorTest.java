package com.reactnativenavigation.viewcontrollers;

import android.app.Activity;

import com.reactnativenavigation.BaseTest;
import com.reactnativenavigation.mocks.SimpleViewController;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.spy;

public class NavigatorTest extends BaseTest {
	private Activity activity;
	private Navigator uut;
	private SimpleViewController viewController;

	@Override
	public void beforeEach() {
		super.beforeEach();
		activity = newActivity();
		viewController = spy(new SimpleViewController(activity, "simpleViewController"));
		uut = new Navigator(activity);
	}


	@Test
	public void isActivityRusumed() throws Exception {
		assertThat(uut.isActivityResumed()).isFalse();
		uut.onActivityCreated();
		assertThat(uut.isActivityResumed()).isFalse();
		uut.onActivityResumed();
		assertThat(uut.isActivityResumed()).isTrue();
		uut.onActivityPaused();
		assertThat(uut.isActivityResumed()).isFalse();
	}
}
