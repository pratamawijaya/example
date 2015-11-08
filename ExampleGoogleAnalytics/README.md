# Example how to use Google Analytics


## Setup 
- put google-services.json
- change analtics id and project id, number, etc

## Send Tracking 
-  `mTracker.setScreenName("Screen Name");` for sending screen
- `mTracker.send(
               new HitBuilders.EventBuilder().setCategory("Action").setAction("Fab Click").build());` example sending button click event