package com.prateek.demovideotap.utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.prateek.demovideotap.R;


/**
 * Created by Prateek on 18/7/17.
 */
public class TextViewRoboto extends AppCompatTextView {
    private static final String TAG = "TextView";

    boolean isFirstCapital = true;
    public TextViewRoboto(Context context) {
        super(context);
    }

    public TextViewRoboto(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context, attrs);
        setStyle(context, attrs);
        setFirstLetterCapital(context, attrs);
    }

    public TextViewRoboto(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont(context, attrs);
        setStyle(context, attrs);
        setFirstLetterCapital(context, attrs);
    }

    private void setFirstLetterCapital(Context context, AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes ( attributeSet , R.styleable.textViewFont );
         isFirstCapital = typedArray.getBoolean ( R.styleable.textViewFont_firstCaps, true );

    }
    @Override
    public void setText(CharSequence text, BufferType type) {
        if(text!=null) {
            this.setEllipsize(TextUtils.TruncateAt.END);
            if (text.length() > 0 && isFirstCapital) {
                text = String.valueOf(text.charAt(0)).toUpperCase() + text.subSequence(1, text.length());
            }
            super.setText(text, type);
        }
    }

    private void setFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.textViewFont);
        int customFont = a.getInt( R.styleable.textViewFont_font, 1);
        setCustomFont(ctx, customFont);
        a.recycle();
    }
    private void setStyle(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs,R.styleable.textViewFont);
        int style = a.getInt(R.styleable.textViewFont_textStyle, 0);
        setTextStyle(style);
        a.recycle();
    }

    public void setTextStyle(int style){
        switch (style){
            case Typeface.BOLD:
                setTypeface(getTypeface(), Typeface.BOLD);
                break;
            case Typeface.ITALIC:
                setTypeface(getTypeface(), Typeface.ITALIC);
                break;
            case Typeface.NORMAL:
                setTypeface(getTypeface(), Typeface.NORMAL);
                break;
        }

    }

    public boolean setCustomFont(Context ctx, int font_type) {
        Typeface typeface = null;

        try {
            if (font_type == Constant.FONT_REGULAR) {
                typeface = Constant.getTypeface(getContext(),Constant.FONT_REGULAR);
            } else {
                typeface = Constant.getTypeface(getContext(),Constant.FONT_MEDIUM);
            }

            setTypeface(typeface);
            return true;

        }catch (Exception e){
            return false;
        }

    }



}
