import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import leaflet from 'leaflet'
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'
/**
 * Generated class for the TownHallPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-town-hall',
  templateUrl: 'town-hall.html',
})
export class TownHallPage {

  @ViewChild('map') mapContainer;

  map: any;
  defaultZoom: Number;
  initialCenter: any;
  markersLayer: any;
  subUrl: string;
  minZoom: Number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.defaultZoom = 13;
    this.initialCenter = [ 45.767706, 4.836036 ]
    this.subUrl = 'city/halls'
    this.minZoom = 13
  }

  
  ionViewDidLoad() {
    this.initMap(); // Init map
    this.loadHallsInCoordinates() // A l'affichage de la page la map n'a pas bougé donc aucune poubelle --> on force l'actualisation
  }

  loadHallsInCoordinates() {
    this.loading = true;
    this.api.get(this.subUrl).subscribe(
      response => {
        //this.markersLayer.clearLayers()
        response['town_halls'].forEach(element => {
          leaflet.marker([ element['lon'], element['lat'] ]).bindPopup('<strong>Mairie</strong> : ' + element['name']).addTo(this.markersLayer)
        });
        this.loading = false;
      },
      error => {
        console.log(error)
        this.loading = false;
      }
    )
  }

  initMap() {
    this.map = leaflet.map(this.mapContainer.nativeElement, {
      zoom: this.defaultZoom,
      center: this.initialCenter,
      minZoom: this.minZoom
    });
    leaflet.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', { noWrap: true }).addTo(this.map);
    this.markersLayer = leaflet.layerGroup();
    this.map.addLayer(this.markersLayer) // Le layer ajouté à l'initialisation de la map est vide
    
  }

}
