package com.example.jjkmatisseglider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.jjkmatisseglider.Listener.JJKImagePickerListener;
import com.example.jjkmatisseglider.Listener.JJKVideoPickerListener;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class JJKMatisseGlider {

    private static JJKMatisseGlider mInstance;
    public static JJKMatisseGlider getInstance(){
        if(mInstance == null)
            mInstance = new JJKMatisseGlider();

        return mInstance;
    }

    private static final int REQUEST_CODE_CHOOSE = 5454;
    private static final int VIDEO_PICKER_REQUEST_CODE = 6363;

    private static JJKImagePickerListener mImagePickerListener;
    private static JJKVideoPickerListener mVideoPickerListener;

    public void setUpImagePickerListener(JJKImagePickerListener listener){
        mImagePickerListener = listener;
    }

    public void setUpVideoPickerListener(JJKVideoPickerListener listener){
        mVideoPickerListener = listener;
    }

    // End Point : Pick Images From Gallery
    public void pickImage(Context context, int maxImages){

        if(maxImages <= 0){
            maxImages = 1;
        }

        Matisse.from((Activity) context)
                .choose(MimeType.ofImage())
                .countable(true)
                .maxSelectable(maxImages)
                .gridExpectedSize(context.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    // End Point : Pick Images From Gallery
    public void pickImage(FragmentActivity fragmentActivity, int maxImages){

        if(maxImages <= 0){
            maxImages = 1;
        }

        Matisse.from(fragmentActivity)
                .choose(MimeType.ofImage())
                .countable(true)
                .maxSelectable(maxImages)
                .gridExpectedSize(fragmentActivity.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);

    }

    // End Point : Pick Videos From Gallery
    public void pickVideo(Context context, int maxVideos){

        if(maxVideos <= 0){
            maxVideos = 1;
        }

        Matisse.from((Activity) context)
                .choose(MimeType.ofVideo())
                .countable(true)
                .maxSelectable(maxVideos)
                .gridExpectedSize(context.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(VIDEO_PICKER_REQUEST_CODE);

    }

    // End Point : Pick Videos From Gallery
    public void pickVideo(FragmentActivity fragmentActivity, int maxVideos){

        if(maxVideos <= 0){
            maxVideos = 1;
        }

        Matisse.from(fragmentActivity)
                .choose(MimeType.ofVideo())
                .countable(true)
                .maxSelectable(maxVideos)
                .gridExpectedSize(fragmentActivity.getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(VIDEO_PICKER_REQUEST_CODE);

    }

    public static void onResultReceived(int requestCode, int resultCode,@Nullable Intent data){
        if(resultCode == RESULT_OK){
            if(data != null){
                if(requestCode == REQUEST_CODE_CHOOSE){

                    List<String> paths = Matisse.obtainPathResult(data);
                    List<Uri> uris = Matisse.obtainResult(data);

                    mImagePickerListener.onImagePicked(paths, uris);

                }else if(requestCode == VIDEO_PICKER_REQUEST_CODE){

                    List<String> paths = Matisse.obtainPathResult(data);
                    List<Uri> uris = Matisse.obtainResult(data);

                    mVideoPickerListener.onVideoPicked(paths, uris);
                }

            }else {
                mVideoPickerListener.onVideoPicked(null, null);
            }
        }
    }

}
