# movizo-player-android

動画配信サービス「モビゾ」の利用者のためのAndroid SDKとサンプルアプリです。

## 説明

* 動画配信サービス「モビゾ」にアップロードした動画を再生するAndroidアプリを簡単に作成でき、動画の視聴ログも記録できます。

* 利用方法につきましては、サンプルプログラムをご参照ください。

* サンプルプログラムの利用方法

```
1. git clone https://github.com/bylomedia/movizo-player-android.git
2. AndroidStudioでサンプルプロジェクト(./movizo-player-android/jp/movizo/android/player/Example/)を開き、ビルド＆実行します。
```

## 制限

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
