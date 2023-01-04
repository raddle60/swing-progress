package com.raddle.swing.progress.multi;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.raddle.swing.progress.ProgressContext;

/**
 * 类ProgressHandler.java的实现描述：显示进度条
 *
 * @author Administrator Oct 24, 2007 1:06:12 PM
 */
public class MultiProgressHandler {

    public static void doInMultiProgress(final Frame owner, final String title, final int progressCount, final int delayShow, final MultiProgressCallback callback) {
        final boolean[] isFinshed = new boolean[1];
        isFinshed[0] = false;
        final MultiProgressDialogs dialog = new MultiProgressDialogs(owner, progressCount, true);
        dialog.setTitle(title);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (isFinshed[0]) {
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "正在执行中，不能关闭", "关闭进度条", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        Thread t = new Thread() {

            @Override
            public void run() {
                ProgressContext p = new ProgressContext(dialog, dialog.getProgressList());
                try {
                    callback.doWithMultiProgress(p);
                } finally {
                    isFinshed[0] = true;
                }
                dialog.dispose();
            };
        };
        t.start();
        dialog.setLocationRelativeTo(owner);
        if (delayShow > 0) {
            // 延迟显示
            new Thread() {

                @Override
                public void run() {
                    int sleeped = 0;
                    int sleepStep = 50;
                    while (sleeped < delayShow) {
                        try {
                            Thread.sleep(sleepStep);
                            sleeped += sleepStep;
                        } catch (InterruptedException e1) {
                        }
                    }
                    // 在等待的过程中，可能已经执行完成，或调用了dispose
                    if (!isFinshed[0]) {
                        dialog.setVisible(true);
                    }
                }
            }.start();
        } else {
            dialog.setVisible(true);
        }
    }
}
