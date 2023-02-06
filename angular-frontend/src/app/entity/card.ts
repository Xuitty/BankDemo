import { Decimal } from 'decimal.js';

export class Card {
  cid?: number;
  ctype?: number;
  cnumber?: string;
  cdate?: string;
  cccv?: string;
  cccv_salt?: string;
  cactive?: string;
  ccurrent?: string;
  climit?: string;
  cfailed?: number;
  cverify?: string;
  aid?: number;
  uid?: number;
  statuss?: number;
  message?: string;
}
