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
1. android.telephony.SmsManager/sendTextMessage
2. android.telephony.SmsManager/getAllMessagesFromIcc
3. android.telephony.SmsManager/sendDataMessage
4. android.telephony.SmsManager/sendMultipartTextMessage
*TelephonyManager*
1. android.telephony.TelephonyManager/getLine1Number
2. android.telephony.TelephonyManager/listen
*AccountManager*
1. android.accounts.AccountManager/getAccounts
2. android.accounts.AccountManager/getAccountsByType
*ActivityManager*
1. android.app.ActivityManager/killBackgroundProcesses
2. android.app.ActivityManager/forceStopPackage
*AlarmManager*
1. android.app.AlarmManager/setImpl
*AudioRecord*
1. android.media.AudioRecord
*Camera*
1. android.hardware.Camera/takepicture
2. android.hardware.Camera/setPreviewCallback
3. android.hardware.Camera/setPreviewCallbackWithBuffer
4. android.hardware.Camera/setOneShotPreviewCallback
*ConnectivityManager*
1. android.net.ConnectivityManager/setMobileDataEnabled
*ContentResolver*
1. android.content.ContentResolver/qurey
2. android.content.ContentResolver/registerContentObserver
3. android.content.ContentResolver/insert
4. android.content.ContentResolver/bulkInsert
5. android.content.ContentResolver/delete
6. android.content.ContentResolver/update
7. android.content.ContentResolver/applyBatch
*ContextImpl*
1. android.app.ContextImpl/registerReceiver
*MediaRecorder*
1. android.media.MediaRecorder/start
2. android.media.MediaRecorder/stop
*Internet*
1. java.net.URL/openConnection
2. org.apache.http.impl.client.AbstractHttpClient/execute
*NotificationManager*
1. android.app.NotificationManager/notify
*ApplicationPackageManager*
1. android.app.ApplicationPackageManager/installPackage
2. android.app.ApplicationPackageManager/deletePackage
3. android.app.ApplicationPackageManager/getInstalledPackages

