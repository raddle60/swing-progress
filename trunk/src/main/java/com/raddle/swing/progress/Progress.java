package com.raddle.swing.progress;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * 类Progress.java的实现描述：进度条
 * 
 * @author xurong 2009-7-4 上午09:34:56
 */
public class Progress {

    private JLabel       label;
    private JProgressBar progressBar;

    public Progress(JLabel label, JProgressBar progressBar){
        this.label = label;
        this.progressBar = progressBar;
    }

    public String getString() {
        return progressBar.getString();
    }

    public void setString(String string) {
        progressBar.setString(string);
    }

    public void setValue(int n) {
        progressBar.setValue(n);
    }

    public int getValue() {
        return progressBar.getValue();
    }

    public int getMinimum() {
        return progressBar.getMinimum();
    }

    public void setMinimum(int n) {
        progressBar.setMinimum(n);
    }

    public int getMaximum() {
        return progressBar.getMaximum();
    }

    public void setMaximum(int n) {
        progressBar.setMaximum(n);
    }

    public String getToolTipText() {
        return progressBar.getToolTipText();
    }

    public void setToolTipText(String text) {
        progressBar.setToolTipText(text);
    }

    public void setDescription(String description) {
        label.setText(description);
    }

    public String getDescription() {
        return label.getText();
    }

    public JLabel getLabel() {
        return label;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
