import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { InterestPointPage } from './interest-point';

@NgModule({
  declarations: [
    InterestPointPage,
  ],
  imports: [
    IonicPageModule.forChild(InterestPointPage),
  ],
})
export class InterestPointPageModule {}
