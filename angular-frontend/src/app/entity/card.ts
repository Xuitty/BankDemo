import { Decimal } from 'decimal.js';

export class Card {
  cid?: number;
  ctype?: number;
  cnumber?: string;
  cdate?: string;
  cccv?: string;
  cccv_salt?: string;
  cactive?: string;
  ccurrent?: Decimal;
  climit?: Decimal;
  cfailed?: number;
  aid?: number;
  uid?: number;
  status?: number;
  message?: string;
}
