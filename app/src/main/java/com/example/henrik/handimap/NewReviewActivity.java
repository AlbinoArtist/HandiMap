package com.example.henrik.handimap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import me.drakeet.materialdialog.MaterialDialog;

public class NewReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindActionBarButtons();
        setHintLiseners();
        initateSpinners();
    }

    private void setHintLiseners() {
        LinearLayout elevator = (LinearLayout) findViewById(R.id.hint_elevator);
        final MaterialDialog mMaterialDialog = new MaterialDialog(this);
        elevator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

                mMaterialDialog.setTitle("Anpassad hiss");
                mMaterialDialog.setMessage("Om platsen hade flera våningar, fanns det en anpassad hiss i byggnaden.");
                mMaterialDialog.show();
            }
        });
        LinearLayout entry = (LinearLayout) findViewById(R.id.hint_entry);
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

                mMaterialDialog.setTitle("Typ av ingång");
                mMaterialDialog.setMessage("Om du var tvungen att använda en specialingång, ex. gå runt på baksidan av byggnaden för att komma in.");
                mMaterialDialog.show();
            }
        });
        LinearLayout extratime = (LinearLayout) findViewById(R.id.hint_extra_time);
        extratime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

                mMaterialDialog.setTitle("Extra tid");
                mMaterialDialog.setMessage("Uppskatta hur mycket extra tid det tog för dig att ta dig in i byggnaden. Jämför med en gående person som använde huvudingången.");
                mMaterialDialog.show();
            }
        });
        LinearLayout toilet = (LinearLayout) findViewById(R.id.hint_toilet);
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

                mMaterialDialog.setTitle("Typ av ingång");
                mMaterialDialog.setMessage("Om det fanns lättillgängliga anpassade toaletter. Välj \"Ej lätt tillgänglig\" om du tex. var tvungen att ta dig till en speciell våning för anpassade toaletter.");
                mMaterialDialog.show();
            }
        });
        LinearLayout rating = (LinearLayout) findViewById(R.id.hint_helhet);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

                mMaterialDialog.setTitle("Helhetsintryck");
                mMaterialDialog.setMessage("Bedöm helhetsupplevelsen, hur nöjd du var med ditt besök och hur tillgänglig platsen var.");
                mMaterialDialog.show();
            }
        });
    }

    private void bindActionBarButtons() {
        ImageView closeButton = (ImageView) findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        TextView saveButton = (TextView) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initateSpinners(){
        LinearLayout reviewParameters = (LinearLayout)findViewById(R.id.review_parameters);
        //Entry options
        ArrayAdapter entrySpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.type_entry_options));
        Spinner entrySpinner = new Spinner(this);

        entrySpinner.setAdapter(entrySpinnerArrayAdapter);

        //Extra time needed
        ArrayAdapter extratimeSpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.extra_time_options));
        Spinner extratimeSpinner = new Spinner(this);


        extratimeSpinner.setAdapter(extratimeSpinnerArrayAdapter);
        //HISS
        ArrayAdapter evevatorSpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.elevator_options));
        Spinner evelatorSpinner = new Spinner(this);
        evelatorSpinner.setAdapter(evevatorSpinnerArrayAdapter);
        //ANPASSADE TOALETTER
        ArrayAdapter toiletSpinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.toilet_options));
        Spinner toiletSpinner = new Spinner(this);
        toiletSpinner.setAdapter(toiletSpinnerArrayAdapter);

        //Add the spinners
        reviewParameters.addView(entrySpinner, 9);
        reviewParameters.addView(extratimeSpinner,11);
        reviewParameters.addView(evelatorSpinner,13);
        reviewParameters.addView(toiletSpinner,15);




    }

}
