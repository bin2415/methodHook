# 安装条件及过程：
* 需要一台root过的android4.4.x的设备
* 在该设备中安装Xposed Installer客户端，由于安装Xposed时，需要将android的app_main.cpp等文件进行替换，     
所以需要android的root权限
* 安装编写好的com.bingpang.methodhook模块至该客户端，此时Xposed客户端将会检测到有Xposed模块，如图所示    
![安装模板截图](moban.png)
* 勾选该模板并重启android设备
----
----
----
# Hook Method解析
## 实现的功能
* 标签为FM的log输出了具体敏感函数的类和方法名，如android.telephony.SmsManager->sendTextMessage
* 标签为DetailInform的log则输出了敏感函数相应的数据，如在android.telephony.SmsManager->sendTextMessage中      
会输出Send SMS -> SMS DestNumber: destNumber , SMS Content: Content      
## 具体的敏感函数列表

*SmsManager*
- android.telephony.SmsManager/sendTextMessage
- android.telephony.SmsManager/getAllMessagesFromIcc
- android.telephony.SmsManager/sendDataMessage
- android.telephony.SmsManager/sendMultipartTextMessage

*TelephonyManager*
- android.telephony.TelephonyManager/getLine1Number
- android.telephony.TelephonyManager/listen

*AccountManager*
- android.accounts.AccountManager/getAccounts
- android.accounts.AccountManager/getAccountsByType

*ActivityManager*
- android.app.ActivityManager/killBackgroundProcesses
- android.app.ActivityManager/forceStopPackage

*AlarmManager*
- android.app.AlarmManager/setImpl

*AudioRecord*
- android.media.AudioRecord

*Camera*
- android.hardware.Camera/takepicture
- android.hardware.Camera/setPreviewCallback
- android.hardware.Camera/setPreviewCallbackWithBuffer
- android.hardware.Camera/setOneShotPreviewCallback

*ConnectivityManager*
- android.net.ConnectivityManager/setMobileDataEnabled

*ContentResolver*
- android.content.ContentResolver/qurey
- android.content.ContentResolver/registerContentObserver
- android.content.ContentResolver/insert
- android.content.ContentResolver/bulkInsert
- android.content.ContentResolver/delete
- android.content.ContentResolver/update
- android.content.ContentResolver/applyBatch

*ContextImpl*
- android.app.ContextImpl/registerReceiver

*MediaRecorder*
- android.media.MediaRecorder/start
- android.media.MediaRecorder/stop

*Internet*
- java.net.URL/openConnection
- org.apache.http.impl.client.AbstractHttpClient/execute

*NotificationManager*
- android.app.NotificationManager/notify

*ApplicationPackageManager*
- android.app.ApplicationPackageManager/installPackage
- android.app.ApplicationPackageManager/deletePackage
- android.app.ApplicationPackageManager/getInstalledPackages

