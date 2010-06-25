package com.raddle.swing.progress;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

/**
 * 类ProgressContext.java的实现描述：进度条上下文
 * 
 * @author xurong 2009-7-4 上午09:53:03
 */
public class ProgressContext {

    private JDialog        dialog;
    private List<Progress> progressList = new ArrayList<Progress>();

    public ProgressContext(JDialog dialog, List<Progress> progressList){
        this.dialog = dialog;
        this.progressList = progressList;
    }

    public Progress getProgress(int i) {
        return progressList.get(i);
    }

    public int getProgressCount() {
        return progressList.size();
    }

    public JDialog getDialog() {
        return dialog;
    }
}
