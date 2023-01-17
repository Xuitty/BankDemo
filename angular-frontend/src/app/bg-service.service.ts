import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BgServiceService {

  constructor() { }
  private bgInit='../assets/indexBg.jpg';

  bgPath:BehaviorSubject<string>=new BehaviorSubject(this.bgInit);
}
