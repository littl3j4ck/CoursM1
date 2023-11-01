import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Platform, ActionSheetController } from 'ionic-angular';
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'
import leaflet from 'leaflet'

/**
 * Generated class for the WastesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-waste',
  templateUrl: 'waste.html',
})
export class WastePage {

  @ViewChild('map') mapContainer;

  map: any;
  defaultZoom: number;
  initialCenter: any;
  markersLayer: any;
  subUrl: string;
  minZoom: number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider, public platform: Platform, public actionsheetCtrl: ActionSheetController) {
    this.defaultZoom = 13;
    this.initialCenter = [ 45.767706, 4.836036 ];
    this.subUrl = 'city/waste';
    this.minZoom = 13;
  }
   
  ionViewDidLoad() {
    this.initMap(); // Init map
    this.loadWastesPointsInCoordinates() // A l'affichage de la page la map n'a pas bougé donc aucune poubelle --> on force l'actualisation
  }

  getMapBounds() {
    let bounds = this.map.getBounds();
    return {
      nelat: bounds._northEast.lat,
      nelon: bounds._northEast.lng,
      swlat: bounds._southWest.lat,
      swlon: bounds._southWest.lng
    }
  }

  loadWastesPointsInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl, coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers()
        response['Wastes'].forEach(element => {
          leaflet.marker([ element['lon'], element['lat'] ]).bindPopup('<strong>Adresse</strong> : ' + element['number'] + ' ' + element['street'] + '<br>' + element['zip'] + ' ' + element['city']);
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
    this.map.on('moveend', () => {
      this.loadWastesPointsInCoordinates()
    });
  }


}
