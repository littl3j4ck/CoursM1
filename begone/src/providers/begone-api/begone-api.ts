import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the BegoneApiProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class BegoneApiProvider {

  baseUrl: string

  constructor(public http: HttpClient) {
    this.baseUrl = 'http://api.begone.ovh/' // Le slash a la fin permet d'éviter d'avoir à le remettre en permanence
  }

  get(path: string, params?: any) {
    // 'url' : va contenir un subpath, exemple : city/tourism/277577
    var api_url = this.baseUrl + path;
    return this.http.get(api_url, { params: params }) // Retourne un objet de type : je suis une requête HTTP forgée, prête à être exécutée 
  }

}
