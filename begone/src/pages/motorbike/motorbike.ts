import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import leaflet from 'leaflet'
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'

/**
 * Generated class for the MotorbikePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-motorbike',
  templateUrl: 'motorbike.html',
})
export class MotorbikePage {

  @ViewChild('map') mapContainer;

  map: any;
  defaultZoom: Number;
  initialCenter: any;
  markersLayer: any;
  subUrl: string;
  minZoom: Number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.defaultZoom = 16;
    this.initialCenter = [ 45.767706, 4.836036 ]
    this.subUrl = 'parkings/motorbike'
    this.minZoom = 13
  }

   /**
   * Cette fonction sera automatiquement appelée lors de l'initialisation de la page Tecely
   */
  ionViewDidLoad() {
    this.initMap(); // Init map
    this.loadMotorbikeInCoordinates() // A l'affichage de la page la map n'a pas bougé donc aucune poubelle --> on force l'actualisation
  }


  // Cette fonction retourne un json des coordonnées ciblées par la map
  getMapBounds() {
    let bounds = this.map.getBounds();
    return {
      nelat: bounds._northEast.lat,
      nelon: bounds._northEast.lng,
      swlat: bounds._southWest.lat,
      swlon: bounds._southWest.lng
    }
  }

  loadMotorbikeInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl, coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers()
        response['motorcycles_points'].forEach(element => {
          leaflet.marker([ element['lat'], element['lon'] ]).bindPopup('<strong>Adresse</strong> : ' + element['name'] + '<br><strong>Longueur</strong> : ' + element['length'] + ' mètres').addTo(this.markersLayer)
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
      this.loadMotorbikeInCoordinates()
    });
  }
}