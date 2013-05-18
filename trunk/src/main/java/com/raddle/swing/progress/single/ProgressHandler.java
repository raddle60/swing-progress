package com.raddle.swing.progress.single;

import java.awt.Frame;

import com.raddle.swing.progress.ProgressContext;
import com.raddle.swing.progress.multi.MultiProgressCallback;
import com.raddle.swing.progress.multi.MultiProgressHandler;

/**
 * 类ProgressHandler.java的实现描述：显示进度条
 *
 * @author Administrator Oct 24, 2007 1:06:12 PM
 */
public class ProgressHandler {

    public static void doInProgress(final Frame owner, String title, int delayShow, final ProgressCallback callback) {

        MultiProgressHandler.doInMultiProgress(owner, title, 1, delayShow, new MultiProgressCallback() {

            @Override
            public void doWithMultiProgress(ProgressContext context) {
                callback.doWithProgress(context.getDialog(), context.getProgress(0));
            }

        });
    }
}
