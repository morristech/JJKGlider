package com.example.jjkmatisseglider.Listener;

import android.net.Uri;

import java.util.List;

public interface JJKVideoPickerListener {
    void onVideoPicked(List<String> selectedVideoPaths, List<Uri> selectedVideoUris);
}
