import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { BegoneApiProvider } from '../../providers/begone-api/begone-api'
import leaflet from 'leaflet';
import { SharedData } from './../../models/SharedData';

@IonicPage()
@Component({
  selector: "page-velov-map",
  templateUrl: "velov-map.html"
})
export class VelovMapPage {

  @ViewChild('map') mapContainer;

  subUrl: string;
  map: any;
  defaultZoom: Number;
  initialCenter: any;
  minZoom: Number;
  markersLayer: any;
  selectedStation: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.subUrl = "tcl/velov";
    this.defaultZoom = 16;
    this.initialCenter = [45.767706, 4.836036];
    this.minZoom = 15;

    if (navParams.get("lat") && navParams.get("lon")) {
      this.selectedStation = [
        parseFloat(navParams.get("lat")),
        parseFloat(navParams.get("lon"))
      ];
    } else {
      this.selectedStation = null;
    }
  }

  ionViewDidLoad() {
    this.initMap();
    this.loadStationsInCoordinates();
  }

  getMapBounds() {
    let bounds = this.map.getBounds();
    return {
      nelat: bounds._northEast.lat,
      nelon: bounds._northEast.lng,
      swlat: bounds._southWest.lat,
      swlon: bounds._southWest.lng
    };
  }

  loadStationsInCoordinates() {
    this.api.get(this.subUrl, this.getMapBounds()).subscribe(
      response => {
        this.markersLayer.clearLayers();
        response["velov"].forEach(element => {
          let content = '<strong>Disponibles</strong> : ' + element['bikes_available'] +  
                        '<br><strong>Places</strong> : ' + element['stands_available'] + 
                        '<br><strong>Statut</strong> : ' + element['status']
          let marker = leaflet.marker([element["lon"], element["lat"]]).bindPopup(content);
          marker.addTo(this.markersLayer);
          if (SharedData.getFocusVelovStationCoordinates() != undefined) { // Si on a sélectionné une station depuis la liste
            marker.openPopup();
            SharedData.setFocusVelovStationCoordinates(null, null);
          }
        });
      },
      error => {
        this.markersLayer.clearLayers();
      }
    );
  }

  initMap() {
    this.map = leaflet.map(this.mapContainer.nativeElement, {
      zoom: SharedData.getFocusVelovStationCoordinates() !== undefined ? 18 : this.defaultZoom,
      center: SharedData.getFocusVelovStationCoordinates() !== undefined ? SharedData.getFocusVelovStationCoordinates() : this.initialCenter,
      minZoom: this.minZoom,
    });
    leaflet.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", { noWrap: true }).addTo(this.map);
    this.markersLayer = leaflet.layerGroup();
    this.map.addLayer(this.markersLayer); // Le layer ajouté à l'initialisation de la map est vide
    this.map.on("moveend", () => {
      this.loadStationsInCoordinates();
    });
  }
}
