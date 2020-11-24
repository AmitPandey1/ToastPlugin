package com.appice.cordova;

import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class AppICEPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        try{
            // Create the toast
            Toast toast = Toast.makeText(cordova.getActivity(), message, Toast.LENGTH_LONG);
            // Display toast
            toast.show();
            callbackContext.success(message);
        }catch(Exception e){
            callbackContext.error("Error encountered: " + e.getMessage());
        }
    }
}
