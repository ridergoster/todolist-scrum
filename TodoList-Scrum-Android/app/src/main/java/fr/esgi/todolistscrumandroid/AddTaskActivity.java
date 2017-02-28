package fr.esgi.todolistscrumandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ozone on 28/02/2017.
 */

public class AddTaskActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        final EditText etTitle = (EditText) findViewById(R.id.et_tasktitle);
        final EditText etDesc = (EditText) findViewById(R.id.et_taskdesc);
        Button btAdd = (Button) findViewById(R.id.bt_addtask);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String desc = etDesc.getText().toString();
                if (title.length() != 0 && desc.length() != 0) {
                    Task task = new Task(title, desc);
                    //todo here add task to db
                } else
                    Toast.makeText(AddTaskActivity.this, getString(R.string.fill_all_fields), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
