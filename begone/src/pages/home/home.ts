import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import "../../models/CHeckingTools" 
import CheckingTools from '../../models/CHeckingTools';
import { checkAndUpdateBinding } from '@angular/core/src/view/util';
import { BegoneApiProvider } from './../../providers/begone-api/begone-api'


@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
})
export class HomePage {

  private weather: any;
  private weatherSubUrl: any;
  private atmo: any;
  private atmoSubUrl: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, private api: BegoneApiProvider) {
    this.weatherSubUrl = 'city/weather/realtime';
    this.atmoSubUrl = 'city/air/score'
  }

  ionViewDidLoad() {
    this.loadWeather();
    this.loadAtmo();
  }

  private loadWeather() {
    this.api.get(this.weatherSubUrl).subscribe(
      response => {
        console.log(response);
        let temp = response['realtime'][0]
        temp['temperature'] = Math.floor(temp['temperature'])
        temp['wind_speed'] = Math.floor(temp['wind_speed'])
        temp['humidity'] = Math.floor(temp['humidity'] * 100)
        this.weather = temp; // A fixer
      },
      error => {
        console.log(error);
      }
    )
  }

  private loadAtmo() {
    this.api.get(this.atmoSubUrl).subscribe(
      response => {
        console.log(response)
        let temp = response['atmo_today'][0]
        temp['value'] = Math.floor(temp['value'])
        this.atmo = response['atmo_today'][0]
      },
      error => {
        console.log(error);
      }
    )
  }

  private getFullDate() {
    var days = ['Dimanche', 'Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'];
    var months = ['janvier','février','mars','avril','mai','juin','juillet','août','septembre','octobre','novembre','décembre'];
    let now = new Date();
    let day = days[ now.getDay() ];
    let month = months[ now.getMonth() ];
    let year = now.getFullYear();
    return day + ' ' + now.getDate() + ' ' + month + ' ' + year;
  }
}
