# movizo-android-player-sdk

動画配信サービス「モビゾ」の利用者のためのAndroid SDKです。

## 説明

* Movizoにアップロードした動画を再生するAndroidアプリを簡単に作成でき、動画の視聴ログも記録できます。

* 利用方法につきましては、[サンプルプログラム](https://github.com/bylomedia/movizo-android-player-sdk-sample)をご参照ください。

## 制限事項

* MovizoのアカウントID、動画IDが必要です。

* Android 4.1(Jelly Bean) API Level 16以上で動作します。

* google ExoPlayer r1.2.4 が必要です。

## 使い方

gradle

```
repositories {
     maven { url 'http://raw.github.com/bylomedia/movizo-android-player-sdk/master' }
}

```

```
dependencies {
    compile 'com.google.android.exoplayer:exoplayer:r1.2.4'
    compile 'jp.movizo.android.player:library:1.0.0'
}
```
