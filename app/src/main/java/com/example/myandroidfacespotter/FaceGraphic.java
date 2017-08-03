package com.example.myandroidfacespotter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.example.myandroidfacespotter.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.face.Face;


class FaceGraphic extends GraphicOverlay.Graphic {

    private static final String TAG = "FaceGraphic";

    private static final float DOT_RADIUS = 3.0f;
    private static final float TEXT_OFFSET_Y = -30.0f;

    private boolean mIsFrontFacing;

    // This variable may be written to by one of many threads. By declaring it as volatile,
    // we guarantee that when we read its contents, we're reading the most recent "write"
    // by any thread.
    private volatile Face mFace;

    private Paint mHintTextPaint;
    private Paint mHintOutlinePaint;
    private Paint mEyeWhitePaint;
    private Paint mIrisPaint;
    private Paint mEyeOutlinePaint;
    private Paint mEyelidPaint;

    private Drawable mPigNoseGraphic;
    private Drawable mMustacheGraphic;
    private Drawable mHappyStarGraphic;
    private Drawable mHatGraphic;


    FaceGraphic(GraphicOverlay overlay, Context context, boolean isFrontFacing) {
        super(overlay);
        mIsFrontFacing = isFrontFacing;
        Resources resources = context.getResources();
        initializePaints(resources);
        initializeGraphics(resources);
    }

    private void initializeGraphics(Resources resources) {
        mPigNoseGraphic = resources.getDrawable(R.drawable.pig_nose_emoji);
        mMustacheGraphic = resources.getDrawable(R.drawable.mustache);
        mHappyStarGraphic = resources.getDrawable(R.drawable.happy_star);
        mHatGraphic = resources.getDrawable(R.drawable.red_hat);
    }

    private void initializePaints(Resources resources) {
        mHintTextPaint = new Paint();
        mHintTextPaint.setColor(resources.getColor(R.color.overlayHint));
        mHintTextPaint.setTextSize(resources.getDimension(R.dimen.textSize));

        mHintOutlinePaint = new Paint();
        mHintOutlinePaint.setColor(resources.getColor(R.color.overlayHint));
        mHintOutlinePaint.setStyle(Paint.Style.STROKE);
        mHintOutlinePaint.setStrokeWidth(resources.getDimension(R.dimen.hintStroke));

        mEyeWhitePaint = new Paint();
        mEyeWhitePaint.setColor(resources.getColor(R.color.eyeWhite));
        mEyeWhitePaint.setStyle(Paint.Style.FILL);

        mIrisPaint = new Paint();
        mIrisPaint.setColor(resources.getColor(R.color.iris));
        mIrisPaint.setStyle(Paint.Style.FILL);

        mEyeOutlinePaint = new Paint();
        mEyeOutlinePaint.setColor(resources.getColor(R.color.eyeOutline));
        mEyeOutlinePaint.setStyle(Paint.Style.STROKE);
        mEyeOutlinePaint.setStrokeWidth(resources.getDimension(R.dimen.eyeOutlineStroke));

        mEyelidPaint = new Paint();
        mEyelidPaint.setColor(resources.getColor(R.color.eyelid));
        mEyelidPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(Canvas canvas) {

    }

}
