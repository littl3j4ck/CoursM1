import { Injectable } from '@angular/core';

@Injectable()
export class SharedData {

    private static focusVelovStationCoordinates = undefined;

    static setFocusVelovStationCoordinates(lat, lon) {
        if (lat === null || lon === null) {
            SharedData.focusVelovStationCoordinates = undefined;
        } else {
            SharedData.focusVelovStationCoordinates = [ lat, lon ];
        }
    } 

    static getFocusVelovStationCoordinates() {
        return SharedData.focusVelovStationCoordinates;
    }
}