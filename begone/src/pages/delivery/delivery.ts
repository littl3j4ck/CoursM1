import { Component, ViewChild, ElementRef } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {BegoneApiProvider} from './../../providers/begone-api/begone-api';
import leaflet from 'leaflet'

/**
 * Generated class for the DeliveryPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-delivery',
  templateUrl: 'delivery.html',
})
export class DeliveryPage {

  @ViewChild('map') mapContainer;

  map : any;
  defaultZoom : number;
  initialCenter : any;
  markersLayer : any;
  subUrl: string;
  minZoom: Number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.defaultZoom = 16;
    this.initialCenter = [45.767706, 4.83036]
    this.subUrl = 'parkings/delivery'
    this.minZoom = 15
  }

  ionViewDidLoad() {
    this.initMap();
    this.loadDeliveryInCoordinates();
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

  loadDeliveryInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl,coordinates).subscribe(
        response => {
          this.markersLayer.clearLayers()
          response['delivery_points'].forEach(element => {
            leaflet.marker([element['lat'],element['lon']]).bindPopup('<strong>Adresse</strong> : ' + element['name'] + '<br><strong>Emplacements</strong> : '+ element['spots']+ '<br><strong>Horaires</strong> :' +element['availability']).addTo(this.markersLayer)
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
    this.map.addLayer(this.markersLayer);
    this.map.on('moveend', () => {
      this.loadDeliveryInCoordinates()
    });
  }
}

