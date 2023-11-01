import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { BegoneApiProvider } from '../../providers/begone-api/begone-api'
import leaflet from 'leaflet';

/**
 * Generated class for the InterestPointPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-interest-point',
  templateUrl: 'interest-point.html',
})
export class InterestPointPage {

  @ViewChild('map') mapContainer;

  pointId: Number;
  pointInfo: any;
  subUrl: string;
  map: any;
  defaultZoom: Number;
  initialCenter: any;
  markersLayer: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.pointId = this.navParams.get('id');
    this.subUrl = 'city/tourism/' + String(this.pointId);
    this.defaultZoom = 15;
    this.initialCenter = [ 45.767706, 4.836036 ];
    this.pointInfo = null;
    this.map = null;
  }

  ionViewDidLoad() {
    this.initMap();
    this.loadPointInfo();
  }

  loadPointInfo() {
    this.api.get(this.subUrl).subscribe(
      response => {
        this.pointInfo = response['point'];
        leaflet.marker([ this.pointInfo['lon'], this.pointInfo['lat'] ]).addTo(this.markersLayer);
        // Go to marker
        this.map.flyTo([ this.pointInfo['lon'], this.pointInfo['lat'] ]);
        console.log('point info ok');
      }
    ),
      error => {
        console.log('interest-point.ts::loadPointInfo', error);
      }
  }

  initMap() {
    this.map = leaflet.map(this.mapContainer.nativeElement, {
      zoom: this.defaultZoom,
      center: this.initialCenter
    });
    leaflet.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', { noWrap: true }).addTo(this.map);
    this.markersLayer = leaflet.layerGroup();
    this.map.addLayer(this.markersLayer); // Le layer ajouté à l'initialisation de la map est vide
  }

}
