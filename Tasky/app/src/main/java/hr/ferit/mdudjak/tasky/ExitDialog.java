package hr.ferit.mdudjak.tasky;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import static hr.ferit.mdudjak.tasky.NewTask.KEY_CALLING_ACTIVITY;

/**
 * Created by Mario on 11.4.2017..
 */

public class ExitDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Delete?")
                .setMessage("Press Yes to delete task.")
                .setPositiveButton(
                        "Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                .setNegativeButton(
                        "No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(),"Canceled", Toast.LENGTH_SHORT).show();

                            }
                        }
                );
        return dialogBuilder.create();
    }
}
