package com.example.chandsigupta.learnorgo;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

class DatabaseInitializer {
    static String name;
    static String email;
    static String password;
    static String confirmpassword;
    static String mobile;
    private static final String TAG = DatabaseInitializer.class.getName();

    public void populateAsync(@NonNull final AppDatabase db, String name, String email, String password,String confirmpassword ,String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.mobile = mobile;
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        // populateWithTestData(db);
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db, String name, String email, String password,String confirmpassword,String mobile) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmpassword(confirmpassword);
        user.setMobile(mobile);

        addUser(db, user);
        List<User> userList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
    }

    public static boolean getTestData(AppDatabase appDatabase, String name, String email) {
        User userList = appDatabase.userDao().findByName(name, email);
        if (userList.getPassword() != null) {
            Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.getPassword());
            return true;
        } else {
            return false;
        }
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb, name, email, password,confirmpassword,mobile);
            return null;
        }


    }
}