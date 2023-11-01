import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { BegoneApiProvider } from '../../providers/begone-api/begone-api';
import { InterestPointPage } from '../interest-point/interest-point';

/**
 * Generated class for the InterestPointListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-interest-point-list',
  templateUrl: 'interest-point-list.html',
})
export class InterestPointListPage {

  type: string;
  subUrl: string;
  points: any;
  loaded: boolean;
  search: string;
  filteredResults: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.type = navParams.get('type');
    this.subUrl = 'city/tourism';
    this.loaded = false;
    this.search = '';
  }

  ionViewDidLoad() {
    this.loadInterestPointsFromType();
  }

  getPointInfos(id) {
    this.navCtrl.push(InterestPointPage, { id: id })
  }

  loadInterestPointsFromType() {
    this.api.get(this.subUrl, { type: this.type }).subscribe(
      response => {
        this.points = this.filteredResults = response['points'];
        this.loaded = true;
      },
      error => {
        console.log('interest-point-list.ts::loadInterestPointsFromType', error);
      }
    );
  }

  filter() {
    console.log('filtering...', this.search);
    if (this.search.trim() === '') {
      this.filteredResults = this.points;
    } else if (this.search.trim().length <= 2) {
      this.filteredResults = this.points;
    } else {
      console.log('else');
      this.filteredResults = this.points.filter(p => 
        p['name'].toLowerCase().indexOf(this.search.toLowerCase()) > -1 ||
        p['address'].toLowerCase().indexOf(this.search.toLowerCase()) > -1 ||
        p['city'].toLowerCase().indexOf(this.search.toLowerCase()) > -1
        )
    }
  }

}
