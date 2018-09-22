package `in`.co.ngcapp.ngc.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.widget.ImageView


@SuppressLint("NewApi")
class CircleImage(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : ImageView(context, attrs, defStyleAttr, defStyleRes) {


    override fun onDraw(canvas: Canvas?) {
        val drawable = drawable ?: return

        if (width == 0 || height == 0) {
            return
        }
        val b = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)

        val w = width
        val h = height

        val roundBitmap :Bitmap = getRoundedCroppedBitmap(bitmap, w)
       // canvas.drawBitmap(roundBitmap,w,w,null)

    }

    fun getRoundedCroppedBitmap(btmp: Bitmap, radius: Int): Bitmap {

        var finalBitmap: Bitmap;
        if (btmp.getWidth() != radius || btmp.getHeight() != radius)
            finalBitmap = Bitmap.createScaledBitmap(btmp, radius, radius,
                    false);
        else
            finalBitmap = btmp;
        var output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        var canvas: Canvas = Canvas(output);

        var paint: Paint = Paint()
        var rect: Rect = Rect(0, 0, finalBitmap.getWidth(),
                finalBitmap.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(finalBitmap.getWidth() / 2 + 0.7f,
                finalBitmap.getHeight() / 2 + 0.7f,
                finalBitmap.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(finalBitmap, rect, rect, paint);

        return output;

    }


}