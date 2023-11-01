clear
keytool -genkey -v -keystore begone_app.jks -keyalg RSA -keysize 2048 -validity 10000 -alias begone
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore begone_app.jks E:\Projets\android_begone\Android_Begone\platforms\android\app\build\outputs\apk\release\app-release-unsigned.apk begone
zipalign -v 4 E:\Projets\android_begone\Android_Begone\platforms\android\app\build\outputs\apk\release\app-release-unsigned.apk E:\Projets\android_begone\android_begone.apk
apksigner verify E:\Projets\android_begone\android_begone.apk