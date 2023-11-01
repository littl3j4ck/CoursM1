import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { SubwayPage } from './../pages/subway/subway'
import { BusPage } from './../pages/bus/bus'
import { DeliveryPage } from './../pages/delivery/delivery'
import { InterestPointTypesPage } from './../pages/interest-point-types/interest-point-types'
import { MotorbikePage } from './../pages/motorbike/motorbike'
import { ParkingsPage } from './../pages/parkings/parkings'
import { TownHallPage } from './../pages/town-hall/town-hall'
import { TramwayPage } from './../pages/tramway/tramway'
import { TrashsPage } from './../pages/trashs/trashs'
import { InvalidParksPage } from './../pages/invalid-parks/invalid-parks'
import { TecelyPage } from '../pages/tecely/tecely';
import { VelovPage } from '../pages/velov/velov'
import { BikesPage } from './../pages/bikes/bikes'
import { TrafficWarningPage } from '../pages/traffic-warning/traffic-warning';
import { Diagnostic } from '@ionic-native/diagnostic';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = HomePage;
  pages: Array<{id: Number, title: string, component: any, icon: string, subs: Array<{id: Number, subTitle: string, subComponent: any, subIcon: string}>}>;
  expandedGroupId: Number;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen, private diagnostic: Diagnostic) {
    this.initializeApp();

    // Menus de l'application, actuellement FIXES ils seront ensuite chargés en fonction des préférences de l'utilisateur
    this.pages = [
      {
        id: 1,
        title: 'Accueil',
        component: HomePage,
        icon: 'home',
        subs: []
      },
      {
        id: 2,
        title: 'TCL',
        component: null,
        icon: 'ios-subway',
        subs: [ {
            id: 3,
            subTitle: "Métro",
            subComponent: SubwayPage,
            subIcon: "ios-subway"
          }, {
            id: 4,
            subTitle: "Tramway",
            subComponent: TramwayPage,
            subIcon: "ios-train"
          }, {
            id: 5,
            subTitle: "Bus",
            subComponent: BusPage,
            subIcon: "bus"
          }, {
            id: 18,
            subTitle: "Bornes Técély",
            subComponent: TecelyPage,
            subIcon: null
          }, {
            id: 19,
            subTitle: "Vélo'v",
            subComponent: VelovPage,
            subIcon: null
          }
        ]
      },
      { 
        id: 500,
        title: 'Ville', 
        component: null,
        icon: 'ios-train',
        subs: [ {
            id: 20,
            subTitle: "Chantiers perturbants",
            subComponent: TrafficWarningPage,
            subIcon: "ios-subway"
          }
        ]
      },
      { 
        id: 6,
        title: 'Emplacements',
        component: null,
        icon: 'ios-car',
        subs: [
          {
            id: 7,
            subTitle: 'Places Motos',
            subComponent: MotorbikePage,
            subIcon: "any"
          },
          {
            id: 8,
            subTitle: 'Places Handicapées',
            subComponent: InvalidParksPage,
            subIcon: "any"
          },
          {
            id: 9,
            subTitle: 'Parkings',
            subComponent: ParkingsPage,
            subIcon: "any"
          },
          {
            id: 10,
            subTitle: 'Livraisons',
            subComponent: DeliveryPage,
            subIcon: "any" 
          },
          { 
            id: 18,
            subTitle: 'Parcs vélos', 
            subComponent: BikesPage,
            subIcon: "any" 
          }
            ]
      },
      {
        id: 11,
        title : 'Points touristiques',
        component : null,
        icon: 'ios-map',
        subs: [
          {
            id: 12,
            subTitle: 'Points d\'intérêt',
            subComponent: InterestPointTypesPage,
            subIcon: "any"
          }
            ]
      }, {
        id: 15,
        title : 'Divers',
        component : null,
        icon: 'ios-trash',
        subs: [
          {
            id: 16,
            subTitle: "Corbeilles",
            subComponent: TrashsPage,
            subIcon: "any"
          }, {
            id: 13,
            subTitle : 'Mairies',
            subComponent : TownHallPage,
            subIcon: 'ios-home'
          },
        ]
      }
    ];

  }

  isGroupShown (id: Number) {
    return this.expandedGroupId === id
  }

  // Déplie ou replie le groupe de menus
  toggleGroup (id: Number) {
    if (this.expandedGroupId === id) { // Le groupe était déjà déplié, on le ferme
      this.expandedGroupId = null;
    } else { // Le groupe n'était pas déplié, on le déplie
      this.expandedGroupId = id;
    }
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.backgroundColorByHexString('#b41317');
      this.statusBar.isVisible = true;
      this.splashScreen.hide();
      // Permissions pour APP
      if (this.platform.is('android')) {
        this.diagnostic.requestLocationAuthorization()
          .then((state) => {
            console.log(state)
          })
          .catch((err) => {
            console.log(err);
          })
      }
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page);
  }
}


