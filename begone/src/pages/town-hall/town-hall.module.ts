import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TownHallPage } from './town-hall';

@NgModule({
  declarations: [
    TownHallPage,
  ],
  imports: [
    IonicPageModule.forChild(TownHallPage),
  ],
})
export class TownHallPageModule {}
