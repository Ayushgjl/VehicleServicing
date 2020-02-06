package com.ayushgjl.vehicleservicing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayushgjl.vehicleservicing.API.UserAPI;
import com.ayushgjl.vehicleservicing.Model.UpdateProfile;
import com.ayushgjl.vehicleservicing.Model.User;
import com.ayushgjl.vehicleservicing.URL.url;
import com.ayushgjl.vehicleservicing.serverresponse.ImageResponse;
import com.ayushgjl.vehicleservicing.strictmode.StrictModeClass;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class UpdateActivity extends AppCompatActivity {
   private EditText tvFirst,tvLast,tvPhone,tvUser;
    private Button btnUpdate;
    private CircleImageView UpdateImage;
    private String imagePath;
    private String imageName = "";
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        tvFirst=findViewById(R.id.tvFirst);
        tvLast=findViewById(R.id.tvLast);
        tvPhone=findViewById(R.id.tvPhone);
        tvUser=findViewById(R.id.tvUser);
        btnUpdate=findViewById(R.id.btnUpdate);
        UpdateImage=findViewById(R.id.UpdateImage);

        user=new User();
        user=(com.ayushgjl.vehicleservicing.Model.User) getIntent().getSerializableExtra("User");

        tvFirst.setText(user.getFirstName());
        tvLast.setText(user.getLastName());
        tvPhone.setText(user.getPhonenumber());
        tvUser.setText(user.getUsername());

        final String imgPath= url.imagePath + user.getImage();
        try{
            URL url = new URL(imgPath);
            UpdateImage.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        }

        catch (IOException e){
            e.printStackTrace();
        }

        UpdateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveImageOnly();
                Update();

            }
        });
    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        UpdateImage.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void saveImageOnly() {
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                file.getName(), requestBody);

        UserAPI usersAPI = url.getInstance().create(UserAPI.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);

        StrictModeClass.StrictMode();
        //Synchronous methid
        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted" + imageName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void Update(){
        String firstName=tvFirst.getText().toString();
        String lastName=tvLast.getText().toString();
        String phonenumber=tvPhone.getText().toString();
        String user=tvUser.getText().toString();

        UpdateProfile updateProfile= new UpdateProfile(firstName,lastName,phonenumber,user,imageName);

        UserAPI userAPI = url.getInstance().create(UserAPI.class);

//        Call<UpdateProfile> updateProfileCall = userAPI.edituser(url.token,updateProfile);
        Call<UpdateProfile> updateProfileCall =userAPI.edituser(url.token,updateProfile);

        updateProfileCall.enqueue(new Callback<UpdateProfile>() {
            @Override
            public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(UpdateActivity.this, "code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(UpdateActivity.this, Main2Activity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<UpdateProfile> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

//        UserAPI userApi= url.getInstance().create(UserAPI.class);
//        Call<UpdateProfile> updateProfileCall=userApi.editUser(url.token,updateProfile);
//
//        updateProfileCall.enqueue(new Callback<UpdateProfile>() {
//            @Override
//            public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
//                if (!response.isSuccessful()){
//                    Toast.makeText(UpdateActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
//                Intent intent= new Intent(UpdateActivity.this, Main2Activity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<UpdateProfile> call, Throwable t) {
//
//                Toast.makeText(UpdateActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
