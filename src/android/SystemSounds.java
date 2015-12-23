import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;

import android.media.RingtoneManager;
import android.database.Cursor;
import android.content.Context;



public class SystemSounds extends CordovaPlugin {

    public static final String GET_SYSTEM_NOTIFICATION_SOUNDS = "getSystemNotificationSounds";


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d("SS", "executing");
        if (GET_SYSTEM_NOTIFICATION_SOUNDS.equals(action)) {

            Map<String, String> soundList = new HashMap<>();

            RingtoneManager manager = new RingtoneManager(cordova.getActivity().getApplicationContext());
            manager.setType(RingtoneManager.TYPE_NOTIFICATION);
            Cursor cursor = manager.getCursor();

            while (cursor.moveToNext()) {
                String notificationTitle = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
                String notificationUri = cursor.getString(RingtoneManager.URI_COLUMN_INDEX);
                Log.d("SS", notificationTitle);
                soundList.put(notificationTitle, notificationUri);
            }

            String json = new JSONObject(soundList).toString();
            Log.d("SS", json);
            callbackContext.success(json);
            return true;
        }
        callbackContext.error("Invalid action");
        return false;

    }
}
