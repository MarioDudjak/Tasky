package hr.ferit.mdudjak.tasky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewTask extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_INPUT_TITLE = "input title";
    public static final String KEY_INPUT_TEXT = "input text";
    public static final String KEY_INPUT_PRIORITY = "input priority" ;
    public static final String KEY_CALLING_ACTIVITY = "NewTask";
    Button bAddTask;
    EditText etTaskName,etTaskText;
    Spinner spinner;
    ListView lvTaskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        this.setUpUI();
    }

    private void setUpUI() {
        this.bAddTask= (Button) this.findViewById(R.id.bAddTask);
        this.etTaskName = (EditText) this.findViewById(R.id.etTaskTitle);
        this.etTaskText= (EditText) this.findViewById(R.id.etTaskText);
        this.spinner= (Spinner) this.findViewById(R.id.task_spinner);
        this.lvTaskList = (ListView) this.findViewById(R.id.lvTaskList);
        bAddTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String sTaskName = null, sTaskText =null, sTaskPriority;

        if(etTaskName.getText().toString().isEmpty()){
            etTaskName.setError(this.getResources().getString(R.string.titleInputControl));
        }
        else {
            sTaskName= etTaskName.getText().toString();
        }
        if(etTaskText.getText().toString().isEmpty()) {
            etTaskText.setError(this.getResources().getString(R.string.textInputControl));
        }
        else {
            sTaskText=etTaskText.getText().toString();
        }
        if(!(etTaskName.getText().toString().isEmpty()||etTaskText.getText().toString().isEmpty())) {
            sTaskPriority = spinner.getSelectedItem().toString();
            Intent explicitIntent = new Intent(getApplicationContext(), MainActivity.class);
            explicitIntent.putExtra(KEY_CALLING_ACTIVITY, KEY_CALLING_ACTIVITY);
            explicitIntent.putExtra(KEY_INPUT_TITLE, sTaskName);
            explicitIntent.putExtra(KEY_INPUT_TEXT, sTaskText);
            explicitIntent.putExtra(KEY_INPUT_PRIORITY, sTaskPriority);
            this.startActivity(explicitIntent);
        }
    }
}
