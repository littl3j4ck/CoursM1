import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Platform, ActionSheetController } from 'ionic-angular';
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'
import leaflet from 'leaflet'

/**
 * Generated class for the ParkingsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-parkings',
  templateUrl: 'parkings.html',
})
export class ParkingsPage {

  @ViewChild('map') mapContainer;

  map: any;
  defaultZoom: number;
  initialCenter: any;
  markersLayer: any;
  subUrl: string;
  subParkUrl: string;
  minZoom: number;
  loading : boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider, public platform: Platform, public actionsheetCtrl: ActionSheetController) {
    this.defaultZoom = 13;
    this.initialCenter = [ 45.767706, 4.836036 ];
    this.subUrl = 'parkings/parks';
    this.minZoom = 13;
  }
  
  /**
   * Cette fonction sera automatiquement appelée lors de l'initialisation de la page Parkings
   */

   
  ionViewDidLoad() {
    this.initMap(); // Init map
    this.loadParkingsPointsInCoordinates() // A l'affichage de la page la map n'a pas bougé donc aucune poubelle --> on force l'actualisation
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

  loadParkingsPointsInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl, coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers()
        response['parkings'].forEach(element => {
          leaflet.marker([ element['lon'], element['lat'] ]).on('click',()=> {this.openParkingInfos(element['id'],element['name'],element['state'],element['lon'],element['lat'])}).addTo(this.markersLayer)  
        });
        this.loading = false
      },
      error => {
        console.log(error)
        this.loading = false
      }
    )
  }

  openParkingInfos(id, name, places, lon, lat) {
    this.map.setZoom(16);
    this.map.flyTo([ lon, lat ]);
    let actionSheet = this.actionsheetCtrl.create({
      title: name,
      cssClass: 'action-sheets-basic-page',
      enableBackdropDismiss: true,
      buttons: [
        {
          text: 'Places disponibles : ' + places,
          icon:  'car',
          role: 'destructive'
        },
        {
          text: 'J\'y vais',
          icon: 'arrow-round-forward'
        }  
      ]
    })
    actionSheet.present();
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
      this.loadParkingsPointsInCoordinates()
    });
  }


}
