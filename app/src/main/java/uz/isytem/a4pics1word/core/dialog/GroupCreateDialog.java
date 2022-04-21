package uz.isytem.a4pics1word.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import uz.isytem.a4pics1word.R;
import uz.isytem.a4pics1word.ui.GameActivity1;

public class GroupCreateDialog extends AlertDialog {
    private final View viewMain;

    private final EditText editText;
    private final Button button;
    private final TextView title;
    private GameActivity1 startGame = new GameActivity1();/*

    private OnDialogSavaClick onDialogSaveClick = null;*/


    public GroupCreateDialog(@NonNull Context context) {
        super(context);


        viewMain = LayoutInflater.from(context).inflate(R.layout.activity_dialog_create, null, false);

        setView(viewMain);

        editText = viewMain.findViewById(R.id.dialog_input);
        button = viewMain.findViewById(R.id.dialog_close);
        title = viewMain.findViewById(R.id.dialog_title);

        setButtonClose();
    }

    public void setButtonClose() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    /*public void setInterfaceObject(OnDialogSavaClick onDialogSaveClick) {
        this.onDialogSaveClick = onDialogSaveClick;
    }*/

    public void setTitleDialog(String titleDialog) {
        title.setText(titleDialog);
    }

    public void setEditTextDialog(String data) {
        editText.setText(data);
    }

}
