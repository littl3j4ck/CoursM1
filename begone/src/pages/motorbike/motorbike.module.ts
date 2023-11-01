import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { MotorbikePage } from './motorbike';

@NgModule({
  declarations: [
    MotorbikePage,
  ],
  imports: [
    IonicPageModule.forChild(MotorbikePage),
  ],
})
export class MotorbikePageModule {}
