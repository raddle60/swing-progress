package com.raddle.swing.progress;

import java.awt.Frame;

import com.raddle.swing.progress.multi.MultiProgressCallback;
import com.raddle.swing.progress.multi.MultiProgressHandler;
import com.raddle.swing.progress.single.ProgressCallback;
import com.raddle.swing.progress.single.ProgressHandler;

/**
 * 类ProgressUtils.java的实现描述：进度条工具类
 * 
 * @author xurong 2009-7-4 下午03:44:52
 */
public class ProgressUtils {

    /**
     * 单个进度条
     * 
     * @param owner
     * @param title
     * @param callback
     */
    public static void doInProgress(final Frame owner, String title, final ProgressCallback callback) {
        ProgressHandler.doInProgress(owner, title, callback);
    }

    /**
     * 多个进度条
     * 
     * @param owner
     * @param title
     * @param progressCount
     * @param callback
     */
    public static void doInMultiProgress(final Frame owner, final String title, final int progressCount, final MultiProgressCallback callback) {
        MultiProgressHandler.doInMultiProgress(owner, title, progressCount, callback);
    }
}
