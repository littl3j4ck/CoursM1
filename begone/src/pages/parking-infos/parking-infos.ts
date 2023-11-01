import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { BegoneApiProvider } from '../../providers/begone-api/begone-api'
import leaflet from 'leaflet';

/**
 * Generated class for the ParkingInfosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-parking-infos',
  templateUrl: 'parking-infos.html',
})
export class ParkingInfosPage {

  parkingId: number;
  parkingInfo: any;
  subUrl: string;
  map: any;
  defaultZoom: number;
  initialCenter: any;
  markersLayer: any;
  parkingLat: number;
  parkingLon: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.parkingId = this.navParams.get('id');
    this.subUrl = 'parkings/parks/' + String(this.parkingId);
    this.defaultZoom = 15;
    this.initialCenter = [ 45.767706, 4.836036 ];
    this.parkingInfo = null;
    this.map = null;
  }

 
  ionViewWillEnter() {
    this.closeMap();
    this.initMap();
    this.loadParkingInfos();
  }

  ionViewDidLeave() { 
  }

  ionViewWillUnload() {
    this.closeMap()
  }

  /**
   * Libère les ressources matérielles attribuées à la map
   */
  closeMap() {
    if (this.map !== null) {
      this.map.off();
      this.map.remove();
    }
  }

  loadParkingInfos() {
    this.api.get(this.subUrl).subscribe(
      response => {
        this.parkingInfo = response['parking'];
        leaflet.marker([ this.parkingInfo['lon'], this.parkingInfo['lat'] ]).addTo(this.markersLayer);
        // Go to marker
        this.map.flyTo([ this.parkingInfo['lon'], this.parkingInfo['lat'] ]);
        console.log('parking info ok');
      }
    ),
      error => {
        console.log('parking-infos.ts::loadParkingInfos', error);
      }
  }

  initMap() {
    this.map = leaflet.map("map", {
      zoom: this.defaultZoom,
      center: this.initialCenter
    });
    leaflet.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', { noWrap: true }).addTo(this.map);
    this.markersLayer = leaflet.layerGroup();
    this.map.addLayer(this.markersLayer); // Le layer ajouté à l'initialisation de la map est vide
  }

}
