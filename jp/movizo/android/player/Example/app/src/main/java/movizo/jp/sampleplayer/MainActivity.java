package movizo.jp.sampleplayer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer.ExoPlayer;

import jp.movizo.android.player.library.MovizoPlayer;
import jp.movizo.android.player.library.MovizoUtil;

public class MainActivity extends AppCompatActivity implements MovizoPlayer.Listener {
    private static final String TAG = "SampleActivity";
    private SurfaceView surfaceView;
    private MovizoPlayer player;
    private TextView debugTextView; // デバッグ表示用

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        debugTextView = (TextView) findViewById(R.id.debug_text_view);

        // インスタンス作成（必須）
        // 動画を表示するSurfaceViewを渡します
        player = new MovizoPlayer(this, surfaceView);

        // イベントリスナー（任意）
        // 動画の再生状況(onStateChanged)を取得する場合はセットします。
        player.addListener(this);

        // 動画の読み込み（必須）
        // MOVIZOのアカウントID(ここではAAAAAAAA),動画ID(ここではMMMMMMMM),及び配信方法をセットします。
        // 配信方法は、HLSストリーミング(MovizoUtil.Format.HLS)、またはダウンロード再生(MovizoUtil.Format.M4V)のいづれかを指定します。
        player.loadMovie("AAAAAAAA", "MMMMMMMM", MovizoUtil.Format.HLS);

        // ループ再生（任意）
        // ループ再生する場合はtrueをセットします。（デフォルトはfalse）
        player.setRepeatPlay(true);

        // 再生開始（必須）
        player.play();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (player != null) {
            // バックグラウンドから復帰
            player.resume();
            player.play();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player != null) {
            // バックグランドへ移行
            player.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            // 終了
            player.release();
            player = null;
        }
    }

    //端末の向き(landscapeとportrait)を表示
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    // Movizo.listner
    // 再生状況を表示する
    @Override
    public void onStateChanged(boolean playWhenReady, int playbackState) {
        String text = "playWhenReady=" + playWhenReady + ", playbackState=";
        switch (playbackState) {
            case ExoPlayer.STATE_BUFFERING:
                text += "buffering";
                break;
            case ExoPlayer.STATE_ENDED:
                text += "ended";
                break;
            case ExoPlayer.STATE_IDLE:
                text += "idle";
                break;
            case ExoPlayer.STATE_PREPARING:
                text += "preparing";
                break;
            case ExoPlayer.STATE_READY:
                text += "ready";
                break;
            default:
                text += "unknown";
                break;
        }
        text += ", current=";
        text += player.getCurrentPosition();

        debugTextView.setText(text);
    }

    @Override
    public void onError(Exception e) {
    }
}