import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { InterestPointListPage } from './interest-point-list';

@NgModule({
  declarations: [
    InterestPointListPage,
  ],
  imports: [
    IonicPageModule.forChild(InterestPointListPage),
  ],
})
export class InterestPointListPageModule {}
