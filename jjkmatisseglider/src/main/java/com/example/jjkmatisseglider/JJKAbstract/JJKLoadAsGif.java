package com.example.jjkmatisseglider.JJKAbstract;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.io.File;
import java.net.URL;

public abstract class JJKLoadAsGif {

    private JJKLoadAsGif() throws IllegalAccessException {
        throw new IllegalAccessException("Can not instantiate an abstract class");
    }

    // End Point: Load Bitmap as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Bitmap bitmap,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(bitmap)
                .into(holder);
    }

    // End Point: Load Image Uri as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Uri uri,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(uri)
                .into(holder);
    }

    // End Point: Load Image File as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final File file,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(file)
                .into(holder);
    }

    // End Point: Load Image File Path as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final String imagePath,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(imagePath)
                .into(holder);
    }

    // End Point: Load Image Drawable as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Drawable drawable,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(drawable)
                .into(holder);
    }

    // End Point: Load Image URL as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final URL url,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(url)
                .into(holder);
    }

    // End Point: Load Image Byte[] as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Byte[] imageBytes,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(imageBytes)
                .into(holder);
    }

    // End Point: Load Image Object Model as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Object imageModel,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(imageModel)
                .into(holder);
    }

    // End Point: Load Image Resource Id as Gif into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                                  final int resourceId,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .load(resourceId)
                .into(holder);
    }

}
