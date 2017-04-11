package hr.ferit.mdudjak.tasky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bNewTask, bNewCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        this.bNewTask = (Button) findViewById(R.id.bNewTask);
        this.bNewCategory = (Button) findViewById(R.id.bNewCategory);
        bNewTask.setOnClickListener(this);
        bNewCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case(R.id.bNewTask):
                intent = new Intent(this, NewTask.class);
                this.startActivity(intent);
                break;

            case(R.id.bNewCategory):
                intent = new Intent(this, NewCategory.class);
                this.startActivity(intent);
                break;

        }
    }
}
