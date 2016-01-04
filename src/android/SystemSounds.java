import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import android.media.RingtoneManager;
import android.database.Cursor;
import android.content.Context;
import android.net.Uri;



public class SystemSounds extends CordovaPlugin {

    public static final String GET_SYSTEM_NOTIFICATION_SOUNDS = "getSystemNotificationSounds";
    public static final String PLAY_SOUND = "playSound";


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (GET_SYSTEM_NOTIFICATION_SOUNDS.equals(action)) {

            Map<String, String> soundList = new HashMap();

            RingtoneManager manager = new RingtoneManager(cordova.getActivity().getApplicationContext());
            manager.setType(RingtoneManager.TYPE_NOTIFICATION);
            Cursor cursor = manager.getCursor();

            while (cursor.moveToNext()) {
                String notificationTitle = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
                String notificationUri = cursor.getString(RingtoneManager.URI_COLUMN_INDEX);
                String id = cursor.getString(RingtoneManager.ID_COLUMN_INDEX);

                soundList.put(notificationTitle, notificationUri + "/" + id);
            }

            String json = new JSONObject(soundList).toString().replaceAll("\\\\", "");

            callbackContext.success(json);
            return true;

        } else if (PLAY_SOUND.equals(action)) {

            String uriString = args.getString(0);

            RingtoneManager.getRingtone(this, Uri.parse(uriString)).play();

            callbackContext.success();
            return true;
        }

        callbackContext.error("Invalid action");
        return false;

    }
}
