package hr.ferit.mdudjak.tasky;

/**
 * Created by Mario on 11.4.2017..
 */

public class Task {
    private String mTitle,mText, mPictureUrl;
    public  Task(String title, String text, String URL){
        mTitle=title;
        mText=text;
        mPictureUrl=URL;
    }
    public String getTitle() { return mTitle;}
    public String getText() { return mText;}
    public String getPictureUrl() { return mPictureUrl;}
}
