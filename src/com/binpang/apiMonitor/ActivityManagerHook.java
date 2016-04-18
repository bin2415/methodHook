package com.binpang.apiMonitor;

import java.lang.reflect.Method;

import com.binpang.methodhook.FindMethod;
import com.binpang.methodhook.HookParam;
import com.binpang.methodhook.Logger;

public class ActivityManagerHook extends ApiMonitorHook {

	@Override
	public void startHook() {

		//中断进程，可用于关闭杀软
		Method killBackgroundProcessesmethod = FindMethod.findMethod(
				"android.app.ActivityManager", ClassLoader.getSystemClassLoader(),
				"killBackgroundProcesses", String.class);
		hookhelper.hookMethod(killBackgroundProcessesmethod, new AbstractBahaviorHookCallBack() {
			
			@Override
			public void descParam(HookParam param) {
				// TODO Auto-generated method stub
				String packageName = (String) param.args[0];
				Logger.logI("kill packagename = "+packageName);
			}
		});
		
		Method forceStopPackagemethod = FindMethod.findMethod(
				"android.app.ActivityManager", ClassLoader.getSystemClassLoader(),
				"forceStopPackage", String.class);
		hookhelper.hookMethod(forceStopPackagemethod, new AbstractBahaviorHookCallBack() {
			
			@Override
			public void descParam(HookParam param) {
				// TODO Auto-generated method stub
				String packageName = (String) param.args[0];
				Logger.logI("kill packagename = "+packageName);
			}
		});
		Method reStartPackagemethod = FindMethod.findMethod(
				"android.app.ActivityManager", ClassLoader.getSystemClassLoader(),
				"restartPackage", String.class);
		hookhelper.hookMethod(killBackgroundProcessesmethod, new AbstractBahaviorHookCallBack() {
			
			@Override
			public void descParam(HookParam param) {
				// TODO Auto-generated method stub
				String packageName = (String) param.args[0];
				Logger.logI("Restart packagename = "+packageName);
			}
		});
	}

	
}
