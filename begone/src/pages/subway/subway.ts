import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the SubwayPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-subway',
  templateUrl: 'subway.html',
})
export class SubwayPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('DidLoad SubwayPage');
  }

  ionViewWillEnter() {
    console.log('WillEnter SubwayPage');
  }

  ionViewDidEnter() {
    console.log('DidEnter SubwayPage');
  }

  ionViewWillLeave() {
    console.log('WillLeave SubwayPage');
  }

  ionViewDidLeave() {
    console.log('DidLeave SubwayPage');
  }

  ionViewWillUnload() {
    console.log('WillUnload SubwayPage');
  }

}
