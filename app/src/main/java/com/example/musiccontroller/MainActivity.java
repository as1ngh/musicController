package com.example.musiccontroller;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musiccontroller2.musicController;

public class MainActivity extends AppCompatActivity implements musicController.MediaPlayerControl{
    private musicController mMediaController;
    MediaPlayer mMediaplayer;
    ImageView art;
    TextView name;
    TextView album;
    MediaMetadataRetriever metadataRetriever =new MediaMetadataRetriever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        art=findViewById(R.id.imageView);
        name=findViewById(R.id.textView);
        album=findViewById(R.id.textView2);
        mMediaplayer=MediaPlayer.create(getApplicationContext(), R.raw.testmusic);

        final AssetFileDescriptor afd=getResources().openRawResourceFd(R.raw.testmusic);
        metadataRetriever.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());

        Bitmap songImage = BitmapFactory
                .decodeByteArray(metadataRetriever.getEmbeddedPicture(), 0, metadataRetriever.getEmbeddedPicture().length);
        art.setImageBitmap(songImage);
        name.setText(metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        album.setText(metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));

        mMediaController = new musicController(this);
        mMediaController.setMediaPlayer(MainActivity.this);
        mMediaController.setAnchorView((ViewGroup) findViewById(R.id.audioView));
        mMediaController.show(10000);

        mMediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FOR NEXT
                Toast.makeText(getApplicationContext(),"NEXT CLICKED",Toast.LENGTH_SHORT).show();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FOR PREVIOUS
                Toast.makeText(getApplicationContext(),"PREVIOUS CLICKED",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void start() {
        mMediaplayer.start();

    }

    @Override
    public void pause() {
        if(mMediaplayer.isPlaying()){
            mMediaplayer.pause();
        }

    }

    @Override
    public int getDuration() {
        return mMediaplayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mMediaplayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mMediaplayer.seekTo(pos);

    }

    @Override
    public boolean isPlaying() {
        return mMediaplayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return (mMediaplayer.getCurrentPosition()*100)/mMediaplayer.getDuration();
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public boolean isFullScreen() {
        return false;
    }

    @Override
    public void toggleFullScreen() {

    }
}
