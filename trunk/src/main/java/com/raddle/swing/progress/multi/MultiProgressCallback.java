package com.raddle.swing.progress.multi;

import com.raddle.swing.progress.ProgressContext;

/**
 * 类ProgressCallback.java的实现描述：在进度条里执行
 * 
 * @author Administrator Oct 24, 2007 1:23:28 PM
 */
public interface MultiProgressCallback {

    /**
     * 在进度条里执行
     * 
     * @param context 进度条上下文
     */
    public void doWithMultiProgress(ProgressContext context);
}
