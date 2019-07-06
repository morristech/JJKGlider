package com.example.jjglider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.jjkmatisseglider.JJKAbstract.JJKLoadAsBitmap;
import com.example.jjkmatisseglider.JJKMatisseGlider;
import com.example.jjkmatisseglider.Listener.JJKImagePickerListener;
import com.example.jjkmatisseglider.Listener.JJKVideoPickerListener;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements JJKImagePickerListener, JJKVideoPickerListener {

    // Widgets
    private Button mImagePickerButton, mVideoPickerButton;
    private ImageView mImageHolder;
    private VideoView mVideoHolder;

    private JJKMatisseGlider mJJKMatisseGlider;
    private MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImagePickerButton = findViewById(R.id.pick_image_from_activity);
        mVideoPickerButton = findViewById(R.id.pick_video_from_activity);
        mImageHolder = findViewById(R.id.image_holder);
        mVideoHolder = findViewById(R.id.video_holder);

        mMediaController = new MediaController(this);

        mJJKMatisseGlider = JJKMatisseGlider.getInstance();
        mJJKMatisseGlider.setUpImagePickerListener(this);
        mJJKMatisseGlider.setUpVideoPickerListener(this);

        // Trigger Action as per Button clicked
        mImagePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJJKMatisseGlider.pickImage(MainActivity.this, 1);
            }
        });

        mVideoPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJJKMatisseGlider.pickVideo(MainActivity.this,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        JJKMatisseGlider.onResultReceived(requestCode,resultCode,data);
    }

    @Override
    public void onImagePicked(List<String> selectedImagesPath, List<Uri> selectedImagesUri) {
        if (selectedImagesPath != null) {
            mImageHolder.setVisibility(View.VISIBLE);
            mVideoHolder.setVisibility(View.GONE);

            JJKLoadAsBitmap.loadImageAsBitmap(
                    MainActivity.this,
                    selectedImagesPath.get(0),
                    mImageHolder);
        } else {
            mImageHolder.setVisibility(View.GONE);
            mVideoHolder.setVisibility(View.GONE);
        }
    }

    @Override
    public void onVideoPicked(List<String> selectedVideosPath, List<Uri> selectedVideoUris) {
        if (selectedVideosPath != null) {
            mImageHolder.setVisibility(View.GONE);
            mVideoHolder.setVisibility(View.VISIBLE);

            loadVideo(selectedVideosPath.get(0));

        } else {
            mImageHolder.setVisibility(View.GONE);
            mVideoHolder.setVisibility(View.GONE);
        }
    }

    // Load Video into VideoView using selected Video Path
    private void loadVideo(String videoPath) {
        mVideoHolder.setVideoPath(videoPath);
        mVideoHolder.setMediaController(mMediaController);
        mMediaController.setAnchorView(mVideoHolder);
        mVideoHolder.start();
    }

    // Load Video into VideoView using selected Video Uri
    private void loadVideo(Uri videoUri) {
        mVideoHolder.setVideoURI(videoUri);
        mVideoHolder.setMediaController(mMediaController);
        mMediaController.setAnchorView(mVideoHolder);
        mVideoHolder.start();
    }

}
