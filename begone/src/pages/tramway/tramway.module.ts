import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TramwayPage } from './tramway';

@NgModule({
  declarations: [
    TramwayPage,
  ],
  imports: [
    IonicPageModule.forChild(TramwayPage),
  ],
})
export class TramwayPageModule {}
