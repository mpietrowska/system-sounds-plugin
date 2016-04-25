# system-sounds-plugin

## How to use

Get the list of system notification sounds:

	systemsounds.getSystemNotificationSounds(function (json) {
        console.log(json);
    }, function () {
    	console.log('error');
    });
    
    /** Result
    
    	{
    		"sound_name_1": "sound_URI_1",
        	"sound_name_2": "sound_URI_2"
   		}
     */

Play a sound:

	systemsounds.playSound(soundUri, function () {
        console.log('success');
    }, function () {
    	console.log('error');
    });

Get default notification sound URI:

	systemsounds.getDefaultNotificationSound(function (defaultURI) {
        console.log(defaultURI);
    }, function () {
    	console.log('error');
    });



