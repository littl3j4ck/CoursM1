import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ParkingInfosPage } from './parking-infos';

@NgModule({
  declarations: [
    ParkingInfosPage,
  ],
  imports: [
    IonicPageModule.forChild(ParkingInfosPage),
  ],
})
export class ParkingInfosPageModule {}
