import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the TramwayPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-tramway',
  templateUrl: 'tramway.html',
})
export class TramwayPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('DidLoad TramwayPage');
  }

  ionViewWillEnter() {
    console.log('WillEnter TramwayPage');
  }

  ionViewDidEnter() {
    console.log('DidEnter TramwayPage');
  }

  ionViewWillLeave() {
    console.log('WillLeave TramwayPage');
  }

  ionViewDidLeave() {
    console.log('DidLeave TramwayPage');
  }

  ionViewWillUnload() {
    console.log('WillUnload TramwayPage');
  }

}
