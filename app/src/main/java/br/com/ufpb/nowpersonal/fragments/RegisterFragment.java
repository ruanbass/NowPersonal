package br.com.ufpb.nowpersonal.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import br.com.ufpb.nowpersonal.R;
import br.com.ufpb.nowpersonal.util.CircleTransform;

public class RegisterFragment extends Fragment {

    private ImageView mImageProfile;
    private TextView mName;
    private TextView mLastName;
    private TextView mDateOfBirth;
    private TextView mPhone;
    private TextView mEmail;
    private TextView mPassword;

    private Switch isPersonal;

    private View mLayoutPersonal;
    private TextView mCity;
    private TextView mOfficeHome;
    private TextView mOurStart;
    private TextView mOurEnd;
    private TextView mPrice;
    private TextView mCref;

    private View mRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        mImageProfile = (ImageView) view.findViewById(R.id.image_user);
        Picasso.with(getActivity()).load(R.drawable.ic_people).transform(new CircleTransform()).into(mImageProfile);

        isPersonal = (Switch) view.findViewById(R.id.you_personal);
        isPersonal.setOnCheckedChangeListener(new CheckedChangeListener());
        mLayoutPersonal = view.findViewById(R.id.field_personal);

        return view;


    }

    private Typeface getTypeface(){
        return Typeface.createFromAsset(getActivity().getAssets(), "fonts/roboto_regular.ttf");
    }

    private class CheckedChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isPersonal) {
            if(isPersonal){
                YoYo.with(Techniques.FadeInDown).duration(1000).playOn(mLayoutPersonal);
                mLayoutPersonal.setVisibility(View.VISIBLE);
            }else{
                YoYo.with(Techniques.FadeOutDown).duration(1000).playOn(mLayoutPersonal);
                mLayoutPersonal.setVisibility(View.GONE);
            }
        }
    }

}