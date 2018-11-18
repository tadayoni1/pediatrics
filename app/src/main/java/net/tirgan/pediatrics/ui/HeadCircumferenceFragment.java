package net.tirgan.pediatrics.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import net.tirgan.pediatrics.R;
import net.tirgan.pediatrics.data.HeadCircumferenceData;
import net.tirgan.pediatrics.data.SharedData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HeadCircumferenceFragment extends Fragment {


    private Context mContext;
    private TextView mResultTextView;
    private NumberPicker mGenderPicker;
    private NumberPicker mAgePicker;
    private NumberPicker mAtBirthPicker;

    private int mGender;
    private int mAge;
    private int mAtBirth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_head_circumference, container, false);

        mResultTextView = rootView.findViewById(R.id.head_circumference_tv);

        mGenderPicker = rootView.findViewById(R.id.gender);
        mAgePicker = rootView.findViewById(R.id.age);
        mAtBirthPicker = rootView.findViewById(R.id.at_birth);

        mGenderPicker.setMinValue(0);
        mGenderPicker.setMaxValue(1);
        mAgePicker.setMinValue(1);
        mAgePicker.setMaxValue(30);
        mAtBirthPicker.setMinValue(0);
        mAtBirthPicker.setMaxValue(10);

        mGenderPicker.setValue(1);
        mAgePicker.setValue(1);
        mAtBirthPicker.setValue(0);

        mGender = 1;
        mAge = 1;
        mAtBirth = 0;
        setResult();

        NumberPicker.Formatter genderFormatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value == 0 ? mContext.getString(R.string.boy) : mContext.getString(R.string.girl);
            }
        };

        NumberPicker.Formatter ageFormatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return SharedData.AGE[value];
            }
        };

        NumberPicker.Formatter atBirthFormatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.valueOf(((value + 1) / 2.0) + 31.5);
            }
        };

        mGenderPicker.setFormatter(genderFormatter);
        mAgePicker.setFormatter(ageFormatter);
        mAtBirthPicker.setFormatter(atBirthFormatter);

        mGenderPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mGender = newVal;
                setResult();
            }
        });

        mAgePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mAge = newVal;
                setResult();
            }
        });

        mAtBirthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mAtBirth = newVal;
                setResult();
            }
        });



        // workaround to render missing initial value in numberpicker
        // https://stackoverflow.com/questions/17708325/android-numberpicker-with-formatter-doesnt-format-on-first-rendering
        try {
            Method method = mGenderPicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(mGenderPicker, true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method method = mAgePicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(mAgePicker, true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method method = mAtBirthPicker.getClass().getDeclaredMethod("changeValueByOne", boolean.class);
            method.setAccessible(true);
            method.invoke(mAtBirthPicker, true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void setResult() {
        String result = mContext.getString(R.string.format_head_circumference, String.valueOf(HeadCircumferenceData.getHeadCircumference(mGender, mAge, mAtBirth)));
        mResultTextView.setText(result);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mContext = context;
        } catch (Exception aE) {

        }

    }
}
