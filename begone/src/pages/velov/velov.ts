import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Events, Tabs } from 'ionic-angular';
import { VelovNearestPage } from '../velov-nearest/velov-nearest'
import { VelovMapPage } from '../velov-map/velov-map'

@IonicPage()
@Component({
  selector: 'page-velov',
  templateUrl: 'velov.html',
})
export class VelovPage {

  @ViewChild("velov_tabs") tabs: Tabs;
  nearest: any;
  mapPage: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private events: Events) {
    this.nearest = VelovNearestPage
    this.mapPage = VelovMapPage
    this.events.subscribe("velov:gotomap", () => {
      this.tabs.select(1);
    });
  }

  ionViewDidLoad() {
  }

}
