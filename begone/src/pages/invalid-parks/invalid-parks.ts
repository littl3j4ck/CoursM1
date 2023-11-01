import { Component, ElementRef,ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {BegoneApiProvider} from './../../providers/begone-api/begone-api';
import leaflet from 'leaflet'



/**
 * Generated class for the InvalidParksPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-invalid-parks',
  templateUrl: 'invalid-parks.html',
})
export class InvalidParksPage {

  @ViewChild('map') mapContainer;

  map : any;
  defaultZoom: number;
  initialCenter: any;
  markersLayer :any;
  subUrl: string;
  minZoom: Number;
  loading: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.defaultZoom = 13;
    this.initialCenter = [45.767706, 4.836036]
    this.subUrl = 'parkings/handicap'
    this.minZoom = 13
  }

  ionViewDidLoad() {
    this.initMap();
    this.loadInvalidParksInCoordinates();
  }

  getMapBounds() {
    let bounds = this.map.getBounds();
    return {
      nelat: bounds._northEast.lat,
      nelon:  bounds._northEast.lng,
      swlat:  bounds._southWest.lat,
      swlon:  bounds._southWest.lng
    }
  }

  loadInvalidParksInCoordinates() {
    this.loading = true;
    let coordinates = this.getMapBounds();
    this.api.get(this.subUrl,coordinates).subscribe(
      response => {
        this.markersLayer.clearLayers()
        response['mobility_park_points'].forEach(element => {
          leaflet.marker([element['lat'],element['lon']]).bindPopup(element['name']).addTo(this.markersLayer)
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
      this.loadInvalidParksInCoordinates()
    });
  }
}



