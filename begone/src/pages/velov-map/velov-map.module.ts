import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { VelovMapPage } from './velov-map';

@NgModule({
  declarations: [
    VelovMapPage,
  ],
  imports: [
    IonicPageModule.forChild(VelovMapPage),
  ],
})
export class VelovMapPageModule {}
