package com.example.jjkmatisseglider.JJKAbstract;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.net.URL;

public abstract class JJKLoadAsCircularGif {

    private JJKLoadAsCircularGif() throws IllegalAccessException {
        throw new IllegalAccessException("Can not instantiate an abstract class");
    }

    // End Point: Load Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Bitmap bitmap,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(bitmap)
                .into(holder);
    }

    // End Point: Load Image Uri as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Uri uri,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(uri)
                .into(holder);
    }

    // End Point: Load Image File as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final File file,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(file)
                .into(holder);
    }

    // End Point: Load Image File Path as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final String imagePath,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(imagePath)
                .into(holder);
    }

    // End Point: Load Image Drawable as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Drawable drawable,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(drawable)
                .into(holder);
    }

    // End Point: Load Image URL as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final URL url,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(url)
                .into(holder);
    }

    // End Point: Load Image Byte[] as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Byte[] imageBytes,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(imageBytes)
                .into(holder);
    }

    // End Point: Load Image Object Model as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                         @NonNull final Object imageModel,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(imageModel)
                .into(holder);
    }

    // End Point: Load Image Resource Id as Bitmap into ImageView
    public static void loadImageAsGif(   @NonNull final Context context,
                                                  final int resourceId,
                                         @NonNull final ImageView holder){
        Glide
                .with(context)
                .asGif()
                .apply(RequestOptions.centerCropTransform())
                .load(resourceId)
                .into(holder);
    }

}
