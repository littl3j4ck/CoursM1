import { AlertController } from 'ionic-angular';
import {Geolocation} from '@ionic-native/geolocation';
import {Network} from '@ionic-native/network';



export default class CheckingTools
{
constructor(){}
    //fonction de l'obtention de la localisation GPS
    
    /*static AutorizationGPS()
    //A valider
    {
        var Access : string;

        let diagnostic =new Diagnostic()
        let successCallBack = (autorization) => {
            if (autorization == diagnostic.permissionStatus.GRANTED)
            {
                console.log("Permission autorisé d'utilisé le GPS")
                Access = "GRANTED"
                return Access
            }
            if (autorization == diagnostic.permissionStatus.DENIED)
            {
                console.log("refus d'utilisation le GPS. On peut redemandé")
                Access = "DENIED"
                return Access
            }
            if (autorization == diagnostic.permissionStatus.DENIED_ALWAYS)
            {
                console.log("refus total d'utilisation du GPS")
                Access = "DENIED_ALWAYS"
                return Access
            }
        }
        let errorCallBack = (error) => { console.log(error)}
        diagnostic.requestRuntimePermission(diagnostic.permission.ACCESS_FINE_LOCATION).
        then(successCallBack,errorCallBack)
    }

    static getLocationRequest () 
    //A valider
    {
        let geolocation = new Geolocation();
        //return geolocation.getCurrentPosition()

        geolocation.getCurrentPosition()
        .then((successCallBack)=>
        {
            return successCallBack.coords
        })
        .catch((errorCallBack)=>
        {
            console.log('[CheckingTools.ts::getLocationRequest] ERROR:'+ errorCallBack);
            return ([45.767706, 4.83036])
        })
    }

    static WatchPosition ()
    //A valider
    {
        let geolocation = new Geolocation()
        let positionSubscribtion = geolocation.watchPosition();
        positionSubscribtion.subscribe((coordinates) =>{
            return coordinates.coords
        });
    }

    //fonction de check du réseau
    static Checknetwork()
  {
      
    let network = new Network()
    let connectSubscription = network.onConnect().subscribe(() =>
    {
        console.log('[CheckingTools.ts::CheckNetwork] Connecté');
    });
    //création de la promesse du watcher de déco
    let disconnectSubscription = network.onDisconnect().subscribe(() => 
    {
        
       console.log('[CheckingTools.ts::CheckNetwork] Deconnecté');
    });
   
    connectSubscription;
    disconnectSubscription;
  }*/
}
