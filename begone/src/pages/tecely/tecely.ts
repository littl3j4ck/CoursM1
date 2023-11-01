import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { BegoneApiProvider } from '../../providers/begone-api/begone-api'
import leaflet from 'leaflet'
import { Geoloc } from '../../models/location/Geoloc'

/**
 * Generated class for the TecelyPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-tecely',
  templateUrl: 'tecely.html',
})
export class TecelyPage {
  @ViewChild('map') mapContainer;

  private defaultZoom: Number;
  private initialCenter: any;
  private markersLayer: any;
  private subUrl: string;
  private minZoom: Number;
  private map: any;
  private loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider, private loc: Geoloc) {
    this.defaultZoom = 13;
    this.initialCenter = [ 45.767706, 4.836036 ];
    this.subUrl = 'tcl/tecely';
    this.minZoom = 13;
  }

  ionViewDidLoad() {
    this.initMap();
    this.loadTecelyInCoordinates();
  }

  private getMapBounds() {
    let bounds = this.map.getBounds();
    return {
      nelat: bounds._northEast.lat,
      nelon: bounds._northEast.lng,
      swlat: bounds._southWest.lat,
      swlon: bounds._southWest.lng
    }
  }

  loadTecelyInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl, coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers();
        response['tecely'].forEach(element => {
          leaflet.marker([ element['lat'], element['lon'] ]).bindPopup('<strong>Nom</strong> : ' + element['nom'] + '<br><strong>Adresse</strong> : ' + element['adresse']).addTo(this.markersLayer);
        });
        this.loading = false;
      },
      error => {
        console.log(error);
        this.loading = false;
      }
    )
  }

  private setLocView(coordinates: any, success: boolean) {
    if (success) {
      this.map.flyTo([coordinates[0], coordinates[1]], 19);
    }
  }

  processGeolocation() {
    this.loc.requestPosition(this.setLocView);
  }

  initMap() {
      this.map = leaflet.map(this.mapContainer.nativeElement, {
        zoom: this.defaultZoom,
        center: this.initialCenter,
        minZoom: this.minZoom
      });
      console.log('làà');
      leaflet.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', { noWrap: true }).addTo(this.map);
      this.markersLayer = leaflet.layerGroup();
      this.map.addLayer(this.markersLayer); // Le layer ajouté à l'initialisation de la map est vide
      this.map.on('moveend', () => {
        this.loadTecelyInCoordinates()
      });
  }
}
