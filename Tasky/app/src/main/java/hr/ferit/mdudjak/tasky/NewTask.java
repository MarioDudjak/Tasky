package hr.ferit.mdudjak.tasky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewTask extends AppCompatActivity implements View.OnClickListener {
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
        /*String sTaskName, sTaskText, sTaskPriority;
        sTaskName= etTaskName.getText().toString();
        sTaskText=etTaskText.getText().toString();
        sTaskPriority=spinner.getSelectedItem().toString();
        Task task = new Task(sTaskName,sTaskText,sTaskPriority);
        TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
        TaskAdapter adapter = (TaskAdapter) lvTaskList.getAdapter();
        adapter.insert(task);*/


    }
}
