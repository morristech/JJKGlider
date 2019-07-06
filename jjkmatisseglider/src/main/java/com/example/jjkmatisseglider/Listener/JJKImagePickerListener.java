package com.example.jjkmatisseglider.Listener;

import android.net.Uri;

import java.util.List;

public interface JJKImagePickerListener {
    void onImagePicked(List<String> selectedImagesPath, List<Uri> selectedImagesUri);
}
