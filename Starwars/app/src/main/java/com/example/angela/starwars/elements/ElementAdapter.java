package com.example.angela.starwars.elements;

/**
 * Created by Angela on 16/01/2018.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.angela.starwars.R;
import com.example.angela.starwars.data.models.People;

import java.util.List;

public class ElementAdapter extends ArrayAdapter<People>{

    public interface OnPeopleSelectedListener{
        void handle(final People people);
    }

    private final OnPeopleSelectedListener onPeopleSelectedListener;

    ElementAdapter (@NonNull final Context context, final List<People> people, final OnPeopleSelectedListener listener) {
        super(context, R.layout.activity_elements, people);
        onPeopleSelectedListener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View holder = convertView;
        if (convertView == null) {
            final LayoutInflater vi = LayoutInflater.from(getContext());
            holder = vi.inflate(R.layout.element_people_name_list_item, null);
        }

        final People people = getItem(position);
        if (people == null) {
            return holder;
        }

        // display the name
        final TextView elementName = holder.findViewById(R.id.elementName);
        if (elementName != null) {
            elementName.setText(people.getName());
        }

        // When this device item is clicked, trigger the listener
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (onPeopleSelectedListener != null) {
                    onPeopleSelectedListener.handle(people);
                }
            }
        });

        return holder;
    }
}

