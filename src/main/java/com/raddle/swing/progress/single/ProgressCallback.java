package com.raddle.swing.progress.single;

import javax.swing.JDialog;

import com.raddle.swing.progress.Progress;

/**
 * 类ProgressCallback.java的实现描述：在进度条里执行
 * 
 * @author Administrator Oct 24, 2007 1:23:28 PM
 */
public interface ProgressCallback {

    public void doWithProgress(JDialog dialog, Progress progress);
}
