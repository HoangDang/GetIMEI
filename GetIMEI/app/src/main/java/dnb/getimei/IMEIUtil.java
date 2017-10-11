package dnb.getimei;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by ngodung on 10/11/17.
 */

public class IMEIUtil {

    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId().trim();
        if (deviceId == null) {
            String androidId = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            deviceId = android.os.Build.SERIAL + "#" + androidId;
        }
        return deviceId.trim();
    }
}
