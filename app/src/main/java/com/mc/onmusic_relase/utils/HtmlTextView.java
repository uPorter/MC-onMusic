package com.mc.onmusic_relase.utils;

import android.content.Context;
import android.text.Html;

public class HtmlTextView extends android.support.v7.widget.AppCompatTextView {
    public HtmlTextView(Context context) {
        super(context);
        this.setText(Html.fromHtml(getText().toString()));
    }
}
