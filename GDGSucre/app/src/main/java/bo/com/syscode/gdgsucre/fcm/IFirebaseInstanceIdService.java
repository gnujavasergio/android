package bo.com.syscode.gdgsucre.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by gnujavasergio on 22-10-16.
 */

public class IFirebaseInstanceIdService extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String fcmToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN: ", "FCM Token: " + fcmToken);

        sendTokenToServer(fcmToken);
    }

    private void sendTokenToServer(String fcmToken) {
        // Acciones para enviar token a tu app server
    }
}
