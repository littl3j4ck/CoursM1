import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TrafficWarningPage } from './traffic-warning';

@NgModule({
  declarations: [
    TrafficWarningPage,
  ],
  imports: [
    IonicPageModule.forChild(TrafficWarningPage),
  ],
})
export class TrafficWarningPageModule {}
