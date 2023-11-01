import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import leaflet from 'leaflet'
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'

/**
 * Generated class for the BikesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-bikes',
  templateUrl: 'bikes.html',
})
export class BikesPage {
  @ViewChild('map') mapContainer;

  map: any;
  defaultZoom: Number;
  initialCenter: any;
  markersLayer: any;
  subUrl: string;
  minZoom: Number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.defaultZoom = 18;
    this.initialCenter = [ 45.767706, 4.836036 ]
    this.subUrl = 'parkings/bikes'
    this.minZoom = 16
  }

   /**
   * Cette fonction sera automatiquement appelée lors de l'initialisation de la page Tecely
   */
  ionViewDidLoad() {
    this.initMap(); // Init map
    this.loadBikesInCoordinates() // A l'affichage de la page la map n'a pas bougé donc aucune poubelle --> on force l'actualisation
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

  loadBikesInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    console.log('new coordinates: ', coordinates)
    this.api.get(this.subUrl, coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers()
        response['bikes_parks'].forEach(element => {
          leaflet.marker([ element['lat'], element['lon'] ]).bindPopup(element['name'] + ' - ' + element['adress']).addTo(this.markersLayer)
        });
        this.loading = false;
      },
      error => {
        console.log(error)
        this.loading = false;
      }
    )
  }

  /**
   * Cette fonction va initialiser la map dans le HTML, en lui donnant quelques paramètres de bases.
   * On va également lui indiquer sur quel fournisseurs de tiles elle doit se baser (OpenStreetMap/OSM),
   * également on créé le layer (au début vide) qui contiendra tous les markers.
   *
   * On ajoute un event listener (un écouteur qui permet d'écouter des évènements) sur l'évènement 'moveend'.
   * le bloc de code appelera la fonction loadPointsInCoordinates() dès que l'évènement 'moveend' sera déclenché par la map
   * PS : moveend est un évènement déclenché quand on a FINI de bouger la carte.
   * la liste de tous les évents est présente ici : https://leafletjs.com/reference-1.4.0.html#map-event
   */
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
      this.loadBikesInCoordinates()
    });
  }

}
