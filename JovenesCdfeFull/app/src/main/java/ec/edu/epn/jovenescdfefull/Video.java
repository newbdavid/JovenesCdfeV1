package ec.edu.epn.jovenescdfefull;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r1---sn-q4fl6ney.googlevideo.com/Cj0LENy73wIaNAl5UeO2h2AIgBMYDSANFC0T809YMOCoAUIASARgj4q3qoPd-adYigELUXpyNFFCWktES2sM/73A96239D9175B34BCFBDD6872EF1DBA39AAD1F2.105E2AEF8F83FCFBBCEEC3A8EA3082020B6D8537/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
