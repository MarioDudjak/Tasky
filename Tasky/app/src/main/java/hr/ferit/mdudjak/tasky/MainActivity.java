package hr.ferit.mdudjak.tasky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bNewTask;
    ListView lvTaskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
        Intent startingIntent = this.getIntent();
        if(startingIntent.hasExtra(NewTask.KEY_CALLING_ACTIVITY)) inputProcess();
    }

    private void setUpUI() {
        this.bNewTask = (Button) this.findViewById(R.id.bNewTask);
        bNewTask.setOnClickListener(this);
        this.lvTaskList = (ListView) this.findViewById(R.id.lvTaskList);
        ArrayList<Task> tasks = this.loadTasks();
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
       this.lvTaskList.setAdapter(taskAdapter);

    }

    private ArrayList<Task> loadTasks() {
        return TaskDBHelper.getInstance(this).getAllTasks();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NewTask.class);
        this.startActivity(intent);
    }
    public void inputProcess() {
        String sTaskName = null, sTaskText = null, sTaskPriority = null;
        int iTaskPriority = 0;
        Intent startingIntent = this.getIntent();
        if (startingIntent.hasExtra(NewTask.KEY_INPUT_TITLE)) {
            sTaskName = startingIntent.getStringExtra(NewTask.KEY_INPUT_TITLE);
            Toast.makeText(getApplicationContext(), "hehe", Toast.LENGTH_SHORT);
        }
        if (startingIntent.hasExtra(NewTask.KEY_INPUT_TEXT)) {
            sTaskText = startingIntent.getStringExtra(NewTask.KEY_INPUT_TEXT);
            Toast.makeText(getApplicationContext(), "hihi", Toast.LENGTH_LONG);
        }
        if (startingIntent.hasExtra(NewTask.KEY_INPUT_PRIORITY)) {
            sTaskPriority = startingIntent.getStringExtra(NewTask.KEY_INPUT_PRIORITY);
            Toast.makeText(getApplicationContext(), "hoho", Toast.LENGTH_LONG);
        }
        if (sTaskPriority.equals("low")) iTaskPriority = 3;
        if (sTaskPriority.equals("normal")) iTaskPriority = 2;
        if (sTaskPriority.equals("high")) iTaskPriority = 1;
        Task task = new Task(sTaskName, sTaskText, iTaskPriority);
        TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
        TaskAdapter adapter = (TaskAdapter) lvTaskList.getAdapter();
        adapter.insert(task);
    }





}
