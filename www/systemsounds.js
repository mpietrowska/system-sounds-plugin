var exec = require('cordova/exec');

var systemsounds = {
    getSystemNotificationSounds : function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, 'SystemSounds', 'getSystemNotificationSounds', [])
    }
}

module.exports = systemsounds;