import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {BegoneApiProvider} from "../../providers/begone-api/begone-api";
import { InterestPointListPage } from "../../pages/interest-point-list/interest-point-list"

/**
 * Generated class for the InterestPointListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-interest-point-types',
  templateUrl: 'interest-point-types.html',
})
export class InterestPointTypesPage {

  subUrl: string;
  types: Array<string>;
  pictures: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.subUrl = 'city/tourism/types';
    this.types = [];
    this.pictures = {
      'COMMERCE_ET_SERVICE': 'epicerie.jpg',
      'DEGUSTATION': 'degustation.jpg',
      'EQUIPEMENT': 'equipement.jpg',
      'HEBERGEMENT_COLLECTIF': 'hebergement_collectif.jpg',
      'HEBERGEMENT_LOCATIF': 'hebergement_locatif.jpg',
      'HOTELLERIE': 'hotellerie.jpg',
      'HOTELLERIE_PLEIN_AIR': 'hotellerie_plein_air.jpg',
      'PATRIMOINE_CULTUREL': 'patrimoine_culturel.jpg',
      'PATRIMOINE_NATUREL': 'patrimoine_naturel.jpg',
      'RESTAURATION': 'restauration.jpg'
    }
  }

  ionViewDidLoad() {
    this.loadTypes()
  }

  private listInterestTypePoint(type) {
    if (this.types.indexOf(type) > -1) {
      this.navCtrl.push(InterestPointListPage, {
        type: type
      })
    }
  }

  private loadTypes() {
    this.api.get(this.subUrl).subscribe(
      response => {
        this.types = response['types'];
      },
      error => {
        console.log(error)
      });
  }

  private normalizeTypeName(typeName) {
    typeName = typeName.replace(
      /\w\S*/g,
      function(txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
      }
    );
    typeName = typeName.replace(/_/g, ' ');
    return typeName
  }

}
