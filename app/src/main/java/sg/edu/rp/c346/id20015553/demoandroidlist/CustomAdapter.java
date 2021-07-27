package sg.edu.rp.c346.id20015553.demoandroidlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import sg.edu.rp.c346.id20015553.demotodolist.R;
import sg.edu.rp.c346.id20015553.demotodolist.ToDoItem;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> actionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        actionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView textAction = rowView.findViewById(R.id.textViewAction);
        TextView textDate = rowView.findViewById(R.id.textViewDate);

        ToDoItem id = actionList.get(position);

        textAction.setText(id.getTitle());
        textDate.setText(id.toString() + " (" + id.getDay(id.getDate().get(Calendar.DAY_OF_MONTH)) + ")");

        return rowView;
    }
}
