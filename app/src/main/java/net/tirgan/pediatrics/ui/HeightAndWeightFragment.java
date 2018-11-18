package net.tirgan.pediatrics.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import net.tirgan.pediatrics.R;
import net.tirgan.pediatrics.data.SharedData;
import net.tirgan.pediatrics.data.WeightAndHeightData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HeightAndWeightFragment extends Fragment {

    private Context mContext;
    private TextView mResultTextView;
    private NumberPicker mGenderPicker;
    private NumberPicker mAgePicker;
    private TextInputEditText mHeightTextInputEditText;
    private TextInputEditText mWeightTextInputEditText;

    private int mGender;
    private int mAge;

    private double mCustomHeight;
    private double mCustomWeight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_height_and_weight, container, false);

        mResultTextView = rootView.findViewById(R.id.wnh_tv);

        mHeightTextInputEditText = rootView.findViewById(R.id.height_at_birth_et);
        mWeightTextInputEditText = rootView.findViewById(R.id.weight_at_birth_et);

        mGenderPicker = rootView.findViewById(R.id.gender);
        mAgePicker = rootView.findViewById(R.id.age);

        mGenderPicker.setMinValue(0);
        mGenderPicker.setMaxValue(1);
        mAgePicker.setMinValue(0);
        mAgePicker.setMaxValue(60);

        mGenderPicker.setValue(1);
        mAgePicker.setValue(1);

        mGender = 1;
        mAge = 1;
        setResult();

        resetCustomHeightAndWeight();

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


        mGenderPicker.setFormatter(genderFormatter);
        mAgePicker.setFormatter(ageFormatter);

        mGenderPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mGender = newVal;
                resetCustomHeightAndWeight();
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

        mHeightTextInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateCustomHeightAndWeight();
                setResult();
            }
        });

        mWeightTextInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateCustomHeightAndWeight();
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

        return rootView;
    }

    private void setResult() {
        String result = mContext.getString(R.string.format_height_and_weight, String.valueOf(WeightAndHeightData.getHeight(mGender, mAge, mCustomHeight)), String.valueOf(WeightAndHeightData.getWeight(mGender, mAge, mCustomWeight)));
        mResultTextView.setText(result);
    }

    private void resetCustomHeightAndWeight() {
        mCustomHeight = WeightAndHeightData.getDefaultHeight(mGender);
        mCustomWeight = WeightAndHeightData.getDefaultWeight(mGender);

        mHeightTextInputEditText.setText(String.valueOf(mCustomHeight));
        mWeightTextInputEditText.setText(String.valueOf(mCustomWeight));
    }

    private void updateCustomHeightAndWeight() {
        if (!mHeightTextInputEditText.getText().toString().isEmpty()) {
            mCustomHeight = Double.parseDouble(mHeightTextInputEditText.getText().toString());
        }
        if (!mWeightTextInputEditText.getText().toString().isEmpty()) {
            mCustomWeight = Double.parseDouble(mWeightTextInputEditText.getText().toString());
        }
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
