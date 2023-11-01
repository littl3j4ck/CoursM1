import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TrashsPage } from './trashs';

@NgModule({
  declarations: [
    TrashsPage,
  ],
  imports: [
    IonicPageModule.forChild(TrashsPage),
  ],
})
export class TrashsPageModule {}
