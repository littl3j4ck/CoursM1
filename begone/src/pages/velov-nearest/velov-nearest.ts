import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Events } from 'ionic-angular';
import { BegoneApiProvider } from './../../providers/begone-api/begone-api';
import { SharedData } from './../../models/SharedData';

@IonicPage()
@Component({
  selector: "page-velov-nearest",
  templateUrl: "velov-nearest.html"
})
export class VelovNearestPage {
  loaded: Boolean;
  subUrl: string;
  stands: any;
  bikes: any;
  TEMPargs: any;
  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    private api: BegoneApiProvider,
    private events: Events
  ) {
    this.subUrl = "tcl/velov";
    this.TEMPargs = { // before geolocation
      nearest: true,
      lat: 45.767102,
      lon: 4.836082
    }
  }

  ionViewDidLoad() {
    this.loadNearestStations();
  }


  loadNearestStations(refresher=undefined) {
    this.api.get(this.subUrl, this.TEMPargs).subscribe(
      response => {
        this.stands = response["stands"];
        this.bikes = response["bikes"];
        if (refresher) {
          refresher.complete();
        }
      },
      error => {
        console.log(error);
        if (refresher) {
          refresher.complete();
        }
      }
    );
  }

  goToStation(lat, lon) {
    SharedData.setFocusVelovStationCoordinates(lat, lon);
    this.events.publish('velov:gotomap')
  }

  countMessage(val, type) {
    if (val > 1) {
      if (type === "stands") {
        return val + " places disponibles";
      } else {
        return val + " Vélo'v disponibles";
      }
    } else {
      if (type === "stands") {
        return val + " place disponible";
      } else {
        return val + " Vélo'v disponible";
      }
    }
  }
}
