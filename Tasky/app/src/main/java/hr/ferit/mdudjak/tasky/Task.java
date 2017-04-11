package hr.ferit.mdudjak.tasky;

/**
 * Created by Mario on 11.4.2017..
 */

public class Task {
    private String mTitle,mText;
    private int mPriority;
    public  Task(String title, String text, int priority){
        mTitle=title;
        mText=text;
        mPriority=priority;
    }
    public String getTitle() { return mTitle;}
    public String getText() { return mText;}
    public int getPriority() { return mPriority;}
}
