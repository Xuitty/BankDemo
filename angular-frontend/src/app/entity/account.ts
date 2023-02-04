import { Decimal } from 'decimal.js';

export class Account {
  aid?: number;
  atype?: number;
  aaccount?: string;
  abalance?: Decimal;
  aactive?: number;
  averify?: string;
  uid?: number;
  statuss?: number;
  message?: string;
}
