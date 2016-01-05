var exec = require('cordova/exec');

var systemsounds = {
    getSystemNotificationSounds : function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'SystemSounds', 'getSystemNotificationSounds', [])
    },
    playSound : function(uriString, successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'SystemSounds', 'playSound', [uriString])
    },
    getDefaultNotificationSound : function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'SystemSounds', 'getDefaultNotificationSound', [])
    }
}

module.exports = systemsounds;