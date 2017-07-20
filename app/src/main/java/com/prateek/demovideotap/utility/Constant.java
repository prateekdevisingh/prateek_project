package com.prateek.demovideotap.utility;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by prateek on 18/7/17.
 */

public class Constant {
    public static final int DEVICE_PHONE = 1;
    public static final int DEVICE_TABLET = 2;
    public static int DEVICE = DEVICE_PHONE;

    public static final int FONT_REGULAR = 1;
    public static final int FONT_MEDIUM = 2;
    public static final int FONT_CALIBRI = 3;
    public static final int FONT_CURSIVE = 4;
    public static final int FONT_FANTASY = 5;
    public static final int FONT_SHOW_CASE = 6;
    public static final int FONT_RUGE_BOOGIE = 7;
    public static final int FONT_COOKIE = 8;
    public static final int FONT_COVERED_BY_YOUR_FACE = 9;
    public static final int FONT_FREDERICKA_THE_GREAT = 10;
    public static final int FONT_INDIE_FLOWER = 11;
    public static final int FONT_HELVETICA_NEUE_MED = 12;
    public static final int FONT_HELVETICA_REGULAR = 13;
    public static final int FONT_AERIAL_REGULAR = 14;
    public static final int FONT_SANS_SERIF_REGUALR = 15;

    public static Typeface getTypeface(Context ctx, int font_type) {
        Typeface typeface = Typeface.DEFAULT;

        try {
            if (font_type == Constant.FONT_REGULAR) {
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/roboto-regular.ttf");
            } else if (font_type == Constant.FONT_MEDIUM) {
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/roboto-medium.ttf");
            } else if (font_type == Constant.FONT_CURSIVE) {
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/cursive.ttf");
            } else if (font_type == Constant.FONT_FANTASY) {
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/fantasy.ttf");
            } else if (font_type == Constant.FONT_SHOW_CASE) {
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/show_case_font.ttf");
            } else if(font_type == Constant.FONT_RUGE_BOOGIE){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/rugeboogie.ttf");
            } else if (font_type == Constant.FONT_COOKIE){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/cookie-regular.ttf");
            } else if (font_type == Constant.FONT_COVERED_BY_YOUR_FACE){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/coveredbyyourgrace.ttf");
            } else if (font_type == Constant.FONT_FREDERICKA_THE_GREAT){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/frederickathegreat-regular.ttf");
            } else if (font_type == Constant.FONT_INDIE_FLOWER){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/indieflower.ttf");
            } else if (font_type == Constant.FONT_HELVETICA_NEUE_MED){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/helveticaneuemed.ttf");
            } else if (font_type == Constant.FONT_HELVETICA_REGULAR){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/helvetica-regular.ttf");
            } else if (font_type == Constant.FONT_AERIAL_REGULAR){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/arial-regular.ttf");
            } else if (font_type == Constant.FONT_SANS_SERIF_REGUALR){
                typeface = Typeface.createFromAsset(ctx.getAssets(), "fonts/adventpro-regular.ttf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeface;

    }
}
