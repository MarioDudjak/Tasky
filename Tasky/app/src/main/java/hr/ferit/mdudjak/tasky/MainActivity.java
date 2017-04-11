package hr.ferit.mdudjak.tasky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bNewTask;
    ListView lvTaskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
        Intent startingIntent = this.getIntent();
        if (startingIntent.hasExtra(NewTask.KEY_CALLING_ACTIVITY)) inputProcess();
    }

    private void setUpUI() {
        this.bNewTask = (Button) this.findViewById(R.id.bNewTask);
        bNewTask.setOnClickListener(this);
        this.lvTaskList = (ListView) this.findViewById(R.id.lvTaskList);
        ArrayList<Task> tasks = this.loadTasks();
        final TaskAdapter taskAdapter = new TaskAdapter(tasks);
        this.lvTaskList.setAdapter(taskAdapter);

        this.lvTaskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    dialogBuilder.setMessage("Do you want to delete task?");
                    //dialogBuilder.setCancelable(true);

                    dialogBuilder.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    taskAdapter.deleteAt(position);
                                    dialog.cancel();
                                }
                            });

                    dialogBuilder.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();
                    return true;
                }
            });
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
        }
        if (startingIntent.hasExtra(NewTask.KEY_INPUT_TEXT)) {
            sTaskText = startingIntent.getStringExtra(NewTask.KEY_INPUT_TEXT);
        }
        if (startingIntent.hasExtra(NewTask.KEY_INPUT_PRIORITY)) {
            sTaskPriority = startingIntent.getStringExtra(NewTask.KEY_INPUT_PRIORITY);
        }
            if (sTaskPriority.equals("Low")) iTaskPriority = R.drawable.green;
            if (sTaskPriority.equals("Medium")) iTaskPriority = R.drawable.yellow;
            if (sTaskPriority.equals("High")) iTaskPriority = R.drawable.red;
            Task task = new Task(sTaskName, sTaskText, iTaskPriority);
            TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
            TaskAdapter adapter = (TaskAdapter) lvTaskList.getAdapter();
            adapter.insert(task);
        }


}

