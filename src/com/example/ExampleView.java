package com.example;

import android.content.Context;
import android.renderscript.Float4;
import android.renderscript.RSSurfaceView;
import android.renderscript.RenderScriptGL;
import android.renderscript.RenderScriptGL.SurfaceConfig;
import android.view.MotionEvent;

public class ExampleView extends RSSurfaceView {
    private RenderScriptGL mRS;
    private ScriptC_example mScript;

    public ExampleView(Context context) {
        super(context);
        final RenderScriptGL.SurfaceConfig sc = new SurfaceConfig();
        mRS = createRenderScriptGL(sc);
        mScript = new ScriptC_example(mRS, getResources(), R.raw.example);
        mRS.bindRootScript(mScript);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
        case MotionEvent.ACTION_MOVE:
            float x = event.getX()/getWidth();
            float y = event.getY()/getHeight();

            Float4 color = new Float4(x, y, 0.5f, 1.0f);
            mScript.set_bgColor(color);
            return true;
        }
        return super.onTouchEvent(event);
    }
}
