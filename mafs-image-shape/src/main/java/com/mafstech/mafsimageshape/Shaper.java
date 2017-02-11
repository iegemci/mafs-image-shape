package com.mafstech.mafsimageshape;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.widget.ImageView;

/**
 * Created by mafujul on 2/11/17.
 */

public class Shaper {

    public static void shape(Context context, int originalIMG, int bitmapIMG, ImageView imgView, int height, int width) {

        Bitmap original = BitmapFactory.decodeResource(context.getResources(), originalIMG);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapIMG);

        Bitmap mask = bitmap;

        original = getResizedBitmap(original, height, width);

        int bitmapHeight = bitmap.getHeight();
        int bitmapWidth = bitmap.getWidth();
        Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas mCanvas = new Canvas(result);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        int widthMask = mask.getWidth();
        int heightMask = mask.getHeight();
        float centerX = (widthMask - original.getWidth()) * 0.5f;
        float centerY = (heightMask - original.getHeight()) * 0.5f;

        mCanvas.drawBitmap(original, centerX, centerY, null);
        mCanvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);

        imgView.getLayoutParams().height = bitmapHeight;
        imgView.getLayoutParams().width = bitmapWidth;
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setImageBitmap(result);
        imgView.setAdjustViewBounds(true);

    }

    public static Bitmap getResizedBitmap(Bitmap bm, float newHeight, float newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);

        return resizedBitmap;
    }

}
