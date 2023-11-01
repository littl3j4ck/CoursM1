import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { InterestPointTypesPage } from './interest-point-types';

@NgModule({
  declarations: [
    InterestPointTypesPage,
  ],
  imports: [
    IonicPageModule.forChild(InterestPointTypesPage),
  ],
})
export class InterestPointTypesPageModule {}
