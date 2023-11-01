import { Geolocation } from '@ionic-native/geolocation';

export class Geoloc {

    constructor(private geolocation: Geolocation) { }

    public requestPosition(callback: (coordinates: any, success: boolean) => any) {
        this.geolocation.getCurrentPosition()
            .then((resp) => {
                callback([ resp.coords.latitude, resp.coords.longitude ], true);
            })
            .catch((error) => {
                console.log(error);
                callback(null, false);
            });
    }
    
}
