import { Decimal } from 'decimal.js';

export class Account {
  aid?: number;
  atype?: number;
  aaccount?: string;
  abalance?: Decimal;
  aactive?: number;
  uid?: number;
  status?: number;
  message?: string;
}
