package com.junipersys.fragmentspractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class IngredientsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.ingredientsLayout);

        String[] ingredients = Recipes.ingredients[index].split("`");

        setUpCheckBoxes(ingredients, linearLayout);

        return view;
    }

    private void setUpCheckBoxes(String[] ingredients, ViewGroup container){
        for(String ingredient : ingredients){
            CheckBox checkbox = new CheckBox(getActivity());
            checkbox.setPadding(8, 16, 8, 16);
            checkbox.setTextSize(20f);
            checkbox.setText(ingredient);
            container.addView(checkbox);
        }
    }
}
