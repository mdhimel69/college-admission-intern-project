package in.org.cocsit.collegeadmissionmanagementsystem;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.airbnb.lottie.LottieAnimationView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class Courses extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        //add hardware acceleration enable
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        //add notch displays cutout mode to short size
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        ImageView coursesScreenBackButton = findViewById(R.id.courseScreenBackImgBtn);
        coursesScreenBackButton.setOnClickListener(v -> onBackPressed());

        // following are the courses names cardViews
        CardView courseComputer = findViewById(R.id.courseComputer);
        CardView courseCivil = findViewById(R.id.courseCivil);
        CardView courseMechanical = findViewById(R.id.courseMechanical);
        CardView courseEEE = findViewById(R.id.courseEEE);
        CardView courseElectrical = findViewById(R.id.courseElectrical);
        CardView courseArchitecture = findViewById(R.id.courseArchitecture);
        CardView courseTextile = findViewById(R.id.courseTextile);
        CardView courseAutomobile = findViewById(R.id.courseAutomobile);
        CardView courseMarine = findViewById(R.id.courseMarine);
        CardView courseChemical = findViewById(R.id.courseChemical);


        // following are listeners to the above cardViews
        courseComputer.setOnClickListener(this);
        courseCivil.setOnClickListener(this);
        courseMechanical.setOnClickListener(this);
        courseEEE.setOnClickListener(this);
        courseElectrical.setOnClickListener(this);
        courseArchitecture.setOnClickListener(this);
        courseTextile.setOnClickListener(this);
        courseAutomobile.setOnClickListener(this);
        courseMarine.setOnClickListener(this);
        courseChemical.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.courseComputer:
                showCoursePopup(v,"Computer Science and engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                                 ,"cbcs_bsc_cs_fy.pdf");
                break;
            case R.id.courseCivil:
                showCoursePopup(v,"Civil engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                                 ,"cbcs_bsc_se_fy.pdf");
                break;
            case R.id.courseMechanical:
                showCoursePopup(v,"Mechanical engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                                 ,"cbcs_bsc_nt_fy.pdf");
                break;
            case R.id.courseEEE:
                showCoursePopup(v,"Electrical and Electronics Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_msc_cs_fy.pdf");
                break;
            case R.id.courseElectrical:
                showCoursePopup(v,"Electrical Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_msc_se_fy.pdf");
                break;
            case R.id.courseArchitecture:
                showCoursePopup(v,"Architecture Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_msc_sa_fy.pdf");
                break;
            case R.id.courseTextile:
                showCoursePopup(v,"Textile Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_msc_cm_fy.pdf");
                break;
            case R.id.courseAutomobile:
                showCoursePopup(v,"Automobile Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_bca_fy.pdf");
                break;
            case R.id.courseMarine:
                showCoursePopup(v,"Marine Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_bsc_bt_fy.pdf");
                break;
            case R.id.courseChemical:
                showCoursePopup(v,"Chemical Engineering","Eligibility : SSC\nDuration : 4 Years\nSemesters : Total 8\nFees/Year : 20,500.0 Tk."
                        ,"cbcs_msc_bt_fy.pdf");
                break;
        }


    }


    public void showCoursePopup(View view, String myCourseName, String myCourseDetails, String myPDF) {

        final DialogPlus dialog = DialogPlus.newDialog(this)
                .setGravity(Gravity.CENTER)
                .setMargin(50,0,50,0)
                .setContentHolder(new ViewHolder(R.layout.course_popup))
                .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                .create();

        View holderView = dialog.getHolderView();

        LottieAnimationView animationView = holderView.findViewById(R.id.RegWinCautionAnim);

        Button openPDFButton1 = holderView.findViewById(R.id.coursePopupPDFBtn1);

        Button registrationButton = holderView.findViewById(R.id.coursePopupRegBtn);
        Button cancelButton = holderView.findViewById(R.id.coursePopupCancelBtn);

        TextView textViewTitle = holderView.findViewById(R.id.coursePopupTextViewTitle);
        TextView textViewSubTitle = holderView.findViewById(R.id.coursePopupTextViewSubTitle);

        textViewTitle.setText(myCourseName);
        textViewSubTitle.setText(myCourseDetails);

        openPDFButton1.setOnClickListener(v -> {
            Intent i = new Intent(this, PDFviewer.class);
            i.putExtra("myPDFname",myPDF);
            this.startActivity(i);
        });


        if(myPDF.contentEquals("0")) {
            openPDFButton1.setVisibility(View.INVISIBLE);
            openPDFButton1.setClickable(false);
            openPDFButton1.setEnabled(false);
            animationView.setVisibility(View.VISIBLE);
            animationView.playAnimation();
        }

        registrationButton.setOnClickListener(v -> { Intent i = new Intent(this,Registration.class); startActivity(i); } );

        cancelButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }


    // Enables regular immersive mode or fullscreen mode
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }
}