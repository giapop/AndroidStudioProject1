package com.example.tema4dam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Map;

public class GraficView extends View {

    private final Context context;
    private final Map<String, Integer> source;
    private final Paint paint;
    public GraficView(Context context, Map<String, Integer> source) {
        super(context);
        this.context = context;
        this.source = source;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (source == null || source.isEmpty()) {
            return;
        }


        float latimeBara = (float) getWidth() / source.size();

        int maximVal = calculeazaMaxim();

        int pozitiaCurenta = 0;
        for (String label : source.keySet()) {

            int value = source.get(label);
            paint.setColor(coloreaza(pozitiaCurenta));

            float x1 = pozitiaCurenta * latimeBara;
            float y1 = (1 - (float) value / maximVal) * getHeight();
            float x2 = x1 + latimeBara;
            float y2 = getHeight();
            canvas.drawRect(x1, y1, x2, y2, paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize((float) (0.25 * latimeBara));
            float x = (float) ((pozitiaCurenta + 0.5) * latimeBara);
            float y = (float) (0.95 * getHeight());
            canvas.rotate(270, x, y);
            canvas.drawText(context.getString(R.string.grafic_name, label, value), x, y, paint);
            canvas.rotate(-270, x, y);

            pozitiaCurenta++;
        }

    }

    private int coloreaza(int pozitiaCurenta) {
        if(pozitiaCurenta%2!=0){
            return Color.RED;
        }
        return  Color.GREEN;
    }

    private int calculeazaMaxim() {
        int maxim = 0;
        for (Integer valoare : source.values()) {
            if (maxim < valoare) {
                maxim = valoare;
            }
        }
        return maxim;
    }


}
