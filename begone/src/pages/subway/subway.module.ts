import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SubwayPage } from './subway';

@NgModule({
  declarations: [
    SubwayPage,
  ],
  imports: [
    IonicPageModule.forChild(SubwayPage),
  ],
})
export class SubwayPageModule {}
