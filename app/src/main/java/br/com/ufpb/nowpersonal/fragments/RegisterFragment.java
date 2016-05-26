package br.com.ufpb.nowpersonal.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;

import br.com.ufpb.nowpersonal.NowPersonalApplication;
import br.com.ufpb.nowpersonal.R;
import br.com.ufpb.nowpersonal.model.Aluno;
import br.com.ufpb.nowpersonal.model.Personal;
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

    private Aluno aluno;
    private Personal personal;
    private View mRegister;

    private NowPersonalApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (NowPersonalApplication) getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        mImageProfile = (ImageView) view.findViewById(R.id.image_user);
        Picasso.with(getActivity()).load(R.drawable.ic_people).transform(new CircleTransform()).into(mImageProfile);
        mName = (EditText) view.findViewById(R.id.register_name);
        mName.setTypeface(getTypeface());

        mLastName = (EditText) view.findViewById(R.id.register_lastName);
        mLastName.setTypeface(getTypeface());

        mDateOfBirth = (EditText) view.findViewById(R.id.register_calendar);
        mDateOfBirth.setTypeface(getTypeface());

        mPhone = (EditText) view.findViewById(R.id.register_phone);
        mPhone.setTypeface(getTypeface());

        mEmail = (EditText) view.findViewById(R.id.register_mail);
        mEmail.setTypeface(getTypeface());

        mPassword = (EditText) view.findViewById(R.id.register_password);
        mPassword.setTypeface(getTypeface());

        mCity = (EditText) view.findViewById(R.id.register_city);
        mCity.setTypeface(getTypeface());

        mOfficeHome = (EditText) view.findViewById(R.id.register_attendance);
        mOfficeHome.setTypeface(getTypeface());

        mOurStart = (EditText) view.findViewById(R.id.register_office_our1);
        mOurStart.setTypeface(getTypeface());

        mOurEnd = (EditText) view.findViewById(R.id.register_office_our2);
        mOurEnd.setTypeface(getTypeface());

        mPrice = (EditText) view.findViewById(R.id.register_price);
        mPrice.setTypeface(getTypeface());

        mCref = (EditText) view.findViewById(R.id.register_cref);
        mCref.setTypeface(getTypeface());

        isPersonal = (Switch) view.findViewById(R.id.you_personal);
        isPersonal.setOnCheckedChangeListener(new CheckedChangeListener());

        mLayoutPersonal = view.findViewById(R.id.field_personal);

        mRegister = view.findViewById(R.id.btn_register);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                // Captura os valores
                String nome = mName.getText().toString();
                String sobrenome = mLastName.getText().toString();
                String data = mDateOfBirth.getText().toString();
                String telefone = mPhone.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();


                boolean cancel = false;

                if (!TextUtils.isEmpty(nome)) {
                    cancel = true;
                } else if (!TextUtils.isEmpty(sobrenome)) {
                    cancel = true;
                } else if (!TextUtils.isEmpty(data)) {
                    cancel = true;
                } else if (!TextUtils.isEmpty(telefone)) {
                    cancel = true;
                } else if (!TextUtils.isEmpty(email)) {
                    cancel = true;
                } else if (!TextUtils.isEmpty(password)) {
                    cancel = true;
                }

                if (cancel) {
                    if (aluno == null) {
                        aluno = new Aluno();
                    }

                    aluno.setNome(nome);
                    aluno.setSobrenome(sobrenome);
                    aluno.setTelefone(telefone);
                    aluno.setDataNascimento(data);
                    aluno.setEmail(email);
                    aluno.setSenha(password);
                    // Adiciona o contato no banco
                    try {
                        application.addAluno(aluno);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }


        });
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
