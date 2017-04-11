package hr.ferit.mdudjak.tasky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

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
       /* Intent intent = new Intent(this, NewTask.class);
        this.startActivity(intent);*/
        Task task = new Task("My book","Me",1);
        TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
        TaskAdapter adapter = (TaskAdapter) lvTaskList.getAdapter();
        adapter.insert(task);
        }
}
