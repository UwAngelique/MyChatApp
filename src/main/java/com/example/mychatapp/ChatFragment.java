package com.example.mychatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    private FirebaseFirestore firebaseFirestore;
    LinearLayoutManager linearLayoutManager;
    private FirebaseAuth firebaseAuth;
    ImageView getcontact;
    ListView usersList;
    TextView noUsersText;
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;
    ProgressDialog pd;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview =inflater.inflate(R.layout.fragment_chat, container, false);
        usersList = (ListView)rootview.findViewById(R.id.usersList);
        noUsersText = (TextView)rootview.findViewById(R.id.noUsersText);
        ImageButton button = (ImageButton) rootview.findViewById(R.id.getcontact);
       // pd = new ProgressDialog(UserDetails.this);
//        pd.setMessage("Loading...");
//        pd.show();

        button.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Contact.class);
                startActivity(intent);
            }
        });
        return rootview;
//       String url = "/mychatapp-18c30/firestore/data/~2Fusers~2FgkrSlwDgqbSBf3KPwqiUWuwWOoa2";

       // StringRequest request;

   // RequestQueue rQueue = Volley.newRequestQueue(getActivity(),ChatFragment.this);
   ////   rQueue.add(request);

//        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                UserDetails.chatWith = al.get(position);
//                Intent intent = new Intent(getActivity(), Chat.class);
//                startActivity(intent);
//            }
//        });
//    }

//    public void doOnSuccess(String s){
//        try {
//            JSONObject obj = new JSONObject(s);
//
//            Iterator i = obj.keys();
//            String key = "";
//
//            while(i.hasNext()){
//                key = i.next().toString();
//
//                if(!key.equals(UserDetails.username)) {
//                    al.add(key);
//                }
//
//                totalUsers++;
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        if(totalUsers <=1){
//            noUsersText.setVisibility(View.VISIBLE);
//            usersList.setVisibility(View.GONE);
//        }
//        else{
////            noUsersText.setVisibility(View.GONE);
////            usersList.setVisibility(View.VISIBLE);
////            usersList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.activity_contact));
////        }
//
//        pd.dismiss();
//    }
   }
}