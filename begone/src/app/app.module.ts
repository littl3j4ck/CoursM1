import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePageModule } from '../pages/home/home.module';
import { SubwayPageModule } from '../pages/subway/subway.module'
import { BusPageModule } from '../pages/bus/bus.module'
import { DeliveryPageModule } from '../pages/delivery/delivery.module'
import { InterestPointPageModule } from '../pages/interest-point/interest-point.module'
import { MotorbikePageModule } from '../pages/motorbike/motorbike.module'
import { ParkingsPageModule } from '../pages/parkings/parkings.module'
import { TownHallPageModule } from '../pages/town-hall/town-hall.module'
import { TramwayPageModule } from '../pages/tramway/tramway.module'
import { TrashsPageModule } from '../pages/trashs/trashs.module'
import { InvalidParksPageModule } from '../pages/invalid-parks/invalid-parks.module'
import { TecelyPageModule } from '../pages/tecely/tecely.module'
import { InterestPointTypesPageModule } from "../pages/interest-point-types/interest-point-types.module"
import { InterestPointListPageModule } from "../pages/interest-point-list/interest-point-list.module"
import { VelovPageModule } from '../pages/velov/velov.module'
import { VelovNearestPageModule } from '../pages/velov-nearest/velov-nearest.module'
import { VelovMapPageModule } from '../pages/velov-map/velov-map.module'
import { StatusBar } from '@ionic-native/status-bar'
import { SplashScreen } from '@ionic-native/splash-screen'
import { BegoneApiProvider } from '../providers/begone-api/begone-api'
import { HttpClientModule } from '@angular/common/http'
import { BikesPageModule } from './../pages/bikes/bikes.module';
import { WastePageModule } from './../pages/waste/waste.module';
import { TrafficWarningPageModule } from './../pages/traffic-warning/traffic-warning.module';
import { Diagnostic } from '@ionic-native/diagnostic';
import { Geolocation } from '@ionic-native/geolocation';

@NgModule({
  declarations: [
    MyApp
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpClientModule,
    SubwayPageModule,
    BusPageModule,
    DeliveryPageModule,
    InterestPointPageModule,
    MotorbikePageModule,
    ParkingsPageModule,
    TownHallPageModule,
    HomePageModule,
    TramwayPageModule,
    TrashsPageModule,
    WastePageModule,
    InvalidParksPageModule,
    TecelyPageModule,
    InterestPointTypesPageModule,
    InterestPointListPageModule,
    VelovPageModule,
    VelovNearestPageModule,
    VelovMapPageModule,
    BikesPageModule,
    TrafficWarningPageModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    BegoneApiProvider,
    Diagnostic,
    Geolocation
  ]
})
export class AppModule {}
